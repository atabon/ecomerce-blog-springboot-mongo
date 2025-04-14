package com.ti.api.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ti.api.Documents.User;
import com.ti.api.Services.UserServices;

@RequestMapping("/v1/user")
@RestController
public class UserController {
    @Autowired
    UserServices userServices;

    Map<String, Object> response = new HashMap<>();

    @GetMapping
    public ResponseEntity<Object> getUsers() {

        response.clear();
        try {
            response.put("statut_code", 200);
            response.put("users", userServices.getAllUsers());
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.put("statut_code", 500);
            response.put("message", e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        response.clear();
        try {
            response.put("statut_code", 201);
            response.put("user", userServices.createUser(user));
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.put("statut_code", 500);
            response.put("message", e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable String id) {
        response.clear();
        try {
            response.put("statut_code", 200);
            response.put("user", userServices.getUserById(id));
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.put("statut_code", 404);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

}
