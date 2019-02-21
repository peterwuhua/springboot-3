package com.imooc.controller;

import com.imooc.pojo.IMoocJSONResult;
import com.imooc.pojo.SysUser;
import com.imooc.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author Arsenal
 * created on 2019/2/21 22:55
 */
@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {

    private final UserService userService;

    private final Sid sid;

    @Autowired
    public MyBatisCRUDController(UserService userService, Sid sid) {
        this.userService = userService;
        this.sid = sid;
    }

    @RequestMapping("/saveUser")
    public IMoocJSONResult saveUser() {

        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("imooc" + new Date());
        user.setNickname("imooc" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUser(user);

        return IMoocJSONResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public IMoocJSONResult updateUser() {

        SysUser user = new SysUser();
        user.setId("10011001");
        user.setUsername("10011001-updated" + new Date());
        user.setNickname("10011001-updated" + new Date());
        user.setPassword("10011001-updated");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.updateUser(user);

        return IMoocJSONResult.ok("保存成功");
    }

    @RequestMapping("/deleteUser")
    public IMoocJSONResult deleteUser(String userId) {

        userService.deleteUser(userId);

        return IMoocJSONResult.ok("删除成功");
    }

    @RequestMapping("/queryUserById")
    public IMoocJSONResult queryUserById(String userId) {

        return IMoocJSONResult.ok(userService.queryUserById(userId));
    }

    @RequestMapping("/queryUserList")
    public IMoocJSONResult queryUserList() {

        SysUser user = new SysUser();
        user.setUsername("imooc");
        user.setNickname("lee");

        List<SysUser> userList = userService.queryUserList(user);

        return IMoocJSONResult.ok(userList);
    }

    @RequestMapping("/queryUserListPaged")
    public IMoocJSONResult queryUserListPaged(Integer page) {

        if (page == null) {
            page = 1;
        }

        int pageSize = 3;

        SysUser user = new SysUser();
//        user.setNickname("lee");

        List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);

        return IMoocJSONResult.ok(userList);
    }

    @RequestMapping("/queryUserByIdCustom")
    public IMoocJSONResult queryUserByIdCustom(String userId) {

        return IMoocJSONResult.ok(userService.queryUserByIdCustom(userId));
    }

    @RequestMapping("/saveUserTransactional")
    public IMoocJSONResult saveUserTransactional() {

        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("lee" + new Date());
        user.setNickname("lee" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUserTransactional(user);

        return IMoocJSONResult.ok("保存成功");
    }
}
