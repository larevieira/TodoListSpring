package com.vieira.todolist.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vieira.todolist.daos.TodoListDAO;
import com.vieira.todolist.model.TodoList;

@Service
public class TodoListService {
	
	@Autowired
	TodoListDAO listDAO;
	
	public TodoList save(TodoList list) {
		
		return listDAO.save(list);
	}

	public Collection<TodoList> findAll(){
		return listDAO.findAll();
	}
	
	public Object findById(Integer id) {
		return listDAO.findById(id);
	}
	
	public TodoList edit(TodoList todoList) {
		return listDAO.save(todoList);
	}
	public void delete(TodoList todoList) {
		listDAO.delete(todoList);
	}
	
	
}
