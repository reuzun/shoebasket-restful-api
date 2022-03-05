package ceng.estu.group2.shoebasketweb.business.abstracts;

import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.entities.Basket;

/**
 * @author reuzun
 */
public interface BasketService {

    DataResult<Basket> add(String username, int shoeId);
    DataResult<Basket> delete(String username, int shoeId);

}
