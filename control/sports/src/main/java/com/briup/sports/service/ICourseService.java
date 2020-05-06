package com.briup.sports.service;

import com.briup.sports.bean.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICourseService {
    public List<Course> findAllCourse();
    public Course findCourseById(int id);
    public void saveCourse(Course course);
    public void deleteCourseById(Integer id);
    public void updateCourse(Course course);
}
