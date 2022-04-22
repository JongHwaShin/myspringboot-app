package com.basic.myspringboot.repository;

import com.basic.myspringboot.entity.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
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

        Optional<Account> exitAcct = accountRepository.findByUsername(savedAccount.getUsername());
        assertThat(exitAcct).isNotNull();

        Optional<Account> notExistAcct = accountRepository.findByUsername("test");
        assertThat(notExistAcct).isNull();



    }

}