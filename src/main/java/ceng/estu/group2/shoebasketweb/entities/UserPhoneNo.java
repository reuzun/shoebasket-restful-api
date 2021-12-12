package ceng.estu.group2.shoebasketweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name="user_phoneno")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "user"})
public class UserPhoneNo {

    @Id
    @Column(name="PhoneNO")
    private String phoneNo;

    @ManyToOne
    @JoinColumn(name="username")
    private User user;

}
