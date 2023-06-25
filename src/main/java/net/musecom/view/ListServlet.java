package net.musecom.view;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.musecom.database.BlogDto;
import net.musecom.database.BlogImpl;
import net.musecom.database.FileDto;
import net.musecom.util.Pagination;

@WebServlet("/list")
public class ListServlet extends HttpServlet {


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

       //file db ���� blog_num �� 0 �� �÷��� �˻�
	   //�ش� ������ ����
	   //db�� �����.
	   //blog ����� �˻� 
	   //��Ͽ� �´� file�� �˻� 	
	   
	   String links = "/Users/yun-eunbee/Desktop/eunbee/react/blog-me/public/data/img/";  //������ �ִ� ���	
	   String fdata;
	   String flink;
	   String page = req.getParameter("page");
	   int pg = 1;
	   if(page != null) {
		  pg = Integer.parseInt(page);   
	   }	   
	   
	   res.setContentType("text/plan;charset=UTF-8");
	   PrintWriter out = res.getWriter();
	
	   BlogImpl blog = new BlogImpl();
  	   Pagination pagination = new Pagination();

	   List<FileDto> flists = blog.fileList(0);
	   if(flists.size() > 0) {
		  for(FileDto flist : flists) {
			  
			 fdata = flist.getNewname();
			 flink = links + fdata;
			// System.out.println(flink);
			// System.out.println(flist.getNum());
			 
			 File file = new File(flink);
			 if(file.exists()) {
				 file.delete();
				 System.out.println(flink + "- 삭제성공 ");
			 }
			 blog.fileDelete(flist.getNum());
			 System.out.println("db 삭제성공 ");
		  }
	   }  //���������� �����ϴ� �κ�
		
	   List<BlogDto> lists = blog.bList(pg);

	   String content = null;

	   for(BlogDto list : lists) {
		   try {
			  content = removeHtmlTag(list.getContent());
			  list.setContent(content);
			  
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   
		   List<FileDto> fdto = blog.fileList(list.getNum());
		   if(fdto.size() > 0) {
			   String filename = fdto.get(0).getNewname();
			   String fileExt = fdto.get(0).getExt();
			   int fileSize = (int) fdto.get(0).getFilesize();
			   
			   list.setFileName(filename);
			   list.setFileSize(fileSize);
			   list.setFileExt(fileExt);
		   }
	   }
	   
	   int totalCnt = blog.bListCount();
	   pagination.setPageInfo(pg, 12, 15, totalCnt);
	   
	   RequestDispatcher requestDispatcher = req.getRequestDispatcher("/list.jsp");   
	   req.setAttribute("list", lists);
	   req.setAttribute("pagination", pagination);
	   requestDispatcher.forward(req, res);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public String removeHtmlTag(String html) throws Exception {
		return html.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
	}
	
}
