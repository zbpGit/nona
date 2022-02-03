package com.nona.article.entity;

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
@ApiModel(value = "Article", description = "商品实体")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity(name = "article")
@TableName("article")
public class Article extends Model<Article> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "id", dataType = "String", required = true)
    @Id
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(name = "name", value = "商品名称", dataType = "String", required = true)
    @Column(name = "name", columnDefinition = "VARCHAR(64) null comment '商品名称'")
    @TableField("name")
    private String name;

    @ApiModelProperty(name = "amount", value = "商品数量", dataType = "Integer", required = true)
    @Column(name = "amount", columnDefinition = "int null comment '商品数量'")
    @TableField("amount")
    private Integer amount;
}
