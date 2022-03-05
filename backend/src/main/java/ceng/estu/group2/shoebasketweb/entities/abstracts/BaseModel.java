package ceng.estu.group2.shoebasketweb.entities.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * This class is created for copying fields of Model and ModelDto in single method.
 * -> ceng.estu.group2.shoebasketweb.converters.ModelConverter.(copyFields)
 *
 * @author reuzun
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseModel {
    private int modelId;
    private String modelName;
    private String brandName;
    private String type;
    private double price;
    private Double customerRating;
}
