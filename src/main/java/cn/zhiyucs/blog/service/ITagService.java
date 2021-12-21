package cn.zhiyucs.blog.service;

import cn.hutool.json.JSONObject;
import cn.zhiyucs.blog.db.pojo.Tag;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ITagService extends IService<Tag> {

    IPage<Tag> getTagsPage(int curPage, int perPageNum);

    JSONObject getTagsList();
}
