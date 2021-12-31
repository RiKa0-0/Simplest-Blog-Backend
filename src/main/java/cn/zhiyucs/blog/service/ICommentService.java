package cn.zhiyucs.blog.service;

import cn.zhiyucs.blog.db.pojo.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ICommentService extends IService<Comment> {

    /**
     * 获得评论列表
     * @param getMethods 获取方式：create_time || like_comment
     * @return
     */
    List<Comment> getCommentList(String getMethods);
}
