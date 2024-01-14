package com.learn.GFGjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.GFGjwt.entity.Course;



public interface CourseRepo  extends JpaRepository<Course, Long> {
	  Course findByCourseId(String courseId);
	  List<Course> findByStatusTrue();
}