package ceng.estu.group2.shoebasketweb.business.abstracts;

import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author reuzun
 */
public interface ShoeService {
    DataResult<List<Shoe>> getAll();
    DataResult<List<Shoe>> getRandomShoes();
}
