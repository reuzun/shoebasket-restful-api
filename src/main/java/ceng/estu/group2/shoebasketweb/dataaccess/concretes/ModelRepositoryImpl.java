package ceng.estu.group2.shoebasketweb.dataaccess.concretes;

import ceng.estu.group2.shoebasketweb.convertors.ModelConverter;
import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.core.util.results.SuccessDataResult;
import ceng.estu.group2.shoebasketweb.dataaccess.abstracts.ModelCustomRepository;
import ceng.estu.group2.shoebasketweb.dto.ModelDto;
import ceng.estu.group2.shoebasketweb.entities.Model;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author reuzun
 */
@Repository
public class ModelRepositoryImpl implements ModelCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Returns random n shoes.
     * @param limit Number of shoes to return.
     * */
    @Override
    public DataResult<List<ModelDto>> getRandomModel(int limit) {
        return new SuccessDataResult(entityManager.createQuery("SELECT p FROM Model p ORDER BY RAND()",
                Model.class).setMaxResults(limit).getResultList().stream().map(ModelConverter::ModelToModelDto));
    }
}
