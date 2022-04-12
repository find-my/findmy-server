package com.example.findmy.domain;

import com.example.findmy.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BaseTimeEntityTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void BaseTimeTest() {
        // given
        LocalDateTime now = LocalDateTime.now();

        User user = new User().builder()
                .email("lee")
                .phone("123")
                .build();

        User testUser = userRepository.save(user);

        assertThat(testUser.getCreatedDate()).isAfter(now);
        assertThat(testUser.getModifiedDate()).isAfter(now);

    }
}