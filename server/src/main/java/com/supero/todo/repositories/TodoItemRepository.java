package com.supero.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supero.todo.entities.TodoItem;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
	
}
