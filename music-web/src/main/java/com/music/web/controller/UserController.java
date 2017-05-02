package com.music.web.controller;

import com.music.web.constant.CommonConstants;
import com.music.web.constant.JsonResult;
import com.music.web.constant.JsonResultCode;
import com.music.web.entity.User;
import com.music.web.service.UserService;
import org.aspectj.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by Administrator on 2016/11/17.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static  final Logger logger  = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    /**
     * 显示修改用户界面的信息
     * @param request
     * @param
     * @return
     */
    @RequestMapping(value = "showInfo",method = {RequestMethod.GET, RequestMethod.POST})
    public String editInfo(HttpServletRequest request, Model model, HttpServletResponse response){
        return "userInfo";
    }



    /**
     * 修改用户信息操作
     * @param request
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "editInfo",method = {RequestMethod.GET, RequestMethod.POST})
    public Object editInfo(HttpServletRequest request,User user){
        if(user.getId() < 0){
            return  new JsonResult(JsonResultCode.FAILURE,"修改用户失败","");
        }

        //修改用户操作
        boolean result = userService.modifyUserInfo(user);
        if(!result){
            return  new JsonResult(JsonResultCode.FAILURE,"修改用户失败","");
        }

        return  new JsonResult(JsonResultCode.SUCCESS,"修改用户成功","");
    }


    @ResponseBody
    @RequestMapping(value = "uploadImg" ,method = {RequestMethod.GET, RequestMethod.POST})
    public  Object uploadImage(MultipartHttpServletRequest request,@RequestParam("filedata") MultipartFile file){
        String uploadPath = request.getServletContext().getRealPath("/assets/uploads/");
        //获取图片
       // List<MultipartFile> files = request.getFiles("filedata");
       /* 获取用户id*/
        User user = (User)request.getSession().getAttribute(CommonConstants.CURRENT_USER);
        Integer createBy = user.getId();

        /*List<String> urList = new ArrayList<String>();*/
        String imgPath = new String();
        //对每个图片进行操作
      /*  for(MultipartFile file:files)
        {*/
            if(!StringUtils.isEmpty(file.getOriginalFilename()))
            {
                //判断文件的大小
                if(file.getSize() > 1000000)
                {
                    return new JsonResult(JsonResultCode.FAILURE,"上传文件最大为1M","");
                }
                // 文件后缀名
                String postfix = com.music.web.util.FileUtil.getPostfix(file.getOriginalFilename());
                // 相对路径+时间戳
                String pathNotHavingPostfix = "headImg/"+ createBy +"/" + System.currentTimeMillis();
                //相对路径+时间戳+文件后缀名
                String pathHasPostfix=pathNotHavingPostfix + "." + postfix;
                // 相对路径+时间戳+文件后缀名
                String path =uploadPath + pathHasPostfix;

                try
                {
                    // 保证文件系统中目录确实存在
                    File dirPath = new File(uploadPath +"headImg/"+ createBy +"/" );
                    if (!dirPath.exists())
                    {
                        dirPath.mkdirs();
                    }
                    // 存储图片
                    file.transferTo(new File(path));

                } catch (Exception e)
                {
                    logger.error("存储图片失败的原因是"+e.getLocalizedMessage()+e.getMessage()+e.getCause());
                    return new JsonResult(JsonResultCode.FAILURE,"图片存储失败","");
                }

                //及时存储新头像
                imgPath = "/assets/uploads"+pathHasPostfix;
                user.setHeadImg(imgPath);
                userService.modifyUserInfo(user);
               /* 更新用户*/
                request.getSession().setAttribute(CommonConstants.CURRENT_USER,user);

            }
      /*  }*/
        return new JsonResult(JsonResultCode.SUCCESS,"上传图片成功",imgPath);
    }

    /**
     * 修改用户信息操作
     * @param request
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "status",method = {RequestMethod.GET, RequestMethod.POST})
    public Object modifyUserStatus(HttpServletRequest request){
        String uid = request.getParameter("uid");
        String status = request.getParameter("status");
        if(Long.valueOf(uid) < 0){
            return  new JsonResult(JsonResultCode.FAILURE,"禁用用户失败","");
        }
        //修改用户操作
        boolean result = userService.modifyUserSatsu(Long.valueOf(uid),Integer.valueOf(status));
        if(!result){
            return  new JsonResult(JsonResultCode.FAILURE,"操作失败","");
        }

        return  new JsonResult(JsonResultCode.SUCCESS,"操作成功","");
    }
}
