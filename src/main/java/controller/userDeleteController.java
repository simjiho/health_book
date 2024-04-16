package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.UserService;

	public class userDeleteController implements Controller{
		@Override
		public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int book_id = Integer.parseInt(req.getParameter("book_id"));
			
			UserService service = new UserService();
			int n = service.userDelete(book_id);
			
			return "redirect::/userList";
		}
	

}
