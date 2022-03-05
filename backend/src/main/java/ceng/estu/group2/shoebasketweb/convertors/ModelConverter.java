package ceng.estu.group2.shoebasketweb.convertors;

import ceng.estu.group2.shoebasketweb.dataaccess.abstracts.ModelDao;
import ceng.estu.group2.shoebasketweb.dto.ModelDto;
import ceng.estu.group2.shoebasketweb.dto.RatedModelsDto;
import ceng.estu.group2.shoebasketweb.entities.Model;
import ceng.estu.group2.shoebasketweb.entities.RatedModels;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import ceng.estu.group2.shoebasketweb.entities.abstracts.BaseModel;
import ceng.estu.group2.shoebasketweb.requests.ModelRequest;

import java.util.stream.Collectors;

/**
 * @author reuzun
 */
public class ModelConverter {

    public static ModelDto ModelToModelDto(Model source){
        ModelDto target = new ModelDto();
        copyFields(source, target);
        target.setColors(source.getShoeList()
                        .stream()
                        .map(Shoe::getColor)
                        .distinct()
                        .collect(Collectors.toList())
        );
        target.setSizes(source.getShoeList()
                .stream()
                .map(Shoe::getSize)
                .distinct()
                .collect(Collectors.toList())
        );
        return target;
    }
    public static Model  ModelDtoToModel(ModelDto source){
        Model target = new Model();
        copyFields(source, target);
        return target;
    }

    public static void copyFields(BaseModel source, BaseModel target){
        target.setModelId(source.getModelId());
        target.setBrandName(source.getBrandName());
        target.setModelName(source.getModelName());
        target.setType(source.getType());
        target.setPrice(source.getPrice());
        target.setCustomerRating(source.getCustomerRating());
    }

    public static Model copyRequest(ModelRequest modelRequest){
        Model target = new Model();
        copyRequestFields(modelRequest, target);
        return target;
    }

    public static void copyRequestFields(ModelRequest modelRequest, Model model){
        model.setPrice(modelRequest.getPrice());
        model.setBrandName(modelRequest.getBrandName());
        model.setModelName(modelRequest.getModelName());
        model.setType(modelRequest.getType());
    }

//    public static void setModelDtoFromModel(Model model, ModelDto modelDto){
//
//
//    }

}
