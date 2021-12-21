package cn.zhiyucs.blog.service.Impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.zhiyucs.blog.db.mapper.TagMapper;
import cn.zhiyucs.blog.db.pojo.Tag;
import cn.zhiyucs.blog.service.ITagService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public IPage<Tag> getTagsPage(int curPage, int perPageNum) {
        return tagMapper.selectPage(new Page<>(curPage, perPageNum), null);
    }

    @Override
    public JSONObject getTagsList() {
        List<Tag> tags = tagMapper.selectList(null);
        String letter = null;
        JSONObject json = new JSONObject();
        JSONArray array = null;
        for (Tag tag : tags) {
            String firstLetter = tag.getName().charAt(0) + "";
            firstLetter = firstLetter.toUpperCase();
            if (letter == null || !letter.equals(firstLetter)) {
                letter = firstLetter;
                array = new JSONArray();
                json.set(letter, array);
            }
            array.put(tag);
        }
        return json;
    }
}
