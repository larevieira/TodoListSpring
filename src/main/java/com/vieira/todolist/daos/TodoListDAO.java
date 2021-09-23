package com.vieira.todolist.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.vieira.todolist.model.TodoList;

@Repository
public class TodoListDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void save(TodoList todoList) {
		manager.persist(todoList);
	}

}
