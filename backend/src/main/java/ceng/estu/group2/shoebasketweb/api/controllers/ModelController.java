package ceng.estu.group2.shoebasketweb.api.controllers;

import ceng.estu.group2.shoebasketweb.business.abstracts.ModelService;
import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.core.util.results.Result;
import ceng.estu.group2.shoebasketweb.core.util.results.SuccessDataResult;
import ceng.estu.group2.shoebasketweb.dto.ModelDto;
import ceng.estu.group2.shoebasketweb.dto.RatedModelsDto;
import ceng.estu.group2.shoebasketweb.entities.Model;
import ceng.estu.group2.shoebasketweb.entities.RatedModels;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import ceng.estu.group2.shoebasketweb.requests.ModelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * @author reuzun
 */

@RestController
@RequestMapping("/api/models")
@CrossOrigin
public class ModelController {

    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService){
        this.modelService = modelService;
    }

    @GetMapping("/random")
    public DataResult<List<ModelDto>> getRandomModels(@RequestParam(defaultValue = "10") int limit) {
        return this.modelService.getRandomModels(limit);
    }

    @GetMapping("/{modelId}/shoes")
    public DataResult<List<Shoe>> getShoesByModelId(@PathVariable int modelId){
        return this.modelService.getShoesByModelId(modelId);
    }

//    @GetMapping("/{modelId}/shoes/colors")
//    public DataResult<Set<String>> getShoesColorsByModelId(@PathVariable int modelId){
//        return this.modelService.getShoesColorsByModelId(modelId);
//    }
//
//    @GetMapping("/{modelId}/shoes/color/{color}/sizes")
//    public DataResult<Set<Integer>> getShoesSizesByModelIdAndColor(@PathVariable int modelId, @PathVariable String color){
//        return this.modelService.getShoesSizesByModelIdAndColor(modelId, color);
//    }
//
//    @GetMapping("/{modelId}/shoes/color/{color}/sizes/{size}")
//    public DataResult<Shoe> getShoeByModelIdAndColorAndSize(@PathVariable int modelId, @PathVariable String color, @PathVariable int size){
//        return this.modelService.getShoeByModelIdAndColorAndSize(modelId, color, size);
//    }

    /**
     * Updates the stock of given id
     *
     * @param id id of shoe to update the stock
     * */
    @PatchMapping("/{id}")
    public DataResult<Model> updatePrice(@PathVariable int id, @RequestParam double price) {
        return this.modelService.updatePrice(id, price);
    }



    @PutMapping("/{id}/rates")
    public DataResult<RatedModelsDto> rate(@PathVariable int id, @RequestBody RatedModelsDto ratedModelsDto) {
        return this.modelService.addRate(id, ratedModelsDto);
    }

    @GetMapping("/{id}/rates")
    public DataResult<List<RatedModelsDto>> getRates(@PathVariable int id) {
        return this.modelService.getRates(id);
    }

    @GetMapping("/{id}")
    public DataResult<ModelDto> getById(@PathVariable int id) {
        return this.modelService.getById(id);
    }

    @GetMapping("/list")
    public DataResult<List<ModelDto>> listAll() {
        return this.modelService.list();
    }

    @PostMapping("")
    public Result addModel(@RequestBody ModelRequest modelRequest) {
        return this.modelService.addModel(modelRequest);
    }

    @PutMapping("/{id}")
    public DataResult<Model> updateModel(@PathVariable int id , @RequestBody ModelRequest modelRequest) {
        return this.modelService.updateModel(id, modelRequest);
    }

    @DeleteMapping("/{id}")
    public Result deleteModel(@PathVariable int id) {
        return this.modelService.deleteModel(id);
    }

    /*@GetMapping("/")
    public DataResult<List<Model>> getAllByModelNameContainsAndBrandNameContainsOrderByModelIdDesc(@RequestParam(required = false, defaultValue = "") String modelName,
                                                                                     @RequestParam(required = false, defaultValue = "") String brandName){
        return this.modelService.getAllByModelNameContainsAndBrandNameContainsOrderByModelIdDesc(modelName, brandName) ;
    }*/
}
