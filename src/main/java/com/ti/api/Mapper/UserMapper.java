package com.ti.api.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.ti.api.DTO.UserDTO;
import com.ti.api.Model.User;

public class UserMapper {

    public static UserDTO toUser(User user) {
        UserDTO u = new UserDTO();
        u.setId(user.getId());
        u.setName(user.getName());
        return u;
    }

    public static List<UserDTO> toUsersWithoutPosts(List<User> users) {

        List<UserDTO> udtos = users.stream().map(user -> {
            UserDTO udto = new UserDTO();
            udto.setId(user.getId());
            udto.setName(user.getName());

            return udto;
        }).collect(Collectors.toList());

        return udtos;
    }

}
