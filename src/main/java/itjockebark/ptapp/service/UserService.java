package itjockebark.ptapp.service;

import itjockebark.ptapp.dao.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

}
