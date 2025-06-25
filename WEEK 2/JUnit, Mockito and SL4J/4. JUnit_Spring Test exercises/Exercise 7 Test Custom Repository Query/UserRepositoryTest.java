package com.example.repository;

import com.example.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        userRepository.deleteAll();
        userRepository.save(new User(1L, "Alice"));
        userRepository.save(new User(2L, "Bob"));
        userRepository.save(new User(3L, "Alice"));
    }

    @Test
    public void testFindByName_returnsCorrectUsers() {
        List<User> alices = userRepository.findByName("Alice");

        assertThat(alices).hasSize(2);
        assertThat(alices.get(0).getName()).isEqualTo("Alice");
    }
}
