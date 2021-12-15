package ceng.estu.group2.shoebasketweb.dataaccess.abstracts;

import ceng.estu.group2.shoebasketweb.entities.RatedModels;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author reuzun
 */
public interface RatedModelsDao extends JpaRepository<RatedModels, RatedModels.RatedModelsPk> {
}
