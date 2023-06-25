<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/reset.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" />
</head>
<body>
   <h1 class="text-center title">목록보기</h1>
   <p class="text-center titlep">관리자 모드</p>
   <div class="container">
       <ul class="row">
       
       <c:forEach var="row" items="${list }">
          <li class="col-6">
              <a href="#" class="box">
                 <img src="http://localhost:3000/data/img/${row.fileName }" alt="${row.fileSize }" />
                 <article class="content">
                    <h3>${fn: substring(row.title, 0, 28)}</h3>
                    <span>${row.categorya}</span><span>${row.categoryb}</span>
                    <p>
                       ${fn: substring(row.content, 0, 100) } </p>
                    <div class="wdate">
                       <span>${fn: substring(row.wdate, 0, 10) }</span>
                       <span>${fn: substring(row.wdate, 11, 19) }</span>
                    </div>
                 </article>
              </a>             
           </li>
       </c:forEach>
       </ul>
   </div>
   <div class="container text-center">
      <ul class="pagination">
         <c:if test="${pagination.prev }">
         <li>
             <a href="?page=${pagination.startPage - 1 }" class="prne">이전</a>
         </li>
         </c:if>
         
         <c:forEach begin="${pagination.startPage }" end="${pagination.endPage}" var="idx">
             <li>
                <a href="?page=${idx }"  
                     <c:if test="${pagination.page == idx }"> 
                        class="active" 
                     </c:if>
                 >
                ${idx }
                </a>
             </li>
         </c:forEach>
         
         <c:if test="${pagination.next && pagination.endPage > 0}">
         <li>
             <a href="?page=${pagination.endPage + 1 }" class="prne">다음</a>
         </li>
         </c:if>
      </ul>
   
     <ul>
        <li>현재 페이지 : ${pagination.page }</li>
        <li>전체 글 수 : ${pagination.totalCnt }</li>
        <li>시작페이지 번호 : ${pagination.startPage }</li>
        <li>마지막 페이지 번호 : ${pagination.endPage }</li>
        <li>목록크기 : ${pagination.listSize }</li>
     </ul>
   </div>
</body>
</html>