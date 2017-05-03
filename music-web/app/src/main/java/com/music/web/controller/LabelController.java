package com.music.web.controller;

import com.music.web.constant.JsonResult;
import com.music.web.entity.Label;
import com.music.web.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 标签相关接口
 * Created by Administrator on 2017/5/1.
 */
@Controller
@RequestMapping(value = "label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 新建标签
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public JsonResult add(HttpServletRequest request, Model model,Label label){
       if(StringUtils.isEmpty(label.getName())){
           return new JsonResult("201","标签名不能为空","");
       }
        //判断标签是否存在
        if(null != labelService.selectLabel(label.getName(),1)){
            return new JsonResult("201","标签已经存在","");
        }
        if(!labelService.insertLabel(label)){
            return new JsonResult("201","标签新建失败","");
        }
        return new JsonResult("200","标签新建成功","");
    }

    /**
     * 删除标签
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete")
    public JsonResult delete(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
       if( StringUtils.isEmpty(id) ){
            return new JsonResult("201","参数获取失败","");
       }
        if(!labelService.deletLabelById(Integer.valueOf(id))){
            return new JsonResult("201","删除标签失败","");
        }
        return new JsonResult("200","删除标签成功","");
    }

    /**
     * 获取标签
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "get")
    public JsonResult get(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        if( StringUtils.isEmpty(id) ){
            return new JsonResult("201","参数获取失败","");
        }
        Label label = labelService.selectLabel(id,0);
        return new JsonResult("200","获取标签成功",label);
    }
}
