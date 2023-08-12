package com.berzanozgenc.bil344.hw2.service;

import com.berzanozgenc.bil344.hw2.model.User;
import com.berzanozgenc.bil344.hw2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User saveUser(User user) {
        user.setCreationDate(LocalDateTime.now());
        user.setIndexRange(user.getWeight() / (user.getHeight() * user.getHeight()));
        if (user.getIndexRange() < 16){
            user.setIndexResult("Severe Thinness");
        } else if (user.getIndexRange() >= 16 && user.getIndexRange() < 17) {
            user.setIndexResult("Moderate Thinness");
        }
        else if (user.getIndexRange() >= 17 && user.getIndexRange() < 18.5) {
            user.setIndexResult("Mild Thinness");
        }
        else if (user.getIndexRange() >= 18.5 && user.getIndexRange() < 25) {
            user.setIndexResult("Normal Thinness");
        }
        else if (user.getIndexRange() >= 25 && user.getIndexRange() < 30) {
            user.setIndexResult("Overweight Thinness");
        }
        else if (user.getIndexRange() >= 30 && user.getIndexRange() < 35) {
            user.setIndexResult("Obese Class 1 Thinness");
        }
        else if (user.getIndexRange() >= 35 && user.getIndexRange() < 40) {
            user.setIndexResult("Obese Class 2 Thinness");
        }
        else if (user.getIndexRange() >= 40) {
            user.setIndexResult("Obese Class 3 Thinness");
        }
        return userRepository.save(user);
    }

    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }
}
