package ceng.estu.group2.shoebasketweb.api.controllers;

import ceng.estu.group2.shoebasketweb.business.abstracts.UserService;
import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.core.util.results.Result;
import ceng.estu.group2.shoebasketweb.dto.UserDto;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import ceng.estu.group2.shoebasketweb.entities.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author reuzun
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public DataResult<UserDto> getUserByUsername(@PathVariable String username) {
        return this.userService.getUsetByUsername(username);
    }

    @PatchMapping("/{username}/adresses/{oldAdress}")
    public Result changeAdressOfUser(@PathVariable String username, @PathVariable String oldAdress, @RequestParam String newAdress) {
        return this.userService.changeAdressOfUser(username, oldAdress, newAdress);
    }

    @PatchMapping("/{username}/phonenos/{oldphoneno}")
    public Result changePhoneNoOfUser(@PathVariable String username, @PathVariable String oldphoneno, @RequestParam String newPhoneno) {
        return this.userService.changePhoneNoOfUser(username, oldphoneno, newPhoneno);
    }

    @DeleteMapping("/{username}/adresses/{address}")
    public Result deleteAdress(@PathVariable String username, @PathVariable String address) {
        return this.userService.deleteAdress(username, address);
    }

    @DeleteMapping("/{username}/phonenos/{phoneNo}")
    public Result deletePhoneNo(@PathVariable String username, @PathVariable String phoneNo) {
        return this.userService.deletePhoneNo(username, phoneNo);
    }

    @PostMapping("/{username}/adresses/{newAdress}")
    public Result addAdress(@PathVariable String username, @PathVariable String newAdress) {
        return this.userService.addAdress(username, newAdress);
    }

    @PostMapping("/{username}/phonenos/{newPhoneno}")
    public Result addPhoneNo(@PathVariable String username, @PathVariable String newPhoneno) {
        return this.userService.addPhoneNo(username, newPhoneno);
    }

}
