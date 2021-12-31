package cn.zhiyucs.blog;

import cn.hutool.json.JSONObject;
import cn.zhiyucs.blog.db.mapper.BlogMapper;
import cn.zhiyucs.blog.db.mapper.CommentMapper;
import cn.zhiyucs.blog.db.mapper.TagMapper;
import cn.zhiyucs.blog.db.pojo.Blog;
import cn.zhiyucs.blog.db.pojo.Comment;
import cn.zhiyucs.blog.db.pojo.Tag;
import cn.zhiyucs.blog.service.IBlogService;
import cn.zhiyucs.blog.service.ICommentService;
import cn.zhiyucs.blog.service.ITagService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class BlogApiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ITagService tagService;
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICommentService commentService;

    @Test
    public void testSelect() {
        System.out.println("----- selectAll method test ------");
        List<Tag> tagList = tagMapper.selectList(null);
        tagList.forEach(System.out::println);
    }


    @Test
    void testPage() {
        IPage<Tag> tagsPage = tagService.getTagsPage(2, 2);
        System.out.println("数据为："+tagsPage.getRecords());
        System.out.println("总数为："+tagsPage.getTotal()+",总页数为："+tagsPage.getPages());
        System.out.println("当前页为："+tagsPage.getCurrent()+",每页限制："+tagsPage.getSize());
    }

    @Test
    void testSql() {
        List<Tag> blogTags = blogMapper.findBlogTags(1);
        blogTags.forEach(System.out::println);
    }

    @Test
    void testOrder() {
        IPage<Blog> blogsPageByTime = blogService.getBlogsPageByTime(1, 3);
        blogsPageByTime.getRecords().forEach(System.out::println);
    }

    @Test
    void testFirstLetter() {
        JSONObject tagsList = tagService.getTagsList();
        System.out.println(tagsList);
    }

    @Test
    void generateTestDataFromComment() {
        final int testCount = 10;
        Comment comment = new Comment();
        for (long i = 0; i < testCount; i++) {
            comment.setAdminComment(false);
            comment.setContent("测试数据：" + (i));
            comment.setCreateTime(new Date());
            comment.setEmail("test@test.com");
            comment.setNickname("测试人员 " + i);
            commentMapper.insert(comment);
        }
    }

    @Test
    void testCommentList() {
        List<Comment> commentList = commentService.getCommentList("like_comment");
        System.out.println(commentList.size());
    }
}
