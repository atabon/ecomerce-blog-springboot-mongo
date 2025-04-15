package com.ti.api.Model;

import java.util.UUID;

import lombok.Data;

@Data
public class Post {
    String id = UUID.randomUUID().toString();
    String title;
    String content;
}
