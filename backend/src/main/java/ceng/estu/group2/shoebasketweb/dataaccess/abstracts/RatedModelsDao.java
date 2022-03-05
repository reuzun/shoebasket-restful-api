package ceng.estu.group2.shoebasketweb.dataaccess.abstracts;

import ceng.estu.group2.shoebasketweb.core.util.results.Result;
import ceng.estu.group2.shoebasketweb.entities.RatedModels;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author reuzun
 */
public interface RatedModelsDao extends JpaRepository<RatedModels, Integer> {

    RatedModels findByUser_UsernameAndModel_ModelId(String user_username, int model_modelId);

}
