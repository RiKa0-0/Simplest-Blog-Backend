package cn.zhiyucs.blog.service.Impl;

import cn.zhiyucs.blog.db.mapper.BlogCommentMapper;
import cn.zhiyucs.blog.db.pojo.BlogComment;
import cn.zhiyucs.blog.service.IBlogCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BlogCommentServiceImpl  extends ServiceImpl<BlogCommentMapper, BlogComment> implements IBlogCommentService {
}
