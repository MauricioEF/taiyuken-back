package com.taiyuken.service;

import com.taiyuken.exception.UserNotFoundException;
import com.taiyuken.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    //Mock
    private final List<User> users = List.of(
            new User(1, "Antonio", "yokingDust", "emailsitoDeYoking", "member"),
            new User(2, "Alejandro", "Axol", "emailDeAxol", "member"),
            new User(3, "Mauricio", "dau", "emailDeDau", "member"),
            new User(4, "Miguel", "teacher", "emailDeTeacher", "member"),
            new User(5, "Uriel", "JefeUri", "emailDeJefe", "member")
    );

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(int id) {
        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getId() == id) {
                return users.get(i);
            }
        }
        throw new UserNotFoundException("Usuario no encontrado");
    }
}
