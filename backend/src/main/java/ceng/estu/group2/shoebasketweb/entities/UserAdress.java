package ceng.estu.group2.shoebasketweb.entities;

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
@Table(name="user_adresses")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "user"})
public class UserAdress {

    @Id
    @Column(name="Adress")
    private String adress;

    /*@Column(name="Username")
    private String username;*/

    @ManyToOne
    @JoinColumn(name="username")
    private User user;

}
