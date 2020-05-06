package com.briup.sports.service.impl;

import com.briup.sports.bean.Course;
import com.briup.sports.bean.CourseExample;
import com.briup.sports.mapper.CourseMapper;
import com.briup.sports.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseMapper courseMapper;
    @Override
    public List<Course> findAllCourse() {
        CourseExample example = new CourseExample();
        List<Course> courses = courseMapper.selectByExample(example);
        return courses;

    }

    @Override
    public Course findCourseById(int id) {

        CourseExample example = new CourseExample();
        example.createCriteria().andCourseIdEqualTo(id);
        List<Course> courses = courseMapper.selectByExample(example);
        if(courses.size()==0){

            return null;
        }else{
            return courses.get(0);
        }


    }

    @Override
    public void saveCourse(Course course) {
        CourseExample courseExample = new CourseExample();
        System.out.println(course);
        courseMapper.insert(course);
    }

    @Override
    public void deleteCourseById(Integer id) {
        CourseExample example = new CourseExample();
        example.createCriteria().andCourseIdEqualTo(id);
        courseMapper.deleteByExample(example);
    }

    @Override
    public void updateCourse(Course course) {
        CourseExample example = new CourseExample();
        example.createCriteria().andCourseIdEqualTo(course.getCourseId());
        courseMapper.updateByExample(course,example);
    }
}
