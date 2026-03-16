package com.ms.user.service;

import com.ms.user.model.User;
import com.ms.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(User user) {
        var userModel = userRepository.save(user);
        // userProducer.publishMessageEmail(userModel);

        return userModel;
    }
}
