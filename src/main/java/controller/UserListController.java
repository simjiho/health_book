package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.UserService;
import vo.BookVO;

public class UserListController implements Controller{
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		UserService service = new UserService();
		ArrayList<BookVO> list = service.userList();
		
		req.setAttribute("list", list);
		
		return "userList"; 
	}
}
