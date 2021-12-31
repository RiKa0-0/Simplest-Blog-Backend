package cn.zhiyucs.blog.controller.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@ApiModel
@Data
public class CommentMethodForm {

    @NotBlank
    @Pattern(regexp = "^create_time$|^like_comment$")
    private String getCommentMethod;
}
