package ceng.estu.group2.shoebasketweb.dataaccess.abstracts;

import ceng.estu.group2.shoebasketweb.entities.Model;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author reuzun
 */
public interface ModelDao extends JpaRepository<Model, Integer> {
}
