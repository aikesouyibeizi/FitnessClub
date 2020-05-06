package com.briup.sports.web.controller;

import com.briup.sports.bean.Member;
import com.briup.sports.bean.Weight;
import com.briup.sports.config.Message;
import com.briup.sports.config.MessageUtil;
import com.briup.sports.service.IMemberService;
import com.briup.sports.service.IWeightService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/weight")
public class WeightController {

    @Autowired
    private IWeightService weightService;
    @Autowired
    private IMemberService memberService;

    @ApiOperation("Weight插入接口")
    @ResponseBody
    @RequestMapping(value = "/insertWeight", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message insertWeight(Weight weight){
        try{
            SimpleDateFormat formatter1= new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat formatter2= new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());
            String weightId = formatter1.format(date);
            String weightDate = formatter2.format(date);
            if(weightId!=null) {
                weight.setWeightId(weightId);
                weight.setWeightDate(weightDate);
                Member member = memberService.findMemberById(Long.parseLong(weight.getMemberId().toString()));
                weight.setMemberWeight(member.getMemberWeight());
                weight.setGoalDistance(weight.getWeightNum() - member.getMemberGoal());
                weight.setWeightChange(weight.getWeightNum() - member.getMemberWeight());
            }

            System.out.println("insertWeight==============:"+weight);
            weightService.insertWeight(weight);
            return MessageUtil.success("添加成功");
        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }


    @ApiOperation("getXDays获取横坐标")
    @ResponseBody
    @RequestMapping(value = "/getXDays", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message getXDays(){
        try{
            System.out.println("getXDays");
            List<String> allDays = weightService.findAllDays();
            return MessageUtil.success(allDays);
        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("getYWeights获取纵坐标")
    @ResponseBody
    @RequestMapping(value = "/getYWeights", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message getYWeights(){
        try{
            System.out.println("getYWeights");
            List<String> allWeights = weightService.findAllWeights();
            return MessageUtil.success(allWeights);
        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("getWeightById获取Weight")
    @ResponseBody
    @RequestMapping(value = "/getWeightById", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message getWeightById(){
        try{
            System.out.println("getWeightById");
//           获取当天的时间，并转化为指定的格式
            SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMdd");
            Date date = new Date(System.currentTimeMillis());
            String weightId = formatter.format(date);


            Weight weight = weightService.findWeightById(weightId);
            if(weight==null){
//            获取前一天的时间，并格式化为指定的格式
                Calendar calendar = Calendar.getInstance();

                calendar.setTime(new Date());
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                Date start = calendar.getTime();

                Date date2 = new Date(start.getTime() - 24*60*60*1000L);
                System.out.println("date22222222"+date2);
                String weightId2 = formatter.format(date2);
                System.out.println(weightId2);
                Weight weight2 = weightService.findWeightById(weightId2);
                System.out.println("weight222222"+weight2);
                return MessageUtil.success(weight2);
            }
            System.out.println(weight);
            return MessageUtil.success(weight);
        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
}
