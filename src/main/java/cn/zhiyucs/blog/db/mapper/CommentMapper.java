package cn.zhiyucs.blog.db.mapper;

import cn.zhiyucs.blog.db.pojo.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper extends BaseMapper<Comment> {
}
