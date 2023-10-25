package com.projetospring.course.services;

import com.projetospring.course.entities.User;
import com.projetospring.course.repositores.UserRepository;
import com.projetospring.course.services.exceptions.DatabaseException;
import com.projetospring.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //Salvar um usuário
    public User insert(User obj){
        return repository.save(obj);
    }

    //Deletar um usuário
    public void delete(Long id) {
        try {
            if (repository.existsById(id)) {                     // Verifica se existe
                repository.deleteById(id);                       // apaga
            } else {
                throw new ResourceNotFoundException(id);          // se nao existe lança essa exeção
            }
        } catch (DataIntegrityViolationException e) {           // erro caso tente apagar um id que tenha pedido associado
            throw new DatabaseException(e.getMessage());
        }
    }

    //Atualizar um usuário
    public User update(Long id,User obj){
        User entity = repository.getReferenceById(id);
        updateData(entity,obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }


}
