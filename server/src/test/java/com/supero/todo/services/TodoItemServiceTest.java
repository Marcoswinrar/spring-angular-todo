package com.supero.todo.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
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
public class TodoItemServiceTest {

	@InjectMocks
	TodoItemServiceImpl subject;

	@Mock
	TodoItemRepository todoItemRepository;

	@Test
	public void saveShouldReturnTodo() {
		final TodoItem item = new TodoItem();
		item.setDescription("My personal task!");

		final TodoItem itemResponse = new TodoItem();
		itemResponse.setId(52L);
		itemResponse.setDescription("My personal task!");

		when(todoItemRepository.save(item)).thenReturn(itemResponse);

		final TodoItem response = subject.save(item);

		assertThat(response.getId(), equalTo(52L));
		assertThat(response.getDescription(), equalTo("My personal task!"));
	}

	@Test
	public void findAllShouldReturnList() {
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
	public void deleteShouldCallDeleteInRepository() {
		final Long idToDelete = 52L;

		doNothing().when(todoItemRepository).deleteById(idToDelete);

		subject.deleteById(idToDelete);

		verify(todoItemRepository).deleteById(idToDelete);
	}

}
