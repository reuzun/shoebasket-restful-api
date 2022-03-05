package ceng.estu.group2.shoebasketweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

/**
 * @author reuzun
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "basket_contains")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","user"})
public class Basket implements java.io.Serializable{

//    @Embeddable
//    @Data
//    @NoArgsConstructor
//    //@AllArgsConstructor
//    public static class BasketPk implements java.io.Serializable{
//
//
//        @JsonIgnoreProperties
//        String username;
//
//    }
//
//    @Id
//    private BasketPk basketPk;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "username")
    private User user;

    @ManyToOne()
    @JoinColumn(name="ShoeID")
    private Shoe shoe;

}
