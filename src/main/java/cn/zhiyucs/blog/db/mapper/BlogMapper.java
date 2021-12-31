package cn.zhiyucs.blog.db.mapper;


import cn.zhiyucs.blog.db.pojo.Blog;
import cn.zhiyucs.blog.db.pojo.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper extends BaseMapper<Blog> {

    List<Tag> findBlogTags(@Param("blogId") Integer blogId);
}
