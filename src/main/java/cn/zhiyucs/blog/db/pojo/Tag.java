package cn.zhiyucs.blog.db.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_tag")
public class Tag {

    @TableId(type = AUTO)
    private Long id;

    private String name;
}
