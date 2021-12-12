package ceng.estu.group2.shoebasketweb.business.concrete;

import ceng.estu.group2.shoebasketweb.business.abstracts.ShoeService;
import ceng.estu.group2.shoebasketweb.core.util.results.*;
import ceng.estu.group2.shoebasketweb.dataaccess.abstracts.ShoeDao;
import ceng.estu.group2.shoebasketweb.dataaccess.concretes.ModelRepositoryImpl;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author reuzun
 */
@Service
public class ShoeManager implements ShoeService {

    private final ShoeDao shoeDao;

    @Autowired
    public ShoeManager(ShoeDao shoeDao){
        this.shoeDao = shoeDao;
    }





    @Override
    public DataResult<Shoe> addShoe(Shoe shoe) {
        return new SuccessDataResult<>(this.shoeDao.save(shoe), "Shoe added.");
    }

    @Override
    public DataResult<Shoe> getShoeById(int id) {
        Optional<Shoe> shoe = this.shoeDao.findById(id);
        if(shoe.isPresent())
            return new SuccessDataResult<>(shoe.get());
        else
            return new ErrorDataResult<>("No such shoe.");
        //return new SuccessDataResult<>(this.shoeDao.getById(id));
    }

    @Override
    public DataResult<Shoe> updateShoe(Shoe shoe) {
        return new SuccessDataResult<>(this.shoeDao.save(shoe));
    }

    @Override
    public DataResult<Shoe> updateShoeStock(int id, int stock) {
        Optional<Shoe> shoe = this.shoeDao.findById(id);
        if(shoe.isPresent()) {
            Shoe s = shoe.get();
            s.setCount(stock);
            return new SuccessDataResult<>(this.shoeDao.save(s));
        }
        else
            return new ErrorDataResult<>("No such shoe.");
    }
}
