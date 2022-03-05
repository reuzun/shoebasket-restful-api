package ceng.estu.group2.shoebasketweb.entities;

import ceng.estu.group2.shoebasketweb.entities.abstracts.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.lang.Nullable;

/**
 * @author reuzun
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="model")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","shoeList"})
public class Model extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Double customerRating;

    @OneToMany(mappedBy = "model")
    private List<Shoe> shoeList;

    @JsonIgnore
    @OneToMany(mappedBy = "model")
    private List<RatedModels> rates = new ArrayList<>();

}
