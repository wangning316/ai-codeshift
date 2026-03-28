package com.company.project.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.annotation.FieldFill;
import lombok.Data;
import java.time.LocalDateTime;
import org.apache.ibatis.type.JdbcType;

/**
 * 商品分类(entity)
 */
@Data
@TableName("product_category")
public class ProductCategoryPO {

    /**
     * 分类编号
     */
    @TableId
    private Long id;

    /**
     * 父分类编号（根分类为0）
     */
    private Long parentId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 移动端分类图（建议180*180分辨率）
     */
    private String picUrl;

    /**
     * 分类排序
     */
    private Integer sort;

    /**
     * 开启状态（枚举CommonStatusEnum）
     */
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 最后更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 创建者（SysUser的id编号）
     */
    @TableField(fill = FieldFill.INSERT, jdbcType = JdbcType.VARCHAR)
    private String creator;

    /**
     * 更新者（SysUser的id编号）
     */
    @TableField(fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    private String updater;

    /**
     * 是否删除（逻辑删除字段）
     */
    @TableLogic
    private Boolean deleted;
}