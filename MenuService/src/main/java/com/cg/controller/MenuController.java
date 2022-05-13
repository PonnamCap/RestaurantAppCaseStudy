package com.cg.controller;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Menu;
import com.cg.model.repository.MenuRepository;


@RestController
@RequestMapping("/api/v1")
public class MenuController {
	
	@Autowired
	private MenuRepository menuRepo;
		
	@PostMapping("/addMenu")
	public String saveMenu(@RequestBody Menu menu) {
		menuRepo.save(menu);
	return "Added menu with id :  " + menu.getId();
} 
	
	@GetMapping("/{id}")
	public Optional<Menu> getMenu(@PathVariable String id){
		return menuRepo.findById(id);
	}
	
    @GetMapping("/findAllMenus")
    public List<Menu> getTrains(){
	return menuRepo.findAll();
    }
	@PutMapping("/update/{id}")
	public Menu updateMenu(@PathVariable("id") String id,@RequestBody Menu menu ) {
		menu.setId(id);
		menuRepo.save(menu);
		return menu;
	}
		
	 @DeleteMapping("/del/{id}")
	 public String deleteMenu (@PathVariable String id) {
		 menuRepo.deleteById(id);
		return "Order deleted with id : "+id;
		}
	}