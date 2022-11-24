package com.example.mybatisplusdemo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.common.HttpResponse;
import com.example.mybatisplusdemo.dto.Note;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzy
 * @since 2022-11-22
 */
@Service("noteService")
public interface INoteService extends IService<Note> {

    public List<Note> getNotes();

    IPage<Note> pageNote(Page<Note> page);

}
