package org.rosicleidefranca.todosimples.services;

import org.rosicleidefranca.todosimples.models.User;
import org.rosicleidefranca.todosimples.repositories.UserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServices {
    @Autowired
    private UserRepositorio userRepositorio;
    public List<User> findAll() {
       return userRepositorio.findAll();
    }



}
