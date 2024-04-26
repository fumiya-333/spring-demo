package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.Task;

@Mapper
public interface TaskRepository {

    @Select("select * from tasks")
    List<Task> findAll();

    @Select("select * from tasks where id = #{taskId}")
    Task findById(int taskId);
    
    @Insert("insert into tasks (title, description) values (#{title}, #{description})")
    void insert(@Param("title") String title, @Param("description") String description);

    @Update("update tasks set title = #{title}, description = #{description} where id = #{id}")
    void update(@Param("id") int id, @Param("title") String title, @Param("description") String description);

    @Delete("delete from tasks where id = #{id}")
    void delete(@Param("id") int id);
}
