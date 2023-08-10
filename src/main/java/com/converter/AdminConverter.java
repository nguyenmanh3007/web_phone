package com.converter;

import com.dto.AdminDTO;
import com.model.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminConverter {
    public AdminDTO toDTO(Admin admin) {
        AdminDTO adminDTO= AdminDTO.builder()
                .username(admin.getUsername())
                .password(admin.getPassword())
                .fullname(admin.getFullname())
                .id(admin.getId())
                .email(admin.getEmail())
                .phone(admin.getPhone())
                .build();
        return adminDTO;
    }
}
