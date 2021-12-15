package ceng.estu.group2.shoebasketweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name="shoe")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","basket"})
public class Shoe{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ShoeID")
    private int shoeId;

    @Column(name="Size")
    private int size;

    @Column(name="Color")
    private String color;

    @Column(name="COUNT")
    private int count;

    @ManyToOne()
    @JoinColumn(name="modelID")
    private Model model;


    @OneToMany(mappedBy = "shoe")
    private List<Basket> basket;
}
