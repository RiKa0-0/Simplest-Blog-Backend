package cn.zhiyucs.blog.service.Impl;

import cn.zhiyucs.blog.db.mapper.CommentMapper;
import cn.zhiyucs.blog.db.pojo.Comment;
import cn.zhiyucs.blog.service.ICommentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentList() {

        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");

        HashMap<Long, Comment> map = new HashMap<>();

        List<Comment> Comments = commentMapper.selectList(wrapper);
        List<Comment> result = new ArrayList<>();

        // 放入父评论, map和list放入的对象一样，并且地址相同
        for (Comment comment : Comments) {
            if (comment.getParentCommentId() == null) {
                result.add(comment);
            }
            map.put(comment.getId(), comment);
        }

        // 对于不是第一层的父节点，找出父节点并把子节点加入
        for (Comment comment : Comments) {
            Long parentId = comment.getParentCommentId();
            if (parentId != null) {
                Comment parentComment = map.get(parentId);
                parentComment.getReplyComments().add(comment);
            }
        }

        // 清空map
        map = null;

        return result;
    }
}
