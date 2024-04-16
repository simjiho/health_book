package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.UserService;
import vo.BookVO;



public class UserBookController implements Controller{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getMethod());
		
		if(req.getMethod().equals("POST")) {
			return  processInsertService(req, resp);
		}else if (req.getMethod().equals("GET")) {
			
			System.out.println("안녕 : ");
			return processBookView(req, resp);
			
		}
		return "redirect::/";
	}
	
	private String processInsertService(HttpServletRequest req, HttpServletResponse resp) {
		
		int book_id = Integer.parseInt(req.getParameter("book_id"));
		String user_id = req.getParameter("user_id");
		String trainer_name = req.getParameter("trainer_name");
		int book_hour = Integer.parseInt(req.getParameter("book_hour"));
		int book_pay = Integer.parseInt(req.getParameter("book_pay"));
		System.out.println(book_id);
		System.out.println(user_id);
		System.out.println(trainer_name);
		System.out.println(book_hour);
		System.out.println(book_pay);
		
		
		BookVO book = new BookVO();
		book.setBook_id(book_id);
		book.setUser_id(user_id);
		book.setTrainer_name(trainer_name);
		book.setBook_hour(book_hour);
		book.setBook_pay(book_pay);
	

		UserService service = new UserService();
		int  n = 0;	
		try {
			n = service.userBook(book);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(n>0) {
			return "redirect::userList"; 
		}else {
			return "userBook";
		}
	}
	private String processBookView(HttpServletRequest req, HttpServletResponse resp) {
		UserService service = new UserService();
		int book_id = service.getMaxBook_id();
		req.setAttribute("book_id", book_id);
		
		return "userBook";
	}
}
