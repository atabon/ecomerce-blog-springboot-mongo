package com.ti.api.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.ti.api.Model.Post;
import com.ti.api.Model.User;
import com.ti.api.Repository.UserRepository;

@Service
public class PostServices {

    @Autowired
    UserRepository userRepository;

    public List<Post> getPosts() {
        List<Post> lPosts = new ArrayList<>();

        userRepository.findAll().forEach(user -> {
            if (user.getPosts() != null) {

                List<Post> ps = user.getPosts().stream().map(post -> {
                    Post p = new Post();
                    p.setId(post.getId());
                    p.setTitle(post.getTitle());
                    p.setContent(post.getContent());
                    return p;
                }).collect(Collectors.toList());

                lPosts.addAll(ps);
            }
        });

        return lPosts;
    }

    public List<Post> getPosts(String userId) {

        User user = userRepository.findById(userId).get();

        List<Post> lPosts = user.getPosts().stream().map(post -> {
            Post p = new Post();
            p.setId(post.getId());
            p.setTitle(post.getTitle());
            p.setContent(post.getContent());
            return p;
        }).collect(Collectors.toList());

        return lPosts;
    }

    public Post addUserPost(String userID, Post post) {

        Post p = new Post();

        p.setTitle(post.getTitle());
        p.setContent(post.getContent());

        User updatedUser = userRepository.findById(userID).get();
        updatedUser.getPosts().add(p);
        userRepository.save(updatedUser);
        return p;
    }
}