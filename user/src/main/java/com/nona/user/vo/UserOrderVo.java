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
@ApiModel(value = "UserOrderVo", description = "订单实体")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserOrderVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "id", dataType = "String", required = true)
    private String id;

    @ApiModelProperty(name = "userId", value = "用户", dataType = "String", required = true)
    private String userId;

    @ApiModelProperty(name = "articleId", value = "商品名称", dataType = "String", required = true)
    private String articleId;
}
