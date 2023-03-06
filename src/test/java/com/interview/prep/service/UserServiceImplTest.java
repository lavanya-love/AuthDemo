package com.interview.prep.service;

import lombok.val;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void test() {
        val response = userService.getHealth();
        Assert.assertEquals("Sample response", response);
    }

    @Test
    public void test_getAllUsers() {
        val response = userService.getAllUsers();
        System.out.println(response);

    }

}
