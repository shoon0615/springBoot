package com.example.sample.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SampleVo extends PagingVo {
	// BOARD
	private int seq;
	private String subject;
	private String contents;
	private String writer;
	private String cdate;
	private String udate;
	private String ddate;
	private String useYn;
	private long viewCnt;
	
	// BOARD_USER
	private String id;
	private String pwd;
	private String name;
	private String email;
	
}
