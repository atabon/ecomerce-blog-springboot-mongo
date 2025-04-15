package com.ti.api.Services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.ti.api.Model.User;
import com.ti.api.Repository.UserRepository;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        users = userRepository.findAll();
        return users;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(String id) {
        return userRepository.findById(id).get();
    }

    public User updateUser(String id, User user) {
        User updatedUser = userRepository.findById(id).get();
        updatedUser.setName(user.getName());
        userRepository.save(updatedUser);
        return updatedUser;
    }

    // requette personnalisee avec MongoTamplate
    public List<User> whereUserLike(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(name, "i"));
        return mongoTemplate.find(query, User.class);
    };

    @Autowired
    private MongoTemplate mongoTemplate;
}
