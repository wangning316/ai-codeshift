package com.github.wenhao.product.history.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 商品浏览记录
 */
@Data
@TableName("product_browse_history")
public class ProductBrowseHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户编号，关联 MemberUserDO 的 id 编号
     */
    private Long userId;

    /**
     * 商品SPU编号，关联 ProductSpuDO 的 id 编号
     */
    private Long spuId;

    /**
     * 用户是否删除
     */
    private Boolean userDeleted;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT, jdbcType = org.apache.ibatis.type.JdbcType.VARCHAR)
    private String creator;

    @TableField(fill = FieldFill.INSERT_UPDATE, jdbcType = org.apache.ibatis.type.JdbcType.VARCHAR)
    private String updater;

    @TableLogic
    private Boolean deleted;
}