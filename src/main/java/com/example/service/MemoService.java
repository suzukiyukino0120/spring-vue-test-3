package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Memo;
import com.example.repository.MemoRepository;

@Service
@Transactional
public class MemoService {

	@Autowired
	private MemoRepository memoRepository;
	
	public List<Memo> findAll(){
		return memoRepository.load();
	}
	
	public void insert(Memo memo) {
		memoRepository.insert(memo);
	}
	
	public void delete(Integer id) {
		memoRepository.delete(id);
	}
}
