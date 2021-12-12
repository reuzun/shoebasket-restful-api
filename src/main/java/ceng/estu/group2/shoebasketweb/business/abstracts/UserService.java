package ceng.estu.group2.shoebasketweb.business.abstracts;

import ceng.estu.group2.shoebasketweb.core.util.results.DataResult;
import ceng.estu.group2.shoebasketweb.core.util.results.Result;
import ceng.estu.group2.shoebasketweb.dto.UserDto;
import ceng.estu.group2.shoebasketweb.entities.Shoe;
import ceng.estu.group2.shoebasketweb.entities.User;

/**
 * @author reuzun
 */
public interface UserService {
    DataResult<UserDto> getUsetByUsername(String username);

    Result changeAdressOfUser(String username, String oldAdress, String newAdress);

    Result changePhoneNoOfUser(String username, String oldphoneno, String newPhoneno);

    Result deleteAdress(String username, String address);

    Result deletePhoneNo(String username, String phoneNo);

    Result addAdress(String username, String newAdress);

    Result addPhoneNo(String username, String newPhoneno);
}
