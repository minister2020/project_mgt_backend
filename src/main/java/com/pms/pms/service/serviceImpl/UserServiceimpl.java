package com.pms.pms.service.serviceImpl;

import com.pms.pms.Dto.UserDto;
import com.pms.pms.Entity.User;
import com.pms.pms.Exception.ResourceNotFoundException;
import com.pms.pms.Repository.UserRepository;
import com.pms.pms.service.UserService;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceimpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }




    public User createUser(UserDto userDto) {
        User user = new User();

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());

        return userRepository.save(user);
    }


    @Override
    public List<User> getAllUser() {
// TODO Auto-generated method stub
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {

        Optional<User> user = Optional.ofNullable(userRepository.findById(id).get());
        if (user.isPresent()) {
            return Optional.of(user.get());
        } else {
            throw new ResourceNotFoundException("User", "id", id);
        }
    }

    @Override
    public User updateUser(User user, Long id) {

        User existingUser = userRepository.findById(id).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setPhone(user.getPhone());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}