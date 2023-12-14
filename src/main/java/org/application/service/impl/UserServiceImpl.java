package org.application.service.impl;

import org.application.entity.Patient;
import org.application.entity.User;
import org.application.exceptions.UserNotFoundException;
import org.application.repository.PatientRepository;
import org.application.repository.UserRepository;
import org.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PatientRepository patientRepository) {
        this.userRepository = userRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public List<Patient> getPatientsAddedByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return user.getPatients();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User updatedUser) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));


        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());

        return userRepository.save(existingUser);
    }
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


}

