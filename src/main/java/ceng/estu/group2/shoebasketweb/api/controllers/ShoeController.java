package ceng.estu.group2.shoebasketweb.api.controllers;

import ceng.estu.group2.shoebasketweb.business.abstracts.ShoeService;
import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.core.util.results.ErrorDataResult;
import ceng.estu.group2.shoebasketweb.core.util.results.ErrorResult;
import ceng.estu.group2.shoebasketweb.core.util.results.Result;
import ceng.estu.group2.shoebasketweb.entities.Model;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author reuzun
 */
@RestController
@RequestMapping("/api/shoe")
public class ShoeController {

    private final ShoeService shoeService;

    @Autowired
    public ShoeController(ShoeService shoeService){
        this.shoeService = shoeService;
    }



    @GetMapping("/{id}")
    public DataResult<Shoe> getShoeById(@PathVariable int id) {
        return this.shoeService.getShoeById(id);
    }

    @PostMapping("/add")
    public DataResult<Shoe> addShoe(@RequestBody(required = true) Shoe shoe) {
        return this.shoeService.addShoe(shoe);
    }

    @PutMapping("/{id}")
    public DataResult<Shoe> updateShoe(@RequestBody Shoe shoe) {
        return this.shoeService.updateShoe(shoe);
    }

    /**
     * Updates the stock of given id
     *
     * @param id id of shoe to update the stock
     * @param stock the updated stock
     * */
    @PatchMapping("/{id}")
    public DataResult<Shoe> updateShoeStock(@PathVariable int id, @RequestParam int stock) {
        return this.shoeService.updateShoeStock(id, stock);
    }




}
