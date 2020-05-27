package com.zjweu.controller;

import com.alibaba.fastjson.JSON;
import com.zjweu.domain.Result;
import com.zjweu.entity.User;
import com.zjweu.service.UserService;
import com.zjweu.utils.ResultUtil;
import com.zjweu.verification.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    //注册
    @RequestMapping("saveUser")
    @ResponseBody
    public int save(User user) {
        boolean b = userService.CountByPhone(user.getUphone());
        boolean b1 = userService.CountByUname(user.getUname());
        if(!b){
            return 1;
        }else if(!b1){
            return 2;
        }else {
            boolean isok = userService.save(user);
            int msg = 0;
            if (isok) {
                msg = 200;
            } else {
                msg = 3;
            }
            return msg;
        }
    }

    //验证码
    @RequestMapping("captcha")
    @ResponseBody
    public int captcha(String phone) {
        String cap = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int t = random.nextInt(10);
            cap += String.valueOf(t);
        }
        Verification.sendOne("注册", cap, phone);
        int capt = Integer.parseInt(cap);
        return capt;
    }

    //登录
    @RequestMapping("user_login")
    @ResponseBody
    public int findByUname(String uname, String password, HttpSession session) {
        User user = userService.findByUname(uname);
        int msg = 0;
        if (user != null) {
            if (user.getUpassword().equals(password)) {
                user.setUpassword("");
                session.setAttribute("user", user);
                msg = 200;
            } else {
                msg = 400;
            }
        } else {
            msg = 500;
        }
        return msg;
    }
    //校验登录
    @RequestMapping("checkLogin")
    @ResponseBody
    public Object session(HttpSession session, HttpServletRequest request) {
        session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user!=null){
            return user;
        }else{
            return 400;
        }
    }


    //头像上传
    @RequestMapping("uploadhead")
    @ResponseBody
    public String UpLoad(MultipartFile file,Integer uid,HttpSession session, HttpServletRequest request)throws Exception{
        String name = file.getOriginalFilename();

        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = "*******";
        String secretKey = "******";
        String bucket = "*****";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        long l = System.currentTimeMillis();
        name = name + l;
        String key = "header/"+name;
        String psrc = "*****"+key;
//      http://qaxekv2ti.bkt.clouddn.com/header.jpg
        try {
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(file.getInputStream(),key,upToken,null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

                User user = new User();
                user.setUid(uid);
                user.setUsrc(psrc);
                userService.update(user);
                User user1 = userService.findById(uid);
                session = request.getSession();
                session.setAttribute("user",user1);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
                psrc = "400";
                return psrc;
            }
        } catch (UnsupportedEncodingException ex) {
            //ignore
            psrc = "1";
            return psrc;
        }
        return psrc;
    }


    //更新用户
    @RequestMapping("updateUser")
    @ResponseBody
    public Result<User> updateUser(User user, HttpSession session){
        user.setUid(((User)session.getAttribute("user")).getUid());
        session.setAttribute("user",user);
        return  ResultUtil.success(userService.update(user));
    }
}
