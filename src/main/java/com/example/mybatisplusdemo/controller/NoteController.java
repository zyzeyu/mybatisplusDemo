package com.example.mybatisplusdemo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.common.HttpResponse;
import com.example.mybatisplusdemo.dto.Note;
import com.example.mybatisplusdemo.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzy
 * @since 2022-11-22
 */
@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private INoteService noteService;

    @RequestMapping("/getNotes")
    public HttpResponse<List<Note>> getNotes(){
        HttpResponse<List<Note>> response ;

        try{
            List<Note> notes = noteService.getNotes();
            //返回成功
            return HttpResponse.success(notes);
        }catch (Exception e){
            return HttpResponse.error(e.getMessage());
            //返回你想要返回的状态码+message或者+data，都是可选
//            类似
//            return HttpResponse.error(400,"未知错误");
        }
    }

    @RequestMapping("/getNotePage")
    public Object getNotePage(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "5") Integer pageSize){
        Page<Note> IPage = new Page<>();
        IPage.setCurrent(pageNum);
        IPage.setSize(pageSize);
        IPage<Note> noteIPage = noteService.pageNote(IPage);
        return noteIPage;
    }
}

