package ceng.estu.group2.shoebasketweb.business.concrete;

import ceng.estu.group2.shoebasketweb.business.abstracts.RatedModelsService;
import ceng.estu.group2.shoebasketweb.convertors.RatedModelsConverter;
import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.core.util.results.Result;
import ceng.estu.group2.shoebasketweb.core.util.results.SuccessDataResult;
import ceng.estu.group2.shoebasketweb.core.util.results.SuccessResult;
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
    public DataResult<RatedModels> add(RatedModelsDto ratedModelsDto) {
        RatedModels ratedModels = RatedModelsConverter.RatedModelsDtoToRatedModels(ratedModelsDto);
        return new SuccessDataResult<>(this.ratedModelsDao.save(ratedModels), "Success");
    }
}
