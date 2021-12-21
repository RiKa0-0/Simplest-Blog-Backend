package cn.zhiyucs.blog.controller;


import cn.zhiyucs.blog.common.R;
import cn.zhiyucs.blog.db.pojo.Comment;
import cn.zhiyucs.blog.service.ICommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
@Api("留言板模块")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @GetMapping("/allMsg")
    @ApiOperation("查找所有的留言")
    public R getMessage() {
        List<Comment> commentList = commentService.getCommentList();
        return R.ok().put("data", commentList);
    }

    @GetMapping("/count")
    @ApiOperation("获取评论的数量")
    public R getCount() {
        int count = commentService.count();
        return R.ok().put("data", count);
    }
}
