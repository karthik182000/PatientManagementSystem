package org.application.service;

import org.application.entity.Patient;
import org.application.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(Long userId);

    List<Patient> getPatientsAddedByUser(Long userId);

    User createUser(User user);

    User updateUser(Long userId, User updatedUser);

    void deleteUser(Long userId);
}

