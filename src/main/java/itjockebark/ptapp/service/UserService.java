package itjockebark.ptapp.service;

import itjockebark.ptapp.dao.UserDAO;
import itjockebark.ptapp.model.dto.UserRegisterDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(UserRegisterDTO dto) {

    }

}
