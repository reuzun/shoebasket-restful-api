package ceng.estu.group2.shoebasketweb.convertors;

import ceng.estu.group2.shoebasketweb.dataaccess.abstracts.ModelDao;
import ceng.estu.group2.shoebasketweb.dto.ModelDto;
import ceng.estu.group2.shoebasketweb.dto.RatedModelsDto;
import ceng.estu.group2.shoebasketweb.entities.Model;
import ceng.estu.group2.shoebasketweb.entities.RatedModels;
import ceng.estu.group2.shoebasketweb.entities.abstracts.BaseModel;

/**
 * @author reuzun
 */
public class ModelConverter {

    public static ModelDto ModelToModelDto(Model source){
        ModelDto target = new ModelDto();
        copyFields(source, target);
        return target;
    }
    public static Model  ModelDtoToModel(ModelDto source){
        Model target = new Model();
        copyFields(source, target);
        return target;
    }

    public static void copyFields(BaseModel source, BaseModel target){
        target.setBrandName(source.getBrandName());
        target.setModelName(source.getModelName());
        target.setType(source.getType());
        target.setPrice(source.getPrice());
    }

//    public static void setModelDtoFromModel(Model model, ModelDto modelDto){
//
//
//    }

}
