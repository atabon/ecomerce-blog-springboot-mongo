package com.ti.api.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ti.api.Mapper.PostMapper;
import com.ti.api.Model.Post;
import com.ti.api.Services.PostServices;

@RestController
@RequestMapping("/v1/blog")
public class PostController {

    @Autowired
    PostServices postServices;

    Map<String, Object> response = new HashMap<>();

    @GetMapping
    public ResponseEntity<Object> getAllPosts() {
        response.clear();
        try {
            response.put("statut_code", 200);
            response.put("posts", PostMapper.toPostsDTO(postServices.getPosts()));
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.put("statut_code", 500);
            response.put("message", e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @PatchMapping("/{userID}/posts")
    public ResponseEntity<Object> savePost(@PathVariable String userID, @RequestBody Post post) {
        response.clear();
        try {
            response.put("statut_code", 200);
            response.put("posts", PostMapper.toPostDTO(postServices.addUserPost(userID, post)));
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.put("statut_code", 500);
            response.put("message", e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping("/{userID}/posts")
    public ResponseEntity<Object> getPosts(@PathVariable String userID) {
        response.clear();
        try {
            response.put("statut_code", 200);
            response.put("posts", PostMapper.toPostsDTO(postServices.getPosts(userID)));
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.put("statut_code", 404);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

}
