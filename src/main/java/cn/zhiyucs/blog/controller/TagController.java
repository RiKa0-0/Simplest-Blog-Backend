package cn.zhiyucs.blog.controller;

import cn.hutool.json.JSONObject;
import cn.zhiyucs.blog.common.R;
import cn.zhiyucs.blog.db.pojo.Tag;
import cn.zhiyucs.blog.service.ITagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/tag")
@Api("标签模块")
public class TagController {

    @Autowired
    private ITagService tagService;

    @GetMapping("/getAll")
    @ApiOperation("获取所有标签")
    public R getTags() {
        HashMap<String, Object> map = new HashMap<>();
        List<Tag> list = tagService.list();
        map.put("tags", list);
        return R.ok(map);
    }

    @GetMapping("/getCount")
    @ApiOperation("获取标签的数量")
    public R getTagCount() {
        int count = tagService.count();
        return R.ok().put("data", count);
    }

    @GetMapping("/getList")
    @ApiOperation("通过划分A-Z获取标签")
    public R getTagList() {
        JSONObject json = tagService.getTagsList();
        return R.ok().put("data", json);
    }
}
