package com.example.findmy.repository;

import com.example.findmy.domain.Review;
import com.example.findmy.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void save(){
        // given
        User user = new User().builder()
                .id(1L)
                .name("lee")
                .email("lee")
                .password("1234")
                .phone("010")
                .avatar("lee")
                .build();

        Review review = new Review().builder()
                .createdById(user)
                .build();

        // when
        userRepository.save(user);
        reviewRepository.save(review);

        // then

        assertEquals(user.getId(), reviewRepository.findById(1L).orElseThrow().getCreatedById().getId());

    }
}