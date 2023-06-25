package net.musecom.util;

public class Pagination {
   private int listSize; //한 번에 보일 목록의 갯수
   private int rangeSize;  //한 번에 보여질 페이지 갯수
   private int page;
   private int totalCnt; //전체 컬럼 수
   private int pageCnt; //페이지 수 (전체컬럼 / listSize)
   private int startPage; 
   private int endPage;
   private int startList;
   
   private boolean prev;
   private boolean next;
   
	public int getListSize() {
		return listSize;
	}
	
	public int getRangeSize() {
		return rangeSize;
	}
	
	public int getPage() {
		return page;
	}
	
	public int getTotalCnt() {
		return totalCnt;
	}
	
	public int getPageCnt() {
		return pageCnt;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public int getStartList() {
		return startList;
	}
	
	public boolean isPrev() {
		return prev;
	}
	
	public boolean isNext() {
		return next;
	}
	
	   	   
	public void setPageInfo(int page, int listSize, int rangeSize, int totalCnt ) {
		this.page = page;
		this.listSize = listSize;
		this.rangeSize = rangeSize;
		this.totalCnt = totalCnt;
		
		//전체 페이지
		int pageCnt = (int) Math.ceil(totalCnt/(double) listSize);
		
		//마지막 페이지 
		int endPage = (int) Math.ceil((page / (double) rangeSize )) * rangeSize;
		int realend = (int) Math.ceil((totalCnt * 1.0) / listSize);
		//시작 페이지
		int startPage = (endPage - rangeSize) + 1;

		if(realend < endPage) endPage = realend;
						
		//시작 번호
		int startList = (page-1)*listSize;
		
		//이전버튼
		boolean prev = startPage == 1 ? false : true;
		
		//다음버튼
		boolean next = endPage > pageCnt ? false : true;
		if(endPage > pageCnt) {
			endPage = pageCnt;
			next = false;
		}

		this.pageCnt = pageCnt;
		this.endPage = endPage;
		this.startPage = startPage;
		this.startList = startList;
		this.prev = prev;
		this.next = next;
		

	}
	
}
