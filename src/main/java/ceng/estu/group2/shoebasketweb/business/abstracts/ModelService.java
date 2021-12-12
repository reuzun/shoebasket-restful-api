package ceng.estu.group2.shoebasketweb.business.abstracts;

import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.entities.Model;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author reuzun
 */
public interface ModelService {
    DataResult<List<Model>> getAll();
}
