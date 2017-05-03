package com.music.web.controller;

import com.music.web.constant.JsonResult;
import com.music.web.entity.Suggestion;
import com.music.web.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 建议相关
 * Created by Administrator on 2017/5/1.
 */
@RequestMapping(value = "suggestion")
@Controller
public class SuggestionController {

    @Autowired
    private SuggestionService suggestionService;

    /**
     * 新建一个建议
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public JsonResult add(HttpServletRequest request, Model model, Suggestion suggestion){
        suggestion.setCreatetime(new Date());
        if(!suggestionService.insertSuggestion(suggestion)){
            return new JsonResult("201","新建建议失败","");
        }
        return new JsonResult("200","新建成功","");
    }

    /**
     * 获取所有的建议
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "all")
    public JsonResult getAll(HttpServletRequest request, Model model, Suggestion suggestion){
        List<Suggestion> suggestions = suggestionService.selectSuggestions();
        return new JsonResult("200","获取建议成功",suggestions);
    }
}
