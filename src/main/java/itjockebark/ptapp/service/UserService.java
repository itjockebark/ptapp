package itjockebark.ptapp.service;

import itjockebark.ptapp.dao.UserDAO;
import itjockebark.ptapp.model.CustomUserService;
import itjockebark.ptapp.model.UserRole;
import itjockebark.ptapp.model.dto.UserGetDTO;
import itjockebark.ptapp.model.dto.UserRegisterDTO;
import itjockebark.ptapp.model.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    public final String userNotFoundPrefix = "User with email address [\"%s\"] was not found";
    public final String rolePrefix = "USER";

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDAO.findById(email).orElseThrow(NullPointerException::new);
        if (user == null) {
            throw new UsernameNotFoundException(String.format(userNotFoundPrefix, email));
        }
        return new CustomUserService(user);
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

    public List<UserGetDTO> getUsers() {
        return userDAO.findAll().stream().map(UserService::getUserWithoutPassword).collect(Collectors.toList());
    }

    public static UserGetDTO getUserWithoutPassword(User user) {
        UserGetDTO dto = new UserGetDTO();
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setRole(user.getRole());
        dto.setIsActive(user.isActive());
        dto.setBirthdate(user.getBirthdate());
        return dto;
    }

}
