package cn.zhiyucs.blog.controller;

import cn.zhiyucs.blog.common.R;
import cn.zhiyucs.blog.controller.form.SearchPagesForm;
import cn.zhiyucs.blog.db.pojo.Blog;
import cn.zhiyucs.blog.service.IBlogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/blog")
@Api("博客模块")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/details")
    @ApiOperation("获取某一个博客的全部内容")
    public R getBlogDetails(@RequestParam("id") Integer id) {
        Blog blog = blogService.getBlogInformation(id);
        return R.ok().put("data", blog);
    }


    @PostMapping("/infoPage")
    @ApiOperation("获取展示博客的分页")
    public R getBlogInfoByPage(@Valid @RequestBody SearchPagesForm form) {
        // 防止当前页博客的展示信息
        IPage<Blog> blogsPage = blogService.getBlogsPage(form.getPageIndex(), form.getPageSize());
        return R.ok().put("data", blogsPage);
    }

    @GetMapping("/getCount")
    @ApiOperation("获取当前博客的数量")
    public R getBlogCount() {
        int count = blogService.count();
        return R.ok().put("data", count);
    }

    @GetMapping("/getArchive")
    @ApiOperation("获取归档博客数据(分页处理)")
    public R getBlogsPageInfoOrderTime() {
        IPage<Blog> blogsPageArchives = blogService.getBlogsPageByTime(1, 10);
        return R.ok().put("data", blogsPageArchives);
    }

    @GetMapping("/getNew")
    @ApiOperation("获取前五个最新的文章")
    public R getNewBlogs() {
        ArrayList<Blog> newBlogs = blogService.getNewBlogs();
        return R.ok().put("data", newBlogs);
    }
}
