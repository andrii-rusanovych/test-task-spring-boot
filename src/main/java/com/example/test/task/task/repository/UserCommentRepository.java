package com.example.test.task.task.repository;

import com.example.test.task.task.entity.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCommentRepository extends JpaRepository<UserComment, Long> {

}
