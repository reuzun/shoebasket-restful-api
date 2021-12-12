package ceng.estu.group2.shoebasketweb.api.controllers;

import ceng.estu.group2.shoebasketweb.business.abstracts.ModelService;
import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.entities.Model;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @author reuzun
 */

@RestController
@RequestMapping("/api/model")
public class ModelController {

    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService){
        this.modelService = modelService;
    }

    @GetMapping("/random")
    public DataResult<List<Model>> getRandomShoes(@RequestParam(defaultValue = "10") int limit) {
        return this.modelService.getRandomShoes(limit);
    }

    @GetMapping("/{modelId}/shoes")
    public DataResult<List<Shoe>> getShoesByModelId(@PathVariable int modelId){
        return this.modelService.getShoesByModelId(modelId);
    }

    @GetMapping("/{modelId}/shoes/colors")
    public DataResult<Set<String>> getShoesColorsByModelId(@PathVariable int modelId){
        return this.modelService.getShoesColorsByModelId(modelId);
    }

    @GetMapping("/{modelId}/shoes/color/{color}/sizes")
    public DataResult<Set<Integer>> getShoesSizesByModelIdAndColor(@PathVariable int modelId, @PathVariable String color){
        return this.modelService.getShoesSizesByModelIdAndColor(modelId, color);
    }

    @GetMapping("/{modelId}/shoes/color/{color}/sizes/{size}")
    public DataResult<Shoe> getShoeByModelIdAndColorAndSize(@PathVariable int modelId, @PathVariable String color, @PathVariable int size){
        return this.modelService.getShoeByModelIdAndColorAndSize(modelId, color, size);
    }

}
