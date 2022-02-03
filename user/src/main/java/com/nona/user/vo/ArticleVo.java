package com.nona.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.article.entity</b>
 * <br><b>ClassName:Article</b>
 * <br><b>Date:2022/2/3 20:01</b>
 */
@ApiModel(value = "ArticleVo", description = "商品实体")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ArticleVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "id", dataType = "String", required = true)
    private String id;

    @ApiModelProperty(name = "name", value = "商品名称", dataType = "String", required = true)
    private String name;

    @ApiModelProperty(name = "amount", value = "商品数量", dataType = "Integer", required = true)
    private Integer amount;
}
