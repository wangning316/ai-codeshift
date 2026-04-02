package com.github.wenhao.product.spu.get.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema(description = "商品SPU查询响应参数")
public class ProductSpuGetDetailRespVO implements Serializable {

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

    @Schema(description = "规格类型")
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

    @Schema(description = "SKU数组")
    private List<ProductSkuRespVO> skus;

    @Data
    @Schema(description = "商品SKU响应参数")
    public static class ProductSkuRespVO implements Serializable {

        private static final long serialVersionUID = 1L;

        @Schema(description = "SKU主键")
        private Long id;

        @Schema(description = "商品SKU名字")
        private String name;

        @Schema(description = "销售价格（单位：分）")
        private Integer price;

        @Schema(description = "市场价")
        private Integer marketPrice;

        @Schema(description = "成本价")
        private Integer costPrice;

        @Schema(description = "条形码")
        private String barCode;

        @Schema(description = "图片地址")
        private String picUrl;

        @Schema(description = "库存")
        private Integer stock;

        @Schema(description = "商品重量（kg）")
        private Double weight;

        @Schema(description = "商品体积（m³）")
        private Double volume;

        @Schema(description = "一级分销佣金（单位：分）")
        private Integer firstBrokeragePrice;

        @Schema(description = "二级分销佣金（单位：分）")
        private Integer secondBrokeragePrice;

        @Schema(description = "属性数组")
        private List<Property> properties;

        @Data
        @Schema(description = "商品属性")
        public static class Property implements Serializable {

            private static final long serialVersionUID = 1L;

            @Schema(description = "属性编号")
            private Long propertyId;

            @Schema(description = "属性名字")
            private String propertyName;

            @Schema(description = "属性值编号")
            private Long valueId;

            @Schema(description = "属性值名字")
            private String valueName;
        }
    }
}