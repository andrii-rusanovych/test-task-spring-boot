package com.example.springboot.testtask.repository;

import com.example.springboot.testtask.entity.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCommentRepository extends JpaRepository<UserComment, Long> {

}
