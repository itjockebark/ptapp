package itjockebark.ptapp.service;

import itjockebark.ptapp.dao.UserDAO;
import itjockebark.ptapp.model.UserRole;
import itjockebark.ptapp.model.dto.UserRegisterDTO;
import itjockebark.ptapp.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public final String rolePrefix = "USER";

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(UserRegisterDTO dto) {
        User user = new User();

        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setRole(UserRole.valueOf(rolePrefix));
        user.setActive(true);

        userDAO.save(user);
    }

    public void deleteUser() {

    }

}
