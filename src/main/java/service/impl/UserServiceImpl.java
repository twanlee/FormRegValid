package service.impl;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import repository.UserRepository;
import service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public Iterable<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {

        return repository.findById(id);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void remove(Long id) {
        repository.delete(findById(id).get());
    }
}
