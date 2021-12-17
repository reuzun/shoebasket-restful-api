package ceng.estu.group2.shoebasketweb.business.abstracts;

import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.core.util.results.Result;
import ceng.estu.group2.shoebasketweb.dto.ModelDto;
import ceng.estu.group2.shoebasketweb.dto.RatedModelsDto;
import ceng.estu.group2.shoebasketweb.entities.Model;
import ceng.estu.group2.shoebasketweb.entities.RatedModels;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author reuzun
 */
public interface ModelService {
    DataResult<List<Shoe>> getShoesByModelId(int modelId);

    DataResult<List<Model>> getRandomShoes(int limit);

    DataResult<Set<String>> getShoesColorsByModelId(int modelId);

    DataResult<Set<Integer>> getShoesSizesByModelIdAndColor(int modelId, String color);

    DataResult<Shoe> getShoeByModelIdAndColorAndSize(int modelId, String color, int size);

    DataResult<Model> updatePrice(int id, double price);

    DataResult<Model> updateModel(int modelId, ModelDto model);

    DataResult<List<RatedModelsDto>> getRates(int id);

    DataResult<RatedModels> addRate(int id, RatedModelsDto ratedModelsDto);

    Result addModel(ModelDto modelDto);
}
