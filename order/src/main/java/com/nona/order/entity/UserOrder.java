package com.nona.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.article.entity</b>
 * <br><b>ClassName:Article</b>
 * <br><b>Date:2022/2/3 20:01</b>
 */
@ApiModel(value = "UserOrder", description = "订单实体")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity(name = "user_order")
@TableName("user_order")
public class UserOrder extends Model<UserOrder> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "id", dataType = "String", required = true)
    @Id
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(name = "userId", value = "用户", dataType = "String", required = true)
    @Column(name = "user_id", columnDefinition = "varchar(64) null comment '用户'")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(name = "articleId", value = "商品名称", dataType = "String", required = true)
    @Column(name = "article_id", columnDefinition = "varchar(64) null comment '商品名称'")
    @TableField("article_id")
    private String articleId;
}
