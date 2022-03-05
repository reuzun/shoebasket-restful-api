package ceng.estu.group2.shoebasketweb.business.abstracts;

import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.core.util.results.Result;
import ceng.estu.group2.shoebasketweb.entities.Shoe;

import java.util.List;

/**
 * @author reuzun
 */
public interface ShoeService {

    DataResult<Shoe> addShoe(Shoe shoe);

    DataResult<Shoe> getShoeById(int id);

    DataResult<Shoe> updateShoe(Shoe shoe);

    DataResult<Shoe> updateShoeStock(int id, int stock);
}
