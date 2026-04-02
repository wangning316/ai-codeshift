package com.github.wenhao.product.spu.page.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 商品SPU分页响应参数
 */
@Data
@Schema(description = "商品SPU分页查询响应参数")
public class ProductSpuPageRespVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "商品SPU编号")
    private Long id;

    @Schema(description = "商品名称")
    private String name;

    @Schema(description = "关键字")
    private String keyword;

    @Schema(description = "商品简介")
    private String introduction;

    @Schema(description = "商品详情")
    private String description;

    @Schema(description = "商品分类编号")
    private Long categoryId;

    @Schema(description = "商品品牌编号")
    private Long brandId;

    @Schema(description = "商品封面图")
    private String picUrl;

    @Schema(description = "商品轮播图")
    private List<String> sliderPicUrls;

    @Schema(description = "排序字段")
    private Integer sort;

    @Schema(description = "商品状态")
    private Integer status;

    @Schema(description = "商品创建时间")
    private LocalDateTime createTime;

    @Schema(description = "规格类型：false-单规格，true-多规格")
    private Boolean specType;

    @Schema(description = "商品价格（单位：分）")
    private Integer price;

    @Schema(description = "市场价（单位：分）")
    private Integer marketPrice;

    @Schema(description = "成本价（单位：分）")
    private Integer costPrice;

    @Schema(description = "商品库存")
    private Integer stock;

    @Schema(description = "配送方式数组")
    private List<Integer> deliveryTypes;

    @Schema(description = "物流配置模板编号")
    private Long deliveryTemplateId;

    @Schema(description = "赠送积分")
    private Integer giveIntegral;

    @Schema(description = "分销类型")
    private Boolean subCommissionType;

    @Schema(description = "商品销量")
    private Integer salesCount;

    @Schema(description = "虚拟销量")
    private Integer virtualSalesCount;

    @Schema(description = "浏览量")
    private Integer browseCount;
}