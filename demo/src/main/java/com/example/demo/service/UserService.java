package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByID(Long id) {
        return userRepository.findById(id).get();
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public Page<User> findPage() {
        Pageable pageable = PageRequest.of(0, 10);
        return userRepository.findAll(pageable);
    }

    public Page<User> find(Long maxID) {
        Pageable pageable = PageRequest.of(0, 10);
        return userRepository.findMore(maxID, pageable);
    }

    public User save(User u) {
        return userRepository.save(u);
    }

    public User update(Long id, String name) {
        User user = userRepository.findById(id).get();
        user.setName(name);
        return userRepository.save(user);    
    }

    public Boolean updateById(String name, Long id) {
        return userRepository.updateById(name, id) == 1;
    }
}
