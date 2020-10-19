package com.example.blog.repo;
import com.example.blog.models.User;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}