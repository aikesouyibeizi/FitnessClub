package com.briup.sports.web.controller;

import com.briup.sports.bean.Course;
import com.briup.sports.bean.Qas;
import com.briup.sports.config.Message;
import com.briup.sports.config.MessageUtil;
import com.briup.sports.service.ICourseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @ApiOperation("AllCourse查找接口")
    @ResponseBody
    @RequestMapping(value = "/findAllCourses", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message findAllCourses(){
        try{
//            System.out.println("findAllCourses:");
            List<Course> allCourse = courseService.findAllCourse();
//            System.out.println("allCourse:"+allCourse);
            if(allCourse != null){
                return MessageUtil.success(allCourse);
            }else{
                return MessageUtil.error("Course不存在");
            }

        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("Course查找接口")
    @ResponseBody
    @RequestMapping(value = "/findCourseById", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message findCoursesById(String id){
        try{
//            System.out.println("findCoursesById:");

            Course course = courseService.findCourseById(Integer.parseInt(id));
//            System.out.println("Course:"+course);
            if(course != null){
                return MessageUtil.success(course);
            }else{
                return MessageUtil.error("Course不存在");
            }

        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }


    @ApiOperation("Course保存接口")
    @ResponseBody
    @RequestMapping(value = "/saveCourse", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Message saveCourse(@RequestBody Course course){
        try{
            System.out.println("saveCourse:");
            Course course2 = courseService.findCourseById(course.getCourseId());
            if(course2 == null){
                System.out.println("course2为null");
                courseService.saveCourse(course);
                return MessageUtil.success("course保存成功");
            }else{
                return MessageUtil.error("该course已存在");
            }

        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }


    @ApiOperation("Course删除接口")
    @ResponseBody
    @RequestMapping(value = "/deleteCourseById", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message deleteCourseById(String id){
        try{
            System.out.println("deleteCourseById:");

            if(id != null){
                courseService.deleteCourseById(Integer.parseInt(id));
                return MessageUtil.success("course删除成功");
            }else{
                return MessageUtil.error("该course删除失败");
            }

        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("Course更新接口")
    @ResponseBody
    @RequestMapping(value = "/updateCourse", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message updateCourse(Course course){
        try{
            System.out.println("updateCourse:");

            if(course != null){
                courseService.updateCourse(course);
                return MessageUtil.success("course更新成功");
            }else{
                return MessageUtil.error("course更新失败");
            }

        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
}
