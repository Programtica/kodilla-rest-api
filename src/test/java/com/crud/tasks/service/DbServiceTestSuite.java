package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTestSuite {
    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository repository;

    @Test
    public void shouldGetAllTasks() {
        // Given
        Task task = new Task();
        Task task1 = new Task();
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        tasks.add(task1);
        when(repository.findAll()).thenReturn(tasks);
        // When
        int size = dbService.getAllTasks().size();
        // Then
        assertEquals(2, size);
    }

    @Test
    public void shouldSaveTask() {
        // Given
        Task task = new Task(1L, "Test task", "Test content");
        when(repository.save(task)).thenReturn(task);
        // When
        String content = dbService.saveTask(task).getContent();
        // Then
        assertEquals("Test content", content);
    }

    @Test
    public void shouldGetTask() {
        // Given
        Task task = new Task(1L, "Test task 1", "Testing1");
        Optional<Task> optionalTask = Optional.of(task);
        when(repository.findById(1L)).thenReturn(optionalTask);
        // When
        Optional<Task> fetchedTask = dbService.getTask(1L);
        // Then
        assertEquals(optionalTask, fetchedTask);
    }

    @Test
    public void shouldDeleteById() {
        // Given
        doNothing().when(repository).deleteById(1L);
        // When
        dbService.deleteTask(1L);
        // Then
        System.out.println(mockingDetails(repository).getInvocations());
        verify(repository).deleteById(1L);
    }
}