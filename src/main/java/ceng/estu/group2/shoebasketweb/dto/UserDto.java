package ceng.estu.group2.shoebasketweb.dto;

import ceng.estu.group2.shoebasketweb.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author reuzun
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String username;

    private String password;

    private String email;

    private String name;

    private String surname;

    private String userType;

    List<String> adresses;

    List<String> phoneNumbers;

    List<Integer> basket;

    public UserDto(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.userType = user.getUserType();

        this.adresses = user.getAdresses().stream()
                .map(UserAdress::getAdress)
                .collect(Collectors.toList());

        this.phoneNumbers = user.getPhoneNumbers().stream()
                .map(UserPhoneNo::getPhoneNo)
                .collect(Collectors.toList());

        this.basket = user.getBasket().stream()
                .map(Basket::getShoe)
                .map(Shoe::getShoeId)
                .collect(Collectors.toList());


    }

}
