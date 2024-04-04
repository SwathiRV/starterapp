package com.crio.starterapp.Service;

import com.crio.starterapp.Entity.User;
import com.crio.starterapp.Exchange.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IUserService {

    public List<User> getUsers();
    public Optional<User> getUser(String id);
    public Optional<User> registerUser(UserRequest userRequest);
    public Optional<User> modifyUser(String id, int score);
    public Optional<User> removeUser(String userId);

}
