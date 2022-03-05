package ceng.estu.group2.shoebasketweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author reuzun
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "shoe_sold")
public class BoughtShoe {

    @Id
    @GeneratedValue
    @Column(name = "id")
    int id;

    @ManyToOne()
    @JoinColumn(name = "username")
    @JsonIgnore
    User user;

    // single directional relationship
    @ManyToOne()
    @JoinColumn(name = "shoeid")
    Shoe shoe;

    @Column(name = "SaleDate")
    java.sql.Date saleDate;

    @Column(name = "PRICE")
    double price;

    @Column(name = "Adress")
    String address;

}
