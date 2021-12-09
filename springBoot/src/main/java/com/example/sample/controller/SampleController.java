package com.example.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.sample.dto.SampleDto;
import com.example.sample.service.SampleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller						// @Controller("sampleController")
@RequestMapping("/sample")
public class SampleController {
	
	// private final SampleService sampleService;
	@Autowired
	private SampleService sampleService;
	
	// 게시글 작성 GET
	@GetMapping(value = "/test.do")
	public ModelAndView test(@RequestParam(value = "mustNot", required = false) String mustNot,
								// @RequestParam(value = "must") String must,
								HttpServletRequest request, HttpSession session, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("sample/write");
		
		SampleDto board = new SampleDto();
		board.setNoticeYn("Y");
		board.setSecretYn("Y");
		board.setTitle("테스트");
		board.setWriter("운영자");
		board.setContent("내용ABC12345");
		
		mav.addObject("mapper", sampleService.selectMapper());
		mav.addObject("board", board);
		// mav.setViewName("redirect:/sample/test.do");

		return mav;
	}

}
