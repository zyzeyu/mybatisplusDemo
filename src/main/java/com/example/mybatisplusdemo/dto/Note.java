package com.example.mybatisplusdemo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.example.mybatisplusdemo.common.HttpResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzy
 * @since 2022-11-22
 */
@Data
@TableName("note")
@Accessors(chain = true)
public class Note{

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 介绍
     */
    private String introduce;

    /**
     * 作者
     */
    @TableField("authorId")
    private String authorId;

    /**
     * 文章内容
     */
    private String article;


}
