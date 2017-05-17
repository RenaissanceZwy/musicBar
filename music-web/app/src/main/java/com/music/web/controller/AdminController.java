package com.music.web.controller;

import com.music.web.constant.JsonResult;
import com.music.web.constant.JsonResultCode;
import com.music.web.entity.Album;
import com.music.web.entity.Label;
import com.music.web.entity.User;
import com.music.web.service.*;
import com.music.web.util.PageUtil;
import com.music.web.vo.CommentInfo;
import com.music.web.vo.PostingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 赵文奕 on 2016/11/23.
 * 后台管理界面
 */
@RequestMapping("admin")
@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostingService postingService;

    @Autowired
    private LabelService labelService;

    @Autowired
    private AlbumService albumService;

    /**
     * 主页显示
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/index")
    public String test(HttpServletRequest request,Model model, HttpServletResponse response ){
        /*获取所有的评论*/
        List<CommentInfo> commentInfos = commentService.getComments();
        model.addAttribute("commentInfos",commentInfos);

        /*获取所有的用户*/
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);

        return "admin";
    }


    /**
     * 用户管理界面
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping(value = "/user")
    public String adminUser(HttpServletRequest request,Model model,HttpServletResponse response){
        //获取用户名称
        String name = request.getParameter("name");
        //获取分页的页码
        String pageNumStr = request.getParameter("monitorPageNum");
        int pageNum = StringUtils.isEmpty(pageNumStr)?0:Integer.valueOf(pageNumStr);
        //获取分页的大小
        String pageSizeStr = request.getParameter("pageSize");
        int pageSize = StringUtils.isEmpty(pageSizeStr)?15:Integer.valueOf(pageSizeStr);

        /*获取所有的用户*/
        int totalNum = userService.getAllUsers(pageNum,0,name).size();

        List<User> users = userService.getAllUsers(pageNum,pageSize,name);
        PageUtil monitor_paging_vo = new PageUtil(pageSize,totalNum,pageNum);
        monitor_paging_vo.setObject(users);

        model.addAttribute("paging",monitor_paging_vo);
        model.addAttribute("page_type","100");

        return "admin/user";
    }

    /**
     * 评论管理界面
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping(value = "/comment")
    public String adminComment(HttpServletRequest request,Model model,HttpServletResponse response){
        //获取用户名称
        String name = request.getParameter("name");
        //获取分页的页码
        String pageNumStr = request.getParameter("monitorPageNum");
        int pageNum = StringUtils.isEmpty(pageNumStr)?0:Integer.valueOf(pageNumStr);
        //获取分页的大小
        String pageSizeStr = request.getParameter("pageSize");
        int pageSize = StringUtils.isEmpty(pageSizeStr)?15:Integer.valueOf(pageSizeStr);
         /*获取所有的评论*/
        int totalNum = commentService.getComments(pageNum,0,name).size();

        List<CommentInfo> commentInfos = commentService.getComments(pageNum,pageSize,name);
        PageUtil monitor_paging_vo = new PageUtil(pageSize,totalNum,pageNum);
        monitor_paging_vo.setObject(commentInfos);

        model.addAttribute("paging",monitor_paging_vo);
        model.addAttribute("page_type","200");


        return "admin/comment";
    }


    /**
     * 帖子管理界面
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping(value = "/post")
    public String adminPost(HttpServletRequest request,Model model,HttpServletResponse response){

        //获取用户名称
        String name = request.getParameter("name");
        //获取分页的页码
        String pageNumStr = request.getParameter("monitorPageNum");
        int pageNum = StringUtils.isEmpty(pageNumStr)?0:Integer.valueOf(pageNumStr);
        //获取分页的大小
        String pageSizeStr = request.getParameter("pageSize");
        int pageSize = StringUtils.isEmpty(pageSizeStr)?15:Integer.valueOf(pageSizeStr);
         /*获取所有的帖子*/
        int totalNum = postingService.selectPostings(pageNum,0,name).size();

        List<PostingVo> postingVos = postingService.selectPostings(pageNum,pageSize,name);
        PageUtil monitor_paging_vo = new PageUtil(pageSize,totalNum,pageNum);
        monitor_paging_vo.setObject(postingVos);

        model.addAttribute("paging",monitor_paging_vo);
        model.addAttribute("page_type","300");


        return "admin/post";
    }

    /**
     * 音乐管理界面
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping(value = "/music")
    public String adminMusic(HttpServletRequest request,Model model,HttpServletResponse response){

        /*获取所有的评论*/
        List<CommentInfo> commentInfos = commentService.getComments();
        model.addAttribute("commentInfos",commentInfos);
        model.addAttribute("page_type","400");


        return "admin/music";
    }

    /**
     *专辑管理界面
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping(value = "/album")
    public String adminAlbum(HttpServletRequest request,Model model,HttpServletResponse response){
        //获取专辑名称
        String name = request.getParameter("name");
        //获取分页的页码
        String pageNumStr = request.getParameter("monitorPageNum");
        int pageNum = StringUtils.isEmpty(pageNumStr)?0:Integer.valueOf(pageNumStr);
        //获取分页的大小
        String pageSizeStr = request.getParameter("pageSize");
        int pageSize = StringUtils.isEmpty(pageSizeStr)?15:Integer.valueOf(pageSizeStr);
         /*获取所有的帖子*/
        int totalNum = albumService.selectAllAlbums(pageNum,0,name).size();

        List<Album> albumList = albumService.selectAllAlbums(pageNum,pageSize,name);
        PageUtil monitor_paging_vo = new PageUtil(pageSize,totalNum,pageNum);
        monitor_paging_vo.setObject(albumList);

        model.addAttribute("paging",monitor_paging_vo);
        model.addAttribute("page_type","500");


        return "admin/album";
    }


    /**
     * 标签管理界面
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping(value = "/label")
    public String adminLabel(HttpServletRequest request,Model model,HttpServletResponse response){
        //获取标签名称
        String name = request.getParameter("name");
        //获取分页的页码
        String pageNumStr = request.getParameter("monitorPageNum");
        int pageNum = StringUtils.isEmpty(pageNumStr)?0:Integer.valueOf(pageNumStr);
        //获取分页的大小
        String pageSizeStr = request.getParameter("pageSize");
        int pageSize = StringUtils.isEmpty(pageSizeStr)?15:Integer.valueOf(pageSizeStr);
         /*获取所有的标签*/
        int totalNum = labelService.selectLabels().size();

        List<Label> labels = labelService.selectLabels(pageNum,pageSize,name);
        PageUtil monitor_paging_vo = new PageUtil(pageSize,totalNum,pageNum);
        monitor_paging_vo.setObject(labels);

        model.addAttribute("paging",monitor_paging_vo);
        model.addAttribute("page_type","600");


        return "admin/label";
    }

    /**
     * 进行删除操作
     * @param request
     * @param model
     * @param response
     * type 1-用户 2-评论 3-帖子 4-音乐 5-专辑 6-标签
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/del")
    public JsonResult delete(HttpServletRequest request, Model model, HttpServletResponse response,
                             @RequestParam(required = true ,value = "id") Integer id,
                             @RequestParam(required = true ,value = "type") Integer type){
        boolean result = true;
        switch (type){
            case 1:
                result = userService.modifyUserSatsu(Long.valueOf(id),0);
                break;
            case 2:
                result = commentService.deleteComment(Long.valueOf(id));
                break;
            case 3:
                result = postingService.deletePosting(id);
                break;
            case 4:
                break;
            case 5:
                result = albumService.deleteAlbum(id);
                break;
            case 6:
                result = labelService.deletLabelById(id);
                break;
        }

        if(!result){
            return new JsonResult(JsonResultCode.FAILURE,"删除失败","");
        }
        return new JsonResult(JsonResultCode.SUCCESS,"删除成功","");
    }

    @RequestMapping(value = "/test")
    public String test2(HttpServletRequest request,Model model,HttpServletResponse response,
                        @RequestParam(required = true ,value = "toId") Integer toId){

        //获取当前对话的用户
        User toUser = userService.getUserById(toId.toString());

        model.addAttribute("toUser",toUser);

        return "room";
    }

}
