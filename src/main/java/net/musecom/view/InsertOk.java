package net.musecom.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.musecom.database.BlogDto;
import net.musecom.database.BlogImpl;
import net.musecom.database.FileDto;


@WebServlet("/insertok")
public class InsertOk extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		BlogImpl blogfile = new BlogImpl();
		BlogDto bDto = new BlogDto();
		FileDto fDto = new FileDto();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");		
		
		int imname = 0;
		if(session.getAttribute("imname") != null) imname = Integer.parseInt((String) session.getAttribute("imname"));
  	    bDto.setTitle(request.getParameter("title"));
  	    bDto.setContent(request.getParameter("content"));
  	    bDto.setWriter(request.getParameter("writer"));
  	    bDto.setCategorya(request.getParameter("categorya"));
  	    bDto.setCategoryb(request.getParameter("categoryb"));
  	    bDto.setImname(imname);
  	    int rs = blogfile.bInsert(bDto);  //본문에 등록하고 auto_increment된 키값을 rs로 반환한다.
  	    
  	    fDto.setImname(imname);  //세션값으로 본문의 imname과 파일 테이블의 imname은 같은 값이다. 
  	    fDto.setBlog_num(rs);  //blog_num 에 본문 번호를 넣는다. (외래키)
  	    int rss = blogfile.fileUpdate(fDto);  //imname이 같은 테이블들을 업데이트 한다.
  	    session.invalidate();   //세션 아웃
  	    
  	    //이미지 if else 이용해서 바뀌도록 처리 
  	    //관리자 모드 목록 , 세부보기 
  	    //관리자 모드에 로그인 ...
  	    
  	    out.print("등록했수");
		doGet(request, response);
	}

}
