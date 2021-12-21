package cn.zhiyucs.blog.db.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

@Data
@TableName("t_user")
@AllArgsConstructor
public class User {

    @TableId(type = AUTO)
    private Long id;

    private String nickname;

    private String username;

    private String password;

    private String email;

    private String avatar;

    private Date createTime;

    /**
     * 状态
     */
    private Boolean enabled;

    /**
     * 是否是超级管理员
     */
    private Boolean root;
}
