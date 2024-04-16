package biz;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.UserDao;
import vo.BookVO;

public class UserService {
	UserDao dao = new UserDao();
	public ArrayList<BookVO> userList(){
			ArrayList<BookVO> list = dao.userList();
			return list;
	}
	public int getMaxBook_id() {
		int book_id = dao.getMaxBook_id();
		return book_id;
	}
	public int userBook(BookVO book) throws SQLException{
		int n = dao.userBook(book);
		return n;
	}
	public BookVO getUser(int book_id) {
		BookVO book = dao.getUser(book_id);
		return book;
	}
	public int userUpdate(BookVO book) throws SQLException{
		int n = dao.userUpdate(book);
		return n;
	}
	public int userDelete(int book_id) {
		int n = dao.userDelete(book_id);
		return n;
	}
}
