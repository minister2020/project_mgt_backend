package com.pms.pms.service;




import com.pms.pms.Dto.UserDto;
import com.pms.pms.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(UserDto userdto);

    List<User> getAllUser();

    Optional<User> getUserById(Long id);

    User updateUser(User user, Long id);

    void deleteUser(Long id);
}
