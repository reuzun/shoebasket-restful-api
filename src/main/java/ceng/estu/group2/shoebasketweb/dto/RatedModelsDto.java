package ceng.estu.group2.shoebasketweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author reuzun
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatedModelsDto {

    private String username;

    private int modelId;

    private int star;


}
