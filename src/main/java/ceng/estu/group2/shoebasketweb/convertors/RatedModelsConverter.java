package ceng.estu.group2.shoebasketweb.convertors;

import ceng.estu.group2.shoebasketweb.dto.RatedModelsDto;
import ceng.estu.group2.shoebasketweb.entities.Model;
import ceng.estu.group2.shoebasketweb.entities.RatedModels;
import ceng.estu.group2.shoebasketweb.entities.User;

/**
 * @author reuzun
 */
public class RatedModelsConverter {

    public static RatedModelsDto  RatedModelsToRatedModelsDto(RatedModels source){
        RatedModelsDto target = new RatedModelsDto();
        target.setUsername(source.getUser().getUsername());
        //target.setModelId(source.getRatedModelsPk().getModelId());
        target.setStar(source.getStar());
        return target;
    }
    public static RatedModels  RatedModelsDtoToRatedModels(RatedModelsDto source){
        RatedModels target = new RatedModels();
        target.setUser(new User());
        target.getUser().setUsername(source.getUsername());
        target.setModel(new Model());
        target.setStar(source.getStar());
        return target;
    }

}
