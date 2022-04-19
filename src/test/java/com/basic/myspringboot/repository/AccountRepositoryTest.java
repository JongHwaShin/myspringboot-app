package com.basic.myspringboot.repository;

import com.basic.myspringboot.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void crud() throws Exception{
        //1. insert

        //Account 객체 생성
        Account account = new Account();
        account.setUsername("spring2");
        account.setPassword("1234");
        Account savedAccount = accountRepository.save(account);

        System.out.println("ID= "+savedAccount.getId());
        System.out.println("username= "+savedAccount.getUsername());



    }

}