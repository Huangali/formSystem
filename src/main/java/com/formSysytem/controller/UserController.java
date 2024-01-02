package com.formSysytem.controller;


import com.formSysytem.entity.User;
import com.formSysytem.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@RestController
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<String,Object> login(User user, HttpSession session){
        Map<String,Object> map = new HashMap<>();
//        String s = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
//        System.out.println(s);
//        user.setPassword(s);
        User b = userService.login(user);
        if (b != null) {
            if (!b.getPassword().equals(user.getPassword())){
                map.put("code", 0);
                map.put("success", false);
                map.put("msg", "密码错误");
            }else {
                map.put("code", 0);
                map.put("success", true);
                map.put("msg", "登录成功");
                session.setAttribute("user", b);
            }
        }else {
            map.put("code", 0);
            map.put("success",false);
            map.put("msg", "用户不存在");
        }
        return map;
    }

    @RequestMapping("/logout")
    public RedirectView logout(HttpSession httpSession, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        httpSession.removeAttribute("user");
        // 创建重定向视图
        request.getSession().invalidate();
        RedirectView redirectView = new RedirectView(request.getContextPath()+ "/login.html");
        redirectView.setExposeModelAttributes(false); // 防止将 model 属性暴露到 URL 上

        return redirectView;
    }

    @RequestMapping("/saveUser")
    public Map<String,Object> saveUser(User user,HttpSession httpSession){
        Map<String,Object> map = new HashMap<>();
        User attribute = (User) httpSession.getAttribute("user");
        if (attribute != null){

            user.set_id(attribute.get_id());
            user.setUserName(attribute.getUserName());
            if (!Objects.equals(user.getPassword(), attribute.getPassword())){
                map.put("code", 0);
                map.put("success",false);
                map.put("msg", "旧密码错误");
            }else {

                int update = userService.update(user);
                if (update <= 0) {
                    map.put("code", 0);
                    map.put("success", false);
                    map.put("msg", "修改失败");
                } else {
                    attribute.setPassword(user.getNewPassword());
                    httpSession.setAttribute("user", attribute);
                    map.put("code", 0);
                    map.put("success", true);
                    map.put("msg", "修改成功");
                }
            }
        }else {
            if (user.getUserName() == null){
                map.put("code", 0);
                map.put("success",false);
                map.put("msg", "用户名不能为空");
                return map;
            }
            if (user.getPassword() == null){
                map.put("code", 0);
                map.put("success",false);
                map.put("msg", "密码不能为空");
                return map;
            }
            User user1 = userService.getByName(user.getUserName());
            if (user1 == null) {
                int insert = userService.insert(user);
                if (insert <= 0) {
                    map.put("code", 0);
                    map.put("success", false);
                    map.put("msg", "注册失败");
                } else {
                    map.put("code", 0);
                    map.put("success", true);
                    map.put("msg", "注册成功");
                }
            }else {
                map.put("code", 0);
                map.put("success", false);
                map.put("msg", "用户名已存在");
            }
        }
        return map;
    }
}
