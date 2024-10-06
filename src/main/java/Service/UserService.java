package Service;

import Entity.User;
import Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {

    public List<User> getAllUsers();

    public User createUser(User user);

    public Optional<User> getUserbyId(Long id);

    public void deleteUser(Long id);



}
