package cn.zhiyucs.blog.db.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

@Data
@TableName("t_blog")
@ToString
public class Blog {

    @TableId(type = AUTO)
    private Long id;

    private String title;

    private String content;

    private String picture;

    private String flag;

    private Integer views;

    private boolean appreciation;

    private boolean shareStatement;

    private boolean commentabled;

    private boolean published;

    private boolean recommend;

    private Date createTime;

    private Date updateTime;

    private String description;

    // 级联标签(多对多关系)
    @TableField(exist = false)
    private List<Tag> tags;
}
