package com.pms.pms.mapper;

import com.pms.pms.Dto.UserDto;
import com.pms.pms.Entity.User;
import com.pms.pms.Repository.RoleRepository;
import com.pms.pms.Repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class UserMapper {

    public User mapToUserDto(UserDto userDto){
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .phone(userDto.getPhone())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }
}
