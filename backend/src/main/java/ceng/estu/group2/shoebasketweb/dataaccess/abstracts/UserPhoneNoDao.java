package ceng.estu.group2.shoebasketweb.dataaccess.abstracts;

import ceng.estu.group2.shoebasketweb.entities.UserPhoneNo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author reuzun
 */
public interface UserPhoneNoDao extends JpaRepository<UserPhoneNo, String> {
}
