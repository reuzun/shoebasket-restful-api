package ceng.estu.group2.shoebasketweb.business.concrete;

import ceng.estu.group2.shoebasketweb.business.abstracts.UserService;
import ceng.estu.group2.shoebasketweb.core.util.results.*;
import ceng.estu.group2.shoebasketweb.dataaccess.abstracts.UserAdressDao;
import ceng.estu.group2.shoebasketweb.dataaccess.abstracts.UserDao;
import ceng.estu.group2.shoebasketweb.dataaccess.abstracts.UserPhoneNoDao;
import ceng.estu.group2.shoebasketweb.dto.UserDto;
import ceng.estu.group2.shoebasketweb.entities.User;
import ceng.estu.group2.shoebasketweb.entities.UserAdress;
import ceng.estu.group2.shoebasketweb.entities.UserPhoneNo;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author reuzun
 */
@Service
public class UserManager implements UserService {

    private final UserDao userDao;
    private final UserAdressDao userAdressDao;
    private final UserPhoneNoDao userPhoneNoDao;

    public UserManager(UserDao userDao, UserAdressDao userAdressDao, UserPhoneNoDao userPhoneNoDao) {
        this.userDao = userDao;
        this.userAdressDao = userAdressDao;
        this.userPhoneNoDao = userPhoneNoDao;
    }

    @Override
    public DataResult<UserDto> getUsetByUsername(String username) {
        Optional<User> user = this.userDao.findById(username);
        if (user.isPresent()) {
            return new SuccessDataResult<>(new UserDto(user.get()));
        } else
            return new ErrorDataResult<>("No such that username.");
    }

    @Override
    public Result changeAdressOfUser(String username, String oldAdress, String newAdress) {
        boolean doesUserHaveAddress = false;
        Optional<User> u = this.userDao.findById(username);
        if (u.isPresent()) {
            User user = u.get();
            for (UserAdress adr : user.getAdresses()) {
                if (adr.getAdress().equals(oldAdress)) {
                    this.userAdressDao.delete(adr);
                    UserAdress adress = new UserAdress();
                    adress.setAdress(newAdress);
                    User user1 = new User();
                    user1.setUsername(username);
                    adress.setUser(user1);
                    this.userAdressDao.save(adress);
                    doesUserHaveAddress = true;
                    break;
                }
            }
            if(doesUserHaveAddress)
                return new SuccessResult("Adress is updated");
            else
                return new ErrorResult("User doesnt have such that address.");
        } else
            return new ErrorResult("No such that username.");
    }

    @Override
    public Result changePhoneNoOfUser(String username, String oldphoneno, String newPhoneno) {
        boolean doesUserHavePhoneNo = false;
        Optional<User> u = this.userDao.findById(username);
        if (u.isPresent()) {
            User user = u.get();
            for (UserPhoneNo adr : user.getPhoneNumbers()) {
                if (adr.getPhoneNo().equals(oldphoneno)) {
                    this.userPhoneNoDao.delete(adr);
                    UserPhoneNo phoneNo = new UserPhoneNo();
                    phoneNo.setPhoneNo(newPhoneno);
                    User user1 = new User();
                    user1.setUsername(username);
                    phoneNo.setUser(user1);
                    this.userPhoneNoDao.save(phoneNo);
                    doesUserHavePhoneNo = true;
                    break;
                }

            }
            if(doesUserHavePhoneNo)
                return new SuccessResult("Phoneno is updated");
            else
                return new ErrorResult("User doesnt have such that address.");
        } else
            return new ErrorResult("No such that username.");
    }

    @Override
    public Result deleteAdress(String username, String address) {
        boolean doesUserHaveAddress = false;
        Optional<User> u = this.userDao.findById(username);
        if (u.isPresent()) {
            User user = u.get();
            for (UserAdress adr : user.getAdresses()) {
                if (adr.getAdress().equals(address)) {
                    this.userAdressDao.delete(adr);
                    doesUserHaveAddress = true;
                    break;
                }
            }
            if(doesUserHaveAddress)
                return new SuccessResult("Adress is deleted!");
            else
                return new ErrorResult("User doesnt have such that address.");
        }else
            return new ErrorResult("Couldnt delete the address.");
    }

    @Override
    public Result deletePhoneNo(String username, String phoneNo) {
        boolean doesUserHavePhoneNo = false;
        Optional<User> u = this.userDao.findById(username);
        if (u.isPresent()) {
            User user = u.get();
            for (UserPhoneNo adr : user.getPhoneNumbers()) {
                if (adr.getPhoneNo().equals(phoneNo)) {
                    this.userPhoneNoDao.delete(adr);
                    doesUserHavePhoneNo = true;
                    break;
                }
            }
            if(doesUserHavePhoneNo)
                return new SuccessResult("PhoneNo is deleted!");

            else
                return new ErrorResult("User doesnt have such that address.");
        }else
            return new ErrorResult("Couldnt delete the phoneno.");
    }

    @Override
    public Result addAdress(String username, String newAdress) {
        Optional<User> u = this.userDao.findById(username);
        if (u.isPresent()) {
            UserAdress adress = new UserAdress();
            adress.setAdress(newAdress);
            User user1 = new User();
            user1.setUsername(username);
            adress.setUser(user1);
            this.userAdressDao.save(adress);
            return new SuccessResult("adress is addded!");
        }else
            return new ErrorResult("Couldnt add the address.");
    }

    @Override
    public Result addPhoneNo(String username, String newPhoneno) {
        Optional<User> u = this.userDao.findById(username);
        if (u.isPresent()) {
            UserPhoneNo phoneNo = new UserPhoneNo();
            phoneNo.setPhoneNo(newPhoneno);
            User user1 = new User();
            user1.setUsername(username);
            phoneNo.setUser(user1);
            this.userPhoneNoDao.save(phoneNo);
            return new SuccessResult("PhoneNo is added!");
        }else
            return new ErrorResult("Couldnt add the phoneno.");
    }


}
