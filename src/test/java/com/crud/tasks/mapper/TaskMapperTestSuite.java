package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {
    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void testMapToTask() {
        //Given
        Long taskDtoId = 1L;
        String taskDtoTitle = "TaskDtoTitle";
        String taskDtoContent = "TaskDtoContent";
        TaskDto taskDto = new TaskDto(taskDtoId, taskDtoTitle, taskDtoContent);
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(taskDtoId, task.getId());
        assertEquals(taskDtoTitle, task.getTitle());
        assertEquals(taskDtoContent, task.getContent());
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Long taskId = 1L;
        String taskTitle = "TaskTitle";
        String taskContent = "TaskContent";
        Task task = new Task(taskId, taskTitle, taskContent);
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(taskId, task.getId());
        assertEquals(taskTitle, task.getTitle());
        assertEquals(taskContent, task.getContent());
    }

    @Test
    public void testMToTaskDtoList() {
        //Given
        Long taskId = 1L;
        String taskTitle = "TaskTitle";
        String taskContent = "TaskContent";
        Task task = new Task(taskId, taskTitle, taskContent);
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        //When
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(taskList);
        //Then
        assertEquals(1, taskDtos.size());
        assertEquals(taskId, taskDtos.get(0).getId());
        assertEquals(taskTitle, taskDtos.get(0).getTitle());
        assertEquals(taskContent, taskDtos.get(0).getContent());
    }

}
