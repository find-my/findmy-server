package com.example.findmy.domain;

import com.example.findmy.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BaseTimeEntityTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void BaseTimeTest() {
        // given
        LocalDateTime now = LocalDateTime.now();

        User user = new User();
        user.setEmail("lee");

        User testUser = userRepository.save(user);

        assertThat(testUser.getCreatedDate()).isAfter(now);
        assertThat(testUser.getModifiedDate()).isAfter(now);

    }
}