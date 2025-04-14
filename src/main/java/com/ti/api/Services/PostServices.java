package com.ti.api.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ti.api.Documents.Post;
import com.ti.api.Repository.UserRepository;

@Service
public class PostServices {

    @Autowired
    UserRepository userRepository;

    public List<Post> getPosts() {
        List<Post> lPosts = new ArrayList<>();

        userRepository.findAll().forEach(user -> {
            lPosts.addAll(user.getPosts());
        });

        return lPosts;
    }
}
