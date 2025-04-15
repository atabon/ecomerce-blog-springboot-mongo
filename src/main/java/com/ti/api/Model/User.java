package com.ti.api.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "users")
public class User {

    @Id
    String id;
    String name;

    // nexted object
    @Field("posts")
    List<Post> posts = new ArrayList<>();
}
