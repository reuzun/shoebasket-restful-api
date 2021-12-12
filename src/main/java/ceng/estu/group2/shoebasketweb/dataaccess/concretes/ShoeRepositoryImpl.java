package ceng.estu.group2.shoebasketweb.dataaccess.concretes;

import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.core.util.results.SuccessDataResult;
import ceng.estu.group2.shoebasketweb.dataaccess.abstracts.ShoeCustomRepository;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author reuzun
 */
@Repository
public class ShoeRepositoryImpl implements ShoeCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public DataResult<List<Shoe>> getRandomShoes(int limit) {
        return new SuccessDataResult<>(entityManager.createQuery("SELECT p FROM Shoe p ORDER BY RAND()",
                Shoe.class).setMaxResults(limit).getResultList());
    }
}
