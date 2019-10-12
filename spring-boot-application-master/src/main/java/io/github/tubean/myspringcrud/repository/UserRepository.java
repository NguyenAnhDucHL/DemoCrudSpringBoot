package io.github.tubean.myspringcrud.repository;

import io.github.tubean.myspringcrud.entity.User;
import io.github.tubean.myspringcrud.model.Object;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findAll();
}


