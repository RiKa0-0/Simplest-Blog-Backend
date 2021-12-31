package cn.zhiyucs.blog.controller;


import cn.zhiyucs.blog.common.R;
import cn.zhiyucs.blog.controller.form.CommentMethodForm;
import cn.zhiyucs.blog.db.pojo.Comment;
import cn.zhiyucs.blog.service.ICommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/message")
@Api("留言板模块")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @PostMapping("/allMsg")
    @ApiOperation("查找分页后的留言")
    public R getMessage(@Valid @RequestBody CommentMethodForm form) {
        List<Comment> commentList = commentService.getCommentList(form.getGetCommentMethod());
        return R.ok().put("data", commentList);
    }

    @GetMapping("/count")
    @ApiOperation("获取评论的数量")
    public R getCount() {
        int count = commentService.count();
        return R.ok().put("data", count);
    }
}
