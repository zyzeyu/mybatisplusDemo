package com.example.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.common.HttpResponse;
import com.example.mybatisplusdemo.dto.Note;
import com.example.mybatisplusdemo.mapper.NoteMapper;
import com.example.mybatisplusdemo.service.INoteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzy
 * @since 2022-11-22
 */
@Service
@Slf4j
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements INoteService {

    @Autowired
    private NoteMapper noteMapper;
    @Override
    public List<Note> getNotes() {
        return noteMapper.selectList(new QueryWrapper<Note>());
    }

    @Override
    public IPage<Note> pageNote(Page<Note> page) {
        IPage<Note> noteIpage =  noteMapper.selectPage(page,new QueryWrapper<>());
        return noteIpage;
    }
}
