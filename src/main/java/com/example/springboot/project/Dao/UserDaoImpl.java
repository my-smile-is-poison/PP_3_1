package com.example.springboot.project.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import com.example.springboot.project.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entity;
    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = entity.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public User showUserById(Long id) {
        return entity.find(User.class,id);
    }

    @Override
    public void saveUser(User user) {
        entity.persist(user);

    }

    @Override
    public void deleteUserById(Long id) {
        entity.remove(showUserById(id));

    }

    @Override
    public void updateUserById(Long id, User user) {
        User update = showUserById(id);
        update.setName(user.getName());
        update.setLastName(user.getLastName());

    }
}
