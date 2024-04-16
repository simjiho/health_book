package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import biz.UserService;
import vo.BookVO;

public class UserUpdateController implements Controller{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getMethod().equals("POST")) {
			return  processUpdateService(req, resp);
		}else if (req.getMethod().equals("GET")) {
			System.out.println(req.getParameter("book_id"));
			return processUpdateView(req, resp);
		}
		return "redirect::/";
	}
	private String processUpdateService(HttpServletRequest req, HttpServletResponse resp) {
		
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
			n = service.userUpdate(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(n>0) {
			return "redirect::userList"; 
		} else {
			return "userUpdate";
		} 
	}
	private String processUpdateView(HttpServletRequest req, HttpServletResponse resp) {
		
		int book_id = Integer.parseInt(req.getParameter("book_id"));
		System.out.println(book_id);
		UserService service = new UserService();
		BookVO book = service.getUser(book_id);
		req.setAttribute("book", book);
		return "userUpdate";
	}
}
