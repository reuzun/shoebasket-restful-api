package ceng.estu.group2.shoebasketweb.dataaccess.abstracts;

import ceng.estu.group2.shoebasketweb.entities.Basket;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author reuzun
 */
public interface BasketDao extends JpaRepository<Basket, Integer> {

    List<Basket> findByUserUsernameAndShoeShoeIdOrderByIdDesc (String user_username, int shoe_shoeId);

}
