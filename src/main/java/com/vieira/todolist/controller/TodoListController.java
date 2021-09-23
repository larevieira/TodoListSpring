package com.vieira.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vieira.todolist.daos.TodoListDAO;
import com.vieira.todolist.model.TodoList;

@Controller
public class TodoListController {
	
	@Autowired
	private TodoListDAO todoListDAO = new TodoListDAO();

	@RequestMapping("/todoList")
	public String save(TodoList todo) {
		System.out.println("cadastrou tarefa");
		todoListDAO.save(todo);
		return "products/ok";
	}
	
	@RequestMapping("/todoList/form")
	public String form(){
		return "todoList/form";
	}
}
