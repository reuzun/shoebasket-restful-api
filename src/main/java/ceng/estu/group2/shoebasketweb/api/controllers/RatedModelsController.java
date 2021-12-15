package ceng.estu.group2.shoebasketweb.api.controllers;

import ceng.estu.group2.shoebasketweb.business.abstracts.RatedModelsService;
import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.core.util.results.Result;
import ceng.estu.group2.shoebasketweb.dto.RatedModelsDto;
import ceng.estu.group2.shoebasketweb.entities.RatedModels;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author reuzun
 */

@RestController
@RequestMapping("/api/rate")
public class RatedModelsController {

    private RatedModelsService ratedModelsService;

    @Autowired
    public RatedModelsController(RatedModelsService ratedModelsService){
        this.ratedModelsService = ratedModelsService;
    }


//    @GetMapping("/getall")
//    public List<RatedModels> getShoeById() {
//        return this.ratedModelsService.getAll();
//    }

    @PostMapping("/add")
    public DataResult<RatedModels> add(@RequestBody RatedModelsDto ratedModelsDto) {
        return this.ratedModelsService.add(ratedModelsDto);
    }

}
