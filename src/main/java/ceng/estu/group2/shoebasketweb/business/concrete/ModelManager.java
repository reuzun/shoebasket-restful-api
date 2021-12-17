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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
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
    public DataResult<List<Model>> getRandomShoes(int limit) {
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
    public DataResult<Set<String>> getShoesColorsByModelId(int modelId) {
        Optional<Model> model = this.modelDao.findById(modelId);
        if(model.isPresent()) {
            List<Shoe> shoeList = model.get().getShoeList();
            Set<String> colorList = shoeList.stream()
                    .map(Shoe::getColor)
                    .collect(Collectors.toSet());
            return new SuccessDataResult<>(colorList, "Colors are listed.");
        }else
            return new ErrorDataResult<>("No such model.");
    }

    @Override
    public DataResult<Set<Integer>> getShoesSizesByModelIdAndColor(int modelId, String color) {
        Optional<Model> model = this.modelDao.findById(modelId);
        if(model.isPresent()) {
            List<Shoe> shoeList = model.get().getShoeList();
            Set<Integer> colorList = shoeList.stream()
                    .filter(e->e.getColor().equals(color))
                    .map(Shoe::getSize)
                    .collect(Collectors.toSet());
            return new SuccessDataResult<>(colorList, "Sizes are listed due to color.");
        }else
            return new ErrorDataResult<>("No such model.");
    }

    @Override
    public DataResult<Shoe> getShoeByModelIdAndColorAndSize(int modelId, String color, int size) {
        Optional<Model> model = this.modelDao.findById(modelId);
        if(model.isPresent()) {
            List<Shoe> shoeList = model.get().getShoeList();
            try {
                Shoe shoe = shoeList.stream()
                        .filter(e -> e.getColor().equals(color))
                        .filter(e -> e.getSize() == size)
                        .findFirst().get();
                return new SuccessDataResult<>(shoe, "Sizes are listed due to color.");
            }catch (Exception err){
                return new ErrorDataResult<>("No shoe with selected color and size is found.");
            }
        }else
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
    public DataResult<Model> updateModel(int modelId, ModelDto modelDto) {
        Model model = this.modelDao.getById(modelId);
        ModelConverter.copyFields(modelDto, model);
        return new SuccessDataResult<>(this.modelDao.save(model));
    }

    @Override
    public DataResult<List<RatedModelsDto>> getRates(int id) {

        return new SuccessDataResult<>(this.modelDao.findById(id).get().getRates()
                .stream().map(RatedModelsConverter::RatedModelsToRatedModelsDto)
                .collect(Collectors.toList()));
    }

    @Override
    public DataResult<RatedModels> addRate(int id, RatedModelsDto ratedModelsDto) {
        if(ratedModelsDto.getStar() > 5 || ratedModelsDto.getStar() < 1)
            return new ErrorDataResult<>(null ,"Invalid Rating");
        RatedModels ratedModels = RatedModelsConverter.RatedModelsDtoToRatedModels(ratedModelsDto);
        //ratedModels.getRatedModelsPk().setModelId(id);
        return new SuccessDataResult<>(this.ratedModelsDao.save(ratedModels), "Success");
    }

    @Override
    public Result addModel(ModelDto modelDto) {
        this.modelDao.save( ModelConverter.ModelDtoToModel(modelDto) );
        return new SuccessResult("Model added");
    }


}
