package ceng.estu.group2.shoebasketweb.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author reuzun
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="shoe")
public class Shoe {

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

    @ManyToOne
    @JoinColumn(name="modelID")
    private Model model;

}
