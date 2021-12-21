package cn.zhiyucs.blog.service.Impl;

import cn.zhiyucs.blog.db.mapper.BlogMapper;
import cn.zhiyucs.blog.db.pojo.Blog;
import cn.zhiyucs.blog.db.pojo.Tag;
import cn.zhiyucs.blog.service.IBlogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public HashMap<String, Object> getBlogInformation(Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        List<Tag> blogTags = blogMapper.findBlogTags(id);
        Blog displayInfo = blogMapper.findDisplayInfoById(id);
        displayInfo.setTags(blogTags);

        map.put("info", displayInfo);
        return map;
    }

    /**
     * 根据每页分页的数量和传给的当前页数给出 --> 分页博客
     *
     * @param curPage    当前页数
     * @param perPageNum 每页的数量
     * @return 分页后的博客
     */
    @Override
    public IPage<Blog> getBlogsPage(int curPage, int perPageNum) {
        // 创建查询
        QueryWrapper<Blog> wrapper = new QueryWrapper<>();
        // 选择要展示的列
        wrapper.select("id", "picture", "description", "published", "recommend", "title", "update_time", "views");

        Page<Blog> blogPage = blogMapper.selectPage(new Page<>(curPage, perPageNum), wrapper);
        // 通过ID查询TAG，进而放置到展示博客里面
        for (Blog blog : blogPage.getRecords()) {
            Long id = blog.getId();
            List<Tag> blogTags = blogMapper.findBlogTags(id.intValue());
            if (blogTags.size() > 0) {
                blog.setTags(blogTags);
            }
        }
        return blogPage;
    }

    @Override
    public IPage<Blog> getBlogsPageByTime(int curPage, int perPageNum) {
        // 创建查询
        QueryWrapper<Blog> wrapper = new QueryWrapper<>();
        // 选择要展示的列
        wrapper.select("id", "create_time", "description", "flag", "published", "recommend", "title");
        // 根据日期进行排序
        wrapper.orderByDesc("create_time");

        Page<Blog> archiveBlogPage = blogMapper.selectPage(new Page<>(curPage, perPageNum), wrapper);
        // 通过ID查询TAG，进而放置到展示博客里面
        for (Blog blog : archiveBlogPage.getRecords()) {
            Long id = blog.getId();
            List<Tag> blogTags = blogMapper.findBlogTags(id.intValue());
            if (blogTags.size() > 0) {
                blog.setTags(blogTags);
            }
        }
        return archiveBlogPage;
    }
}
