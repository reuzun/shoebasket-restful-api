package ceng.estu.group2.shoebasketweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

/**
 * @author reuzun
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rated_models")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","model"})
public class RatedModels {

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RatedModelsPk implements java.io.Serializable{
        @Column(name = "username")
        private String username;


        private int modelId;
    }

    @EmbeddedId
    RatedModelsPk ratedModelsPk;

    @ManyToOne()
    @MapsId(value = "modelId")
    @JoinColumn(name = "modelId")
    Model model;

    @Column(name = "star")
    private int star;

}
