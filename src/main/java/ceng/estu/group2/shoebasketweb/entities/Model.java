package ceng.estu.group2.shoebasketweb.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author reuzun
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="model")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","shoeList"})
public class Model {

    @Id
    @GeneratedValue()
    @Column(name="ModelID")
    private int modelId;

    @Column(name="ModelName")
    private String modelName;

    @Column(name="BrandName")
    private String brandName;

    @Column(name="Type")
    private String type;

    @Column(name="PRICE")
    private double price;

    @Column(name="CustomerRating")
    private Double customerRating	;

    @OneToMany(mappedBy = "model")
    private List<Shoe> shoeList;

}
