package com.ti.api.Documents;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "posts")
public class Post {

    String id = UUID.randomUUID().toString();
    String title;
    String content;
}
