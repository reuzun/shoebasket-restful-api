package ceng.estu.group2.shoebasketweb.business.concrete;

import ceng.estu.group2.shoebasketweb.business.abstracts.RatedModelsService;
import ceng.estu.group2.shoebasketweb.convertors.RatedModelsConverter;
import ceng.estu.group2.shoebasketweb.core.util.results.*;
import ceng.estu.group2.shoebasketweb.dataaccess.abstracts.RatedModelsDao;
import ceng.estu.group2.shoebasketweb.dto.RatedModelsDto;
import ceng.estu.group2.shoebasketweb.entities.RatedModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author reuzun
 */
@Service
public class RatedModelsManager implements RatedModelsService {

    private RatedModelsDao ratedModelsDao;

    @Autowired
    public RatedModelsManager(RatedModelsDao ratedModelsDao){
        this.ratedModelsDao = ratedModelsDao;
    }


//    @Override
//    public List<RatedModels> getAll() {
//        return this.ratedModelsDao.findAll();
//    }

    @Override
    public DataResult<RatedModels> add(int id, RatedModelsDto ratedModelsDto) {
        if(ratedModelsDto.getStar() > 5 || ratedModelsDto.getStar() < 1)
            return new ErrorDataResult<>(null ,"Invalid Rating");
        RatedModels ratedModels = RatedModelsConverter.RatedModelsDtoToRatedModels(ratedModelsDto);
        ratedModels.getRatedModelsPk().setModelId(id);
        return new SuccessDataResult<>(this.ratedModelsDao.save(ratedModels), "Success");
    }

    @Override
    public DataResult<RatedModels> getRates(int id) {
        return null;
    }
}
