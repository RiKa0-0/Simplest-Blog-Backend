package cn.zhiyucs.blog.service;

import cn.zhiyucs.blog.db.pojo.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ICommentService extends IService<Comment> {

    List<Comment> getCommentList();
}
