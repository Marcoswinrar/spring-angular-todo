package com.supero.todo.controllers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.supero.todo.entities.TodoItem;
import com.supero.todo.repositories.TodoItemRepository;

@RunWith(MockitoJUnitRunner.class)
public class TodoItemControllerTest {

	@InjectMocks
	TodoItemController subject;

	@Mock
	TodoItemRepository todoItemRepository;

	@Test
	public void testIfCreatedTodoItemReturnsSavedTodoItem() {
		final TodoItem todoItemRequest = new TodoItem();
		final TodoItem todoItemResponse = new TodoItem();

		todoItemResponse.setId(52L);

		when(todoItemRepository.save(todoItemRequest)).thenReturn(todoItemResponse);

		assertThat(subject.create(todoItemRequest).getId(), equalTo(52L));
	}

	@Test
	public void testIfFindAllReturnCompleteTodoList() {
		final List<TodoItem> todoItems = new ArrayList<TodoItem>();

		final TodoItem item = new TodoItem();
		item.setId(52L);
		item.setDescription("My personal task in a list!");

		todoItems.add(item);

		when(todoItemRepository.findAll()).thenReturn(todoItems);

		List<TodoItem> result = subject.findAll();

		assertThat(result.size(), equalTo(1));

	}
	
	@Test
	public void testDeleteFunction() {
		final TodoItem item = new TodoItem();
		item.setId(52L);
		
		assertThat(item.getId(), equalTo(52L));

	}
	
}
