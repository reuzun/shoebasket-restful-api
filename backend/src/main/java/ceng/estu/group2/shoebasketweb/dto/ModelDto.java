package ceng.estu.group2.shoebasketweb.dto;

import ceng.estu.group2.shoebasketweb.entities.abstracts.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

/**
 * @author reuzun
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelDto extends BaseModel {
    private int modelId;
    private String modelName;
    private String brandName;
    private String type;
    private double price;
    private Double customerRating;
    List<String> colors;
    List<Integer> sizes;
}
