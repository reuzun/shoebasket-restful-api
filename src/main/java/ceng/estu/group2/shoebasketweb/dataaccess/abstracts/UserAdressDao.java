package ceng.estu.group2.shoebasketweb.dataaccess.abstracts;

import ceng.estu.group2.shoebasketweb.entities.UserAdress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author reuzun
 */
public interface UserAdressDao extends JpaRepository<UserAdress, String> {
}
