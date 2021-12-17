package ceng.estu.group2.shoebasketweb.business.abstracts;

import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.core.util.results.Result;
import ceng.estu.group2.shoebasketweb.dto.RatedModelsDto;
import ceng.estu.group2.shoebasketweb.entities.RatedModels;

import java.util.List;

/**
 * @author reuzun
 */
public interface RatedModelsService {
    //List<RatedModels> getAll();

    DataResult<RatedModels> add(int id, RatedModelsDto ratedModelsDto);

    DataResult<RatedModels> getRates(int id);
}
