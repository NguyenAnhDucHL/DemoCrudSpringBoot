package io.github.tubean.myspringcrud.repository;

import io.github.tubean.myspringcrud.model.Object;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectRepository extends JpaRepository<Object,Long> {
    @Query(value = "select u.user_id, u.full_name, u.email, u.mobile, r.use_role from user u inner join use_role r on u.user_id = r.user_user_id",nativeQuery = true)
    public List<Object> findInformation();
}
