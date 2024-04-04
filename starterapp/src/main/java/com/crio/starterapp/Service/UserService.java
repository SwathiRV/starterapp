package com.crio.starterapp.Service;

import com.crio.starterapp.Comparator.UserScoreComparator;
import com.crio.starterapp.Entity.User;
import com.crio.starterapp.Exceptions.InValidScoreEcxception;
import com.crio.starterapp.Exchange.UserRequest;
import com.crio.starterapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        users.sort(new UserScoreComparator());
        return users;
    }

    @Override
    public Optional<User> getUser(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> registerUser(UserRequest userRequest) {
        String id = userRequest.getId();
        String name = userRequest.getName();

        User user = new User(id, name, 0, null);
        if(userRepository.existsById(id)){
            return Optional.empty();
        }
        userRepository.save(user);
        return Optional.of(user);
    }

    @Override
    public Optional<User> modifyUser(String id, int score) {
        if(score< 0 || score>100){
            throw new InValidScoreEcxception("Invalid Score. Score Range should be 0-100");
        }
        Optional<User> requestUser = userRepository.findById(id);
        if(requestUser.isPresent()){
            User user = requestUser.get();
            user.setScore(score);
            userRepository.save(user);
        }
        return requestUser;
    }

    @Override
    public Optional<User> removeUser(String id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            userRepository.deleteById(id);
        }
        return user;
    }
}
