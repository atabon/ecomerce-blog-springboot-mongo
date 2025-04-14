package com.ti.api.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ti.api.Services.PostServices;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

    @Autowired
    PostServices postServices;
    Map<String, Object> response = new HashMap<>();

    @GetMapping
    public ResponseEntity<Object> getAllPosts() {
        response.clear();
        try {
            response.put("statut_code", 200);
            response.put("posts", postServices.getPosts());
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.put("statut_code", 500);
            response.put("message", e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }
}
