package com.sem2.wishapp;

import static org.assertj.core.api.Assertions.assertThat;


import com.sem2.wishapp.entity.User;
import com.sem2.wishapp.entity.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {

  @Autowired
  private UserRepository repo;

  @Autowired
  private TestEntityManager entityManager;

  @Test
  public void testCreateUser(){
    User user = new User();


    user.setFirstName("Dani");
    user.setLastName("Abu Mussa");
    user.setEmail("Dani@gmail.com");
    user.setPassword("Abumoussa33");

    User savedUser = repo.save(user);
    User existUser = entityManager.find(User.class,savedUser.getId());


    assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
  }

}
