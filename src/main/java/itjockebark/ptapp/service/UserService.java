package itjockebark.ptapp.service;

import itjockebark.ptapp.dao.UserDAO;
import itjockebark.ptapp.model.UserRole;
import itjockebark.ptapp.model.dto.UserRegisterDTO;
import itjockebark.ptapp.model.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {


    public final String rolePrefix = "USER";

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public void registerUser(UserRegisterDTO dto) {
        User user = new User();

        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setBirthdate(dto.getBirthdate());
        user.setRole(UserRole.valueOf(rolePrefix));
        user.setActive(true);

        userDAO.save(user);
    }

    public void deleteUser() {

    }

}
