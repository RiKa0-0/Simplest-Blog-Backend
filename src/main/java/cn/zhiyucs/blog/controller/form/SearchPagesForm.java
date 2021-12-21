package cn.zhiyucs.blog.controller.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@ApiModel
public class SearchPagesForm {
    // 当前页数，默认为1
    @NotNull
    @Min(1)
    private Integer pageIndex = 1;

    // 当前页的数量, 默认为10
    @NotNull
    @Min(1)
    @Max(20)
    private Integer pageSize = 10;
}
