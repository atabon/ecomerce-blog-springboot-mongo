package com.ti.api.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.ti.api.DTO.PostDTO;
import com.ti.api.Model.Post;

public class PostMapper {

    public static List<PostDTO> toPostsDTO(List<Post> posts) {

        List<PostDTO> pdtos = posts.stream().map(post -> {
            PostDTO pdto = new PostDTO();
            pdto.setId(post.getId());
            pdto.setTitle(post.getTitle());
            pdto.setContent(post.getContent());
            return pdto;
        }).collect(Collectors.toList());

        return pdtos;
    }

    public static PostDTO toPostDTO(Post post) {
        PostDTO pdto = new PostDTO();
        pdto.setId(post.getId());
        pdto.setTitle(post.getTitle());
        pdto.setContent(post.getContent());
        return pdto;
    }
}
