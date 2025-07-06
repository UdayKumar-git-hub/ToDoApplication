package com.todoapp.springboot.myfirstwebapp.login;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {

	
	private TodoRepository todorep;
	
	public TodoControllerJPA(TodoRepository todorep) {
		super();
		this.todorep = todorep;
	}

	@RequestMapping("todos")
	public String listAllTodos(ModelMap model)
	{
		String username = getLoggedInUsername(model);
		List<Todo> todos = todorep.findByUsername(username);
		model.addAttribute("todos",todos);
		return "todos";
	}
	
	@RequestMapping(value = "add-Todo",method = RequestMethod.GET)
	public String newTodoPage(ModelMap modal)
	{
		String username = getLoggedInUsername(modal);
		Todo todo = new Todo(0,username,"",LocalDate.now().plusWeeks(10),false);
		modal.addAttribute("todoDesc",todo);
		return "newTodo";
	}

	
	
	@RequestMapping(value = "add-Todo", method = RequestMethod.POST)
	public String backToTodos(ModelMap model, @Valid Todo todoDesc, BindingResult result, LocalDate target) {
	    if (result.hasErrors()) {
	    	model.put("todoDesc",todoDesc);
	        return "newTodo";
	    }

	    String username = getLoggedInUsername(model);
	    todoDesc.setUsername(username);
	    todorep.save(todoDesc);
	  // todoservice.addTodo(username, todoDesc.getDescription(), todoDesc.getTargetDate(), todoDesc.isDone());
	    return "redirect:todos";
	}
	
	@RequestMapping(value = "delete-button")
	public String deleteTodo(@RequestParam int id)
	{
		todorep.deleteById(id);
		return "redirect:todos";
		
	}
	
	@RequestMapping(value = "update-button",method = RequestMethod.GET)
	public String updateTodoPage(@RequestParam int id,ModelMap model)
	{
		Todo  todo = todorep.findById(id).get();
		model.addAttribute("todoDesc",todo);
		return "newTodo";
	}
	
	@RequestMapping(value = "update-button", method = RequestMethod.POST)
	public String updateTodoList(ModelMap model, @Valid Todo todoDesc, BindingResult result,LocalDate target) {
	    if (result.hasErrors()) {
	    	model.put("todoDesc",todoDesc);
	        return "newTodo";
	    }
	    
	    String username = (String) model.get("name");
	    todoDesc.setUsername(username);
	    //todoDesc.setTargetDate(target);
	    //todoDesc.setTargetDate(null);
	    todorep.save(todoDesc);
	    return "redirect:todos";
	}
	
	private String getLoggedInUsername(ModelMap modal) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}	

	 }


