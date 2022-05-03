package ceng.estu.group2.shoebasketweb.business.concrete;

import ceng.estu.group2.shoebasketweb.business.abstracts.ModelService;
import ceng.estu.group2.shoebasketweb.convertors.ModelConverter;
import ceng.estu.group2.shoebasketweb.convertors.RatedModelsConverter;
import ceng.estu.group2.shoebasketweb.core.util.results.*;
import ceng.estu.group2.shoebasketweb.dataaccess.abstracts.ModelDao;
import ceng.estu.group2.shoebasketweb.dataaccess.abstracts.RatedModelsDao;
import ceng.estu.group2.shoebasketweb.dataaccess.concretes.ModelRepositoryImpl;
import ceng.estu.group2.shoebasketweb.dto.ModelDto;
import ceng.estu.group2.shoebasketweb.dto.RatedModelsDto;
import ceng.estu.group2.shoebasketweb.entities.Model;
import ceng.estu.group2.shoebasketweb.entities.RatedModels;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import ceng.estu.group2.shoebasketweb.requests.ModelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author reuzun
 */
@Service
public class ModelManager implements ModelService {

    private final ModelDao modelDao;
    private final ModelRepositoryImpl modelRepositoryImpl;
    private final RatedModelsDao ratedModelsDao;

    @Autowired
    public ModelManager(ModelDao shoeDao, ModelRepositoryImpl modelRepositoryImpl, RatedModelsDao ratedModelsDao){
        this.modelDao = shoeDao;
        this.modelRepositoryImpl = modelRepositoryImpl;
        this.ratedModelsDao = ratedModelsDao;
    }

    @Override
    public DataResult<List<ModelDto>> getRandomModels(int limit) {
        return this.modelRepositoryImpl.getRandomModel(limit);
    }

    @Override
    public DataResult<List<Shoe>> getShoesByModelId(int modelId) {
        Optional<Model> model = this.modelDao.findById(modelId);
        if(model.isPresent())
            return new SuccessDataResult<>(model.get().getShoeList());
        else
            return new ErrorDataResult<>("No such model.");

    }


    @Override
    public DataResult<Model> updatePrice(int id, double price) {
        Optional<Model> model = this.modelDao.findById(id);
        if(model.isPresent()) {
            Model s = model.get();
            s.setPrice(price);
            return new SuccessDataResult<>(this.modelDao.save(s));
        }
        else
            return new ErrorDataResult<>("No such shoe.");
    }



    @Override
    public DataResult<List<RatedModelsDto>> getRates(int id) {

        return new SuccessDataResult<>(this.modelDao.findById(id).get().getRates()
                .stream().map(RatedModelsConverter::RatedModelsToRatedModelsDto)
                .collect(Collectors.toList()));
    }

    @Override
    public DataResult<RatedModelsDto> addRate(int id, RatedModelsDto ratedModelsDto) {
        if(ratedModelsDto.getStar() > 5 || ratedModelsDto.getStar() < 1)
            return new ErrorDataResult<>(null ,"Invalid Rating");


        RatedModels ratedModels = this.ratedModelsDao.findByUser_UsernameAndModel_ModelId(ratedModelsDto.getUsername(), id);
        if(null != ratedModels){
            ratedModels.setStar(ratedModelsDto.getStar());
            this.ratedModelsDao.save(ratedModels);
            return new SuccessDataResult<>(ratedModelsDto, "Updated");
        }else {

            ratedModels = RatedModelsConverter.RatedModelsDtoToRatedModels(ratedModelsDto);
            ratedModels.getModel().setModelId(id);
            this.ratedModelsDao.save(ratedModels);

            return new SuccessDataResult<>(ratedModelsDto, "Added");
        }
    }

    @Override
    public Result addModel(ModelRequest modelRequest) {
        this.modelDao.save( ModelConverter.copyRequest(modelRequest) );
        return new SuccessResult("Model added");
    }

    @Override
    public Result deleteModel(int modelId) {
        this.modelDao.delete(this.modelDao.getById(modelId));
        //this.modelDao.deleteByModelId(modelId);
        return new SuccessResult("Model Deleted.");
    }

    @Override
    public DataResult<ModelDto> getById(int id) {
        return new SuccessDataResult<>(ModelConverter.ModelToModelDto(this.modelDao.getById(id)), "success");
    }

    @Override
    public DataResult<List<Model>> getAllByModelNameContainsAndBrandNameContainsOrderByModelIdDesc(String modelName, String brandName) {
        return new SuccessDataResult<>(  this.modelDao.getAllByModelNameContainsAndBrandNameContainsOrderByModelIdDesc(modelName, brandName) );
    }

    @Override
    public DataResult<List<ModelDto>> list() {
        return this.modelRepositoryImpl.getAll();
    }

    @Override
    public DataResult<Model> updateModel(int modelId, ModelRequest modelRequest) {
        Model model = this.modelDao.getById(modelId);
        ModelConverter.copyRequestFields(modelRequest, model);
        return new SuccessDataResult<>(this.modelDao.save(model));
    }


}
