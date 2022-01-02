package ceng.estu.group2.shoebasketweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author reuzun
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {

    @Id
    @Column(name = "Username")
    private String username;

    @Column(name = "Pass_word")
    private String password;

    @Column(name = "E_mail")
    private String email;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Type")
    private String userType;

    @OneToMany(mappedBy = "user")
    List<UserAdress> adresses;

    @OneToMany(mappedBy = "user")
    List<UserPhoneNo> phoneNumbers;

    @OneToMany(mappedBy = "user")
    private List<Basket> basket;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<RatedModels> ratedModels;


    @OneToMany(mappedBy = "user")
    List<BoughtShoe> boughtShoeList;

}
