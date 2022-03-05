package ceng.estu.group2.shoebasketweb.business.concrete;

import ceng.estu.group2.shoebasketweb.business.abstracts.BasketService;
import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.core.util.results.ErrorDataResult;
import ceng.estu.group2.shoebasketweb.core.util.results.SuccessDataResult;
import ceng.estu.group2.shoebasketweb.dataaccess.abstracts.BasketDao;
import ceng.estu.group2.shoebasketweb.entities.Basket;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import ceng.estu.group2.shoebasketweb.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author reuzun
 */
@Service
public class BasketManager implements BasketService {

    private final BasketDao basketDao;

    @Autowired
    public BasketManager(BasketDao basketDao){
        this.basketDao = basketDao;
    }

    @Override
    public DataResult<Basket> add(String username, int shoeId) {
        User user = new User();
        user.setUsername(username);
        Shoe shoe = new Shoe();
        shoe.setShoeId(shoeId);
        Basket basket = new Basket();
        basket.setUser(user);
        basket.setShoe(shoe);
        return new SuccessDataResult<>(this.basketDao.save(basket));
    }

    @Override
    public DataResult<Basket> delete(String username, int shoeId) {
        try {
            Basket basket = this.basketDao.findByUserUsernameAndShoeShoeIdOrderByIdDesc(username, shoeId)
                    .stream().findFirst().get();
            this.basketDao.delete(basket);
            return new SuccessDataResult<>(basket);
        }catch (Exception e){
            return new ErrorDataResult<>("No such product in basket.");
        }

    }
}
