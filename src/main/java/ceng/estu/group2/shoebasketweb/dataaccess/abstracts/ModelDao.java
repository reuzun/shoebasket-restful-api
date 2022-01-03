package ceng.estu.group2.shoebasketweb.dataaccess.abstracts;

import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.core.util.results.Result;
import ceng.estu.group2.shoebasketweb.entities.Model;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author reuzun
 */
public interface ModelDao extends JpaRepository<Model, Integer> {

    public Result deleteByModelId(int modelId);

    public List<Model> getAllByModelNameAndBrandNameOrderByModelIdDesc(String modelName, String brandName);

}
