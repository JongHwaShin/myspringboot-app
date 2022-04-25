package com.basic.myspringboot.service;

import com.basic.myspringboot.entity.User;
import com.basic.myspringboot.exception.ResourceNotFoundException;
import com.basic.myspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public User insertUser(User user){
        return userRepository.save(user);

    }

    @Transactional(readOnly = true)
    public List<User> selectAllUsers(){
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User selectUser(Long id){
        Optional<User>optionalUser = userRepository.findById(id);
        User existUser = optionalUser.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return existUser;


    }

    public User updateUser(Long id, User userdetail){
        User existUser = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));
        //name 필드 수정
        existUser.setName(userdetail.getName());


        //email 필드 수정
        existUser.setEmail(userdetail.getEmail());

        return existUser;


    }


    public ResponseEntity<?> deleteUser(Long id ){
        Optional<User> optionalUser = userRepository.findById(id);

        //존재하냐?
        //id와 매핑되는 User 객체가 없다면 404 오류를 발생시킨다.
        if(!optionalUser.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " User Not Found");

        }

        User exitUser = optionalUser.get();
        userRepository.delete(exitUser);
        return ResponseEntity.ok("User delete success");

    }

}
