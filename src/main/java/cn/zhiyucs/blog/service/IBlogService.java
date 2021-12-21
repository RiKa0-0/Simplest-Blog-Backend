package cn.zhiyucs.blog.service;

import cn.zhiyucs.blog.db.pojo.Blog;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;

public interface IBlogService extends IService<Blog> {

    HashMap<String, Object> getBlogInformation(Integer id);

    IPage<Blog> getBlogsPage(int curPage, int perPageNum);

    IPage<Blog> getBlogsPageByTime(int curPage, int perPageNum);
}
