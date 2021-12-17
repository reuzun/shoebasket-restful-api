package ceng.estu.group2.shoebasketweb.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author reuzun
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelRequest {
    private String modelName;
    private String brandName;
    private String type;
    private double price;
}
