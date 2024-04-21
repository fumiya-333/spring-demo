package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.Task;

@Mapper
public interface TaskRepository {
    @Select("select * from tasks")
    List<Task> findAll();
}
