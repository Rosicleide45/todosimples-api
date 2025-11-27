package org.rosicleidefranca.todosimples.services;

import jakarta.transaction.Transactional;
import org.rosicleidefranca.todosimples.models.User;
import org.rosicleidefranca.todosimples.repositories.TaskRepositorio;
import org.rosicleidefranca.todosimples.repositories.UserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserServices {
    @Autowired
    private UserRepositorio userRepositorio;

    @Autowired
    private TaskRepositorio taskRepositorio;

    public User findById(Long id){
        Optional<User> user = this.userRepositorio.findById(id);
        return user.orElseThrow(()-> new RuntimeException("User de id " + id + " não encontrado"+ User.class.getName()));

    }
    @Transactional
    public User create(User obj){
        obj.setId(null);
        obj = this.userRepositorio.save(obj);
        this.taskRepositorio.saveAll(obj.getTasks());
        return obj;
    }

    @Transactional
    public User update(User obj){
        User newObj= findById(obj.getId());
        newObj.setPassword(obj.getPassword());
        newObj = this.userRepositorio.save(newObj);
        this.taskRepositorio.saveAll(obj.getTasks());
        return newObj;
    }

    public void delete(Long id){
        findById(id);
        try{
            this.userRepositorio.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException( "Não épossivel excluir pois ha tarefas relacionas");
        }
    }
}
