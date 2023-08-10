package com.converter;

import com.dto.UserDTO;
import com.model.User;
import org.springframework.stereotype.Component;


@Component
public class UserConverter {
    public UserDTO toDTO(User user) {
        UserDTO userDTO= UserDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .fname(user.getFname())
                .lname(user.getLname())
                .pass(user.getPassword())
                .build();
        return userDTO;

    }
}
