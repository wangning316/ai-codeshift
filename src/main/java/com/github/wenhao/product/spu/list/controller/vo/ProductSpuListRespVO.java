package com.github.wenhao.product.spu.list.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema(description = "商品SPU列表响应参数")
public class ProductSpuListRespVO {

    @Schema(description = "商品SPU编号", example = "111")
    private Long id;

    @Schema(description = "商品名称", example = "清凉小短袖")
    private String name;

    @Schema(description = "关键字", example = "清凉丝滑不出汗")
    private String keyword;

    @Schema(description = "商品简介", example = "清凉小短袖简介")
    private String introduction;

    @Schema(description = "商品详情", example = "清凉小短袖详情")
    private String description;

    @Schema(description = "商品分类编号", example = "1")
    private Long categoryId;

    @Schema(description = "商品品牌编号", example = "1")
    private Long brandId;

    @Schema(description = "商品封面图", example = "https://www.iocoder.cn/xx.png")
    private String picUrl;

    @Schema(description = "商品轮播图")
    private List<String> sliderPicUrls;

    @Schema(description = "排序字段", example = "1")
    private Integer sort;

    @Schema(description = "商品状态", example = "1")
    private Integer status;

    @Schema(description = "商品创建时间", example = "2023-05-24 00:00:00")
    private LocalDateTime createTime;

    @Schema(description = "规格类型", example = "true")
    private Boolean specType;

    @Schema(description = "商品价格（单位：分）", example = "1999")
    private Integer price;

    @Schema(description = "市场价（单位：分）", example = "199")
    private Integer marketPrice;

    @Schema(description = "成本价（单位：分）", example = "19")
    private Integer costPrice;

    @Schema(description = "商品库存", example = "10000")
    private Integer stock;

    @Schema(description = "SKU数组")
    private List<ProductSkuRespVO> skus;

    @Schema(description = "配送方式数组")
    private List<Integer> deliveryTypes;

    @Schema(description = "物流配置模板编号", example = "111")
    private Long deliveryTemplateId;

    @Schema(description = "赠送积分", example = "111")
    private Integer giveIntegral;

    @Schema(description = "分销类型", example = "true")
    private Boolean subCommissionType;

    @Schema(description = "商品销量", example = "2000")
    private Integer salesCount;

    @Schema(description = "虚拟销量", example = "66")
    private Integer virtualSalesCount;

    @Schema(description = "浏览量", example = "888")
    private Integer browseCount;

    @Data
    @Schema(description = "商品SKU响应参数")
    public static class ProductSkuRespVO {

        @Schema(description = "SKU主键", example = "1024")
        private Long id;

        @Schema(description = "商品SKU名字", example = "清凉小短袖")
        private String name;

        @Schema(description = "销售价格（单位：分）", example = "1999")
        private Integer price;

        @Schema(description = "市场价", example = "2999")
        private Integer marketPrice;

        @Schema(description = "成本价", example = "19")
        private Integer costPrice;

        @Schema(description = "条形码", example = "15156165456")
        private String barCode;

        @Schema(description = "图片地址", example = "https://www.iocoder.cn/xx.png")
        private String picUrl;

        @Schema(description = "库存", example = "200")
        private Integer stock;

        @Schema(description = "商品重量（单位：kg）", example = "1.2")
        private Double weight;

        @Schema(description = "商品体积（单位：m³）", example = "2.5")
        private Double volume;

        @Schema(description = "一级分销佣金（单位：分）", example = "199")
        private Integer firstBrokeragePrice;

        @Schema(description = "二级分销佣金（单位：分）", example = "19")
        private Integer secondBrokeragePrice;

        @Schema(description = "属性数组")
        private List<Property> properties;

        @Data
        @Schema(description = "商品属性")
        public static class Property {

            @Schema(description = "属性编号", example = "10")
            private Long propertyId;

            @Schema(description = "属性名字", example = "颜色")
            private String propertyName;

            @Schema(description = "属性值编号", example = "10")
            private Long valueId;

            @Schema(description = "属性值名字", example = "红色")
            private String valueName;
        }
    }
}