package ceng.estu.group2.shoebasketweb.business.concrete;

import ceng.estu.group2.shoebasketweb.business.abstracts.ShoeService;
import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.core.util.results.SuccessDataResult;
import ceng.estu.group2.shoebasketweb.dataaccess.abstracts.ShoeDao;
import ceng.estu.group2.shoebasketweb.dataaccess.concretes.ShoeRepositoryImpl;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author reuzun
 */
@Service
public class ShoeManager implements ShoeService {

    private final ShoeDao shoeDao;
    private final ShoeRepositoryImpl shoeRepositoryImpl;

    @Autowired
    public ShoeManager(ShoeDao shoeDao, ShoeRepositoryImpl shoeRepositoryImpl){
        this.shoeDao = shoeDao;
        this.shoeRepositoryImpl = shoeRepositoryImpl;
    }

    @Override
    public DataResult<List<Shoe>> getAll() {
        return new SuccessDataResult<>(this.shoeDao.findAll());
    }

    @Override
    public DataResult<List<Shoe>> getRandomShoes() {
        return this.shoeRepositoryImpl.getRandomShoes(10);
    }
}
