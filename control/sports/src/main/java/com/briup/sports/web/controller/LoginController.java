package com.briup.sports.web.controller;

import com.briup.sports.bean.Addr;
import com.briup.sports.bean.Member;
import com.briup.sports.bean.Qas;
import com.briup.sports.bean.Role;
import com.briup.sports.config.CommonException;
import com.briup.sports.config.Message;
import com.briup.sports.config.MessageUtil;
import com.briup.sports.service.IAddrService;
import com.briup.sports.service.IMemberService;
import com.briup.sports.service.IQasService;
import com.briup.sports.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/member")
public class LoginController {

    @Autowired
    private IMemberService memberService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IQasService qasService;
    @Autowired
    private IAddrService addrService;



    @ApiOperation("会员登录接口")
    @ResponseBody
    @RequestMapping(value = "/loginByPassword", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message checkLoginById(String id, String password){
        System.out.println("我进来啦=======");
        System.out.println("===id====="+id+"=====password===="+password);
        try {

            Long l = Long.parseLong(id);
            Member member = memberService.findMemberById(l);
            System.out.println("====member"+member);
            if(member==null){
                System.out.println("用户不存在");
                return MessageUtil.error("用户不存在");
            }else{
                if(password.equals(member.getMemberPassword())){
                    int flag = 1;
                    member.setMemberFlag(flag);;
                    memberService.updateMember(member);
                    Member m = memberService.findMemberById(l);
                    return MessageUtil.success(m);
                }else {
                    return MessageUtil.error("密码错误");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @ApiOperation("会员注册接口")
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message register(Member member){
        try {
            Integer id = member.getMemberId();
            long id2 = Long.parseLong(id.toString());
            Member member2 = memberService.findMemberById(id2);
            if(member2!=null){
                return MessageUtil.error("用户已存在");
            }else{
                int i = memberService.insertMember(member);
                return MessageUtil.success("i="+i);
            }
        }catch (Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("会员编辑接口")
    @ResponseBody
    @RequestMapping(value = "/updateMember", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message updateMember(Member member){
        try{
            Integer id = member.getMemberId();
            Member member2 = memberService.findMemberById(Long.parseLong(id.toString()));
            if(member2!=null){
                member.setCourseId(member2.getCourseId());
                member.setRoleId(member2.getRoleId());
                member.setMemberFlag(member2.getMemberFlag());
                memberService.updateMember(member);
            }else{
                memberService.updateMember(member);
            }
            Member member3 = memberService.findMemberById(Long.parseLong(id.toString()));

            return MessageUtil.success(member3);

        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }

    }

    @ApiOperation("会员新增接口BYPOST")
    @ResponseBody
    @RequestMapping(value = "/saveMember", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Message updateMemberByPOST(@RequestBody Member member){
        try{
            Integer memberId = member.getMemberId();
            long memberId2 = Long.parseLong(memberId.toString());
            Member member2 = memberService.findMemberById(memberId2);
            if(member2!=null){
                return MessageUtil.error("用户已存在");
            }else{
                int i = memberService.insertMember(member);
                return MessageUtil.success("i="+i);
            }
        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }

    }

    @ApiOperation("MemberById查找接口")
    @ResponseBody
    @RequestMapping(value = "/findMemberById", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message findMemberById(String id){
        try{
            System.out.println("findMemberById");
            Member member = memberService.findMemberById(Long.parseLong(id));
            System.out.println("findMemberById:"+member);
            if(member != null){
                return MessageUtil.success(member);
            }else{
                return MessageUtil.error("Members不存在");
            }

        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }


    @ApiOperation("AllMember查找接口")
    @ResponseBody
    @RequestMapping(value = "/findAllMemberByRole", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message findAllMemberByRole(String role){
        try{
            System.out.println("findAllMember");
            List<Member> members = memberService.findAllMemberByRole(role);
            System.out.println("findAllMember:"+members);
            if(members != null){
                return MessageUtil.success(members);
            }else{
                return MessageUtil.error("Members不存在");
            }

        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("Member删除接口")
    @ResponseBody
    @RequestMapping(value = "/deleteMemberById", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message deleteMemberById(String id){
        try{
            System.out.println("deleteMemberById");
            memberService.deleteByMemberId(Integer.parseInt(id));
            return MessageUtil.success("Member删除成功");

        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }





    @ApiOperation("Qas查找接口")
    @ResponseBody
    @RequestMapping(value = "/findQasById", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message findQasById(String id){
        try{
            int i = Integer.parseInt(id);
            Qas qas = qasService.findQasById(i);
            if(qas != null){
                return MessageUtil.success(qas);
            }else{
                return MessageUtil.error("该QAS不存在");
            }

        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("AllQas查找接口")
    @ResponseBody
    @RequestMapping(value = "/findAllQas", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message findAllQas(){
        try{
            List<Qas> allQas = qasService.findAllQas();
            System.out.println("allQas:"+allQas);
            if(allQas != null){
                return MessageUtil.success(allQas);
            }else{
                return MessageUtil.error("QAS不存在");
            }

        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("AllAddr查找接口")
    @ResponseBody
    @RequestMapping(value = "/findAllAddr", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message findAllAddr(){
        try{
            List<Addr> addrs = addrService.findAllAddrs();
            if(addrs != null){
                return MessageUtil.success(addrs);
            }else{
                return MessageUtil.error("Addr不存在");
            }

        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("Addr查找接口")
    @ResponseBody
    @RequestMapping(value = "/findAddrById", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message findAddrById(String id){
        try{
            int i = Integer.parseInt(id);
            Addr addr = addrService.findAddrById(i);
            if(addr != null){
                return MessageUtil.success(addr);
            }else{
                return MessageUtil.error("该Addr不存在");
            }

        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }


    @ApiOperation("地址编辑接口")
    @ResponseBody
    @RequestMapping(value = "/updateAddr", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Message updateAddr(Addr addr){
        try{
            System.out.println("updateAddrController\n"+addr);
            Integer id = addr.getAddrId();
            Addr addr2 = addrService.findAddrById(id);
            if(addr2!=null){
                addr.setMemberId(addr2.getMemberId());
                int i = addrService.updateAddr(addr);
                return MessageUtil.success("i="+i);
            }else{
                return MessageUtil.error("该地址不存在");
            }

        }catch(Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());
        }

    }

}
