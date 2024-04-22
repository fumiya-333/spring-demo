package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.Task;

@Mapper
public interface TaskRepository {

    @Select("select * from tasks")
    List<Task> findAll();

    @Insert("insert into tasks (title, description) values (#{title}, #{description})")
    void insert(@Param("title") String title, @Param("description") String description);

    @Select("select * from tasks where id = #{taskId}")
    Task findById(int taskId);
}
