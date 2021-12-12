package ceng.estu.group2.shoebasketweb.business.concrete;

import ceng.estu.group2.shoebasketweb.business.abstracts.ModelService;
import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.core.util.results.SuccessDataResult;
import ceng.estu.group2.shoebasketweb.dataaccess.abstracts.ModelDao;
import ceng.estu.group2.shoebasketweb.entities.Model;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author reuzun
 */
@Service
public class ModelManager implements ModelService {

    private final ModelDao modelDao;

    @Autowired
    public ModelManager(ModelDao shoeDao){
        this.modelDao = shoeDao;
    }

    @Override
    public DataResult<List<Model>> getAll() {
        return new SuccessDataResult<>(this.modelDao.findAll());
    }

}
