package com.example.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.mapper.SampleMapper;
import com.example.sample.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {
	
	@Autowired
	private SampleMapper sampleMapper;

	@Override
	public String selectMapper() {
		String result = sampleMapper.selectSample();
		return result;
	}

}
