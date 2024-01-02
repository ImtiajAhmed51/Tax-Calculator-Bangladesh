package imtiaj.service;

import imtiaj.model.User;
import imtiaj.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        user.setFullname(user.getFullname().toUpperCase());
        user.setEmail(user.getEmail().toLowerCase());
        userRepository.create(user);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User get(int id) {
        return userRepository.get(id);
    }

    public void delete(int id) {
        userRepository.delete(id);
    }

    public void edit(User user) {
        userRepository.edit(user);
    }
}
