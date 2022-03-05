package ceng.estu.group2.shoebasketweb.dataaccess.abstracts;

import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.dto.ModelDto;
import ceng.estu.group2.shoebasketweb.entities.Model;
import ceng.estu.group2.shoebasketweb.entities.Shoe;

import java.util.List;

/**
 * @author reuzun
 */
public interface ModelCustomRepository {
    DataResult<List<ModelDto>> getRandomModel(int limit);
}
