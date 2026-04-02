package com.github.wenhao.product.comment.updatevisible.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Schema(description = "商品评价更新可见性请求参数")
public class ProductCommentUpdateVisibleReqVO {

    @NotNull(message = "评价编号不能为空")
    @Schema(description = "评价编号", example = "1")
    private Long id;

    @NotNull(message = "是否可见不能为空")
    @Schema(description = "是否可见（true:显示；false:隐藏）", example = "true")
    private Boolean visible;
}