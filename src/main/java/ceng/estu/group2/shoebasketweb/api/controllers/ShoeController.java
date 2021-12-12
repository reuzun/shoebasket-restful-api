package ceng.estu.group2.shoebasketweb.api.controllers;

import ceng.estu.group2.shoebasketweb.business.abstracts.ShoeService;
import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.entities.Model;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getall")
    public DataResult<List<Shoe>> getAll() {
        return this.shoeService.getAll();
    }

    @GetMapping("/getrandom")
    public DataResult<List<Shoe>> getRandomShoes() {
        return this.shoeService.getRandomShoes();
    }

}
