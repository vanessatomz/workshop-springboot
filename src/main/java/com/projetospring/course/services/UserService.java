package com.projetospring.course.services;

import com.projetospring.course.entities.User;
import com.projetospring.course.repositores.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    //Retornar todos os usuários do banco
    public List<User> findAll(){
        return repository.findAll();
    }

    //Retornar por ID
    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    //Salvar um usuário
    public User insert(User obj){
        return repository.save(obj);
    }

}
