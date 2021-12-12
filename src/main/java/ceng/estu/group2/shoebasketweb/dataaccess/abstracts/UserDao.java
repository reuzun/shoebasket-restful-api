package ceng.estu.group2.shoebasketweb.dataaccess.abstracts;

import ceng.estu.group2.shoebasketweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author reuzun
 */
public interface UserDao extends JpaRepository<User, String> {
}
