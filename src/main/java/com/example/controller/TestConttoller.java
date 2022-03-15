package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Memo;
import com.example.service.MemoService;

@RestController
@RequestMapping("/test")
public class TestConttoller {
	
	@Autowired
	private MemoService memoService;

	@GetMapping("/memos")
	public List<Memo> getMemo(){
		return memoService.findAll();
	}
	
	@PostMapping("/memo")
	public void post(@RequestBody Memo memo) {
		memoService.insert(memo);
	}
	
	@DeleteMapping("/memo/{id}")
	public void delete(@PathVariable("id") int id) {
		memoService.delete(id);
	}
}
