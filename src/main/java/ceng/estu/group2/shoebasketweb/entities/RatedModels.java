package ceng.estu.group2.shoebasketweb.entities;

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
public class RatedModels {

    @Embeddable
    @Data
    //@NoArgsConstructor
    @AllArgsConstructor
    public static class RatedModelsPk implements java.io.Serializable{
        @Column(name = "username")
        private String username;
        @Column(name = "ModelId")
        private int modelId;

        public RatedModelsPk(){};

    }

    @EmbeddedId
    RatedModelsPk ratedModelsPk;

    @Column(name = "star")
    private int star;

}
