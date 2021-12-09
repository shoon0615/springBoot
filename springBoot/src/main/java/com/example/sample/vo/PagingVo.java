package com.example.sample.vo;

import javax.validation.constraints.Min;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class PagingVo {

	@Min(1)
	private int currentPage; // 현재 Page 번호
	@Min(1)
	private int pageSize; // 페이지 사이즈 (페이지당 Row 개수)
	private int offset; // 오프셋
	private int totalRowCnt; // 총 Row 개수
	private int totalPageNo; // 총 Page 번호
	
	{
		currentPage = 1;
		pageSize = 4;
	}
	
	@Builder
	public PagingVo(int currentPage, int pageSize, int totalRowCnt) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.setTotalRowCnt(totalRowCnt);
		calcOffset();
		calcTotalPageNo();
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		calcOffset();
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		calcOffset();
	}
	
	public void setTotalRowCnt(int totalRowCnt) {
		this.totalRowCnt = totalRowCnt;
		calcTotalPageNo();
	}
	
	private void calcOffset() {
		this.offset = (getCurrentPage() - 1) * getPageSize();
	}
	
	private void calcTotalPageNo() {
		this.totalPageNo = (getTotalRowCnt() + getPageSize() - 1) / getPageSize();
	}
	
}
