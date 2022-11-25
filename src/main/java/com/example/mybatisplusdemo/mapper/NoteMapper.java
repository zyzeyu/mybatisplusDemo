package com.example.mybatisplusdemo.mapper;

import com.example.mybatisplusdemo.dto.Note;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzy
 * @since 2022-11-22
 */
@Mapper
public interface NoteMapper extends BaseMapper<Note> {

    @Select("select * from note")
    public List<Note> selectPage();

}
