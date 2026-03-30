package com.github.wenhao.product.category.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("product_category")
public class ProductCategory {
    @TableId
    private Long id;

    private Long parentId;

    private String name;

    private String picUrl;

    private Integer sort;

    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT)
    private String creator;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updater;

    @TableLogic
    private Boolean deleted;
}