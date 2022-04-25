package com.basic.myspringboot.repository;

import com.basic.myspringboot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void save(){
        User user = new User();
        user.setName("신종화");
        user.setEmail("T1t@tt.com");

        User save = userRepository.save(user);

        System.out.println("이름= "+save.getName());
        System.out.println("이메일="+save.getEmail());
    }

}