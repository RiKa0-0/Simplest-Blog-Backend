package cn.zhiyucs.blog.db.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_blog_comment")
public class BlogComment {

    @TableId(type = AUTO)
    private Long id;

    private Long BlogId;

    private String nickname;

    private String email;

    private String content;

    private Date createTime;

    private boolean adminComment;

    private Long parentCommentId;

    @TableField(exist = false)
    private List<Comment> replyComments = new ArrayList<>();
}