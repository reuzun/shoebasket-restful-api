package ceng.estu.group2.shoebasketweb.convertors;

import ceng.estu.group2.shoebasketweb.dto.RatedModelsDto;
import ceng.estu.group2.shoebasketweb.entities.RatedModels;

/**
 * @author reuzun
 */
public class RatedModelsConverter {

    public static RatedModelsDto  RatedModelsToRatedModelsDto(RatedModels source){
        RatedModelsDto target = new RatedModelsDto();
        target.setUsername(source.getRatedModelsPk().getUsername());
        target.setModelId(source.getRatedModelsPk().getModelId());
        target.setStar(source.getStar());
        return target;
    }
    public static RatedModels  RatedModelsDtoToRatedModels(RatedModelsDto source){
        RatedModels target = new RatedModels();
        target.setRatedModelsPk(new RatedModels.RatedModelsPk());
        target.getRatedModelsPk().setUsername(source.getUsername());
        target.getRatedModelsPk().setModelId(source.getModelId());
        target.setStar(source.getStar());
        return target;
    }

}
