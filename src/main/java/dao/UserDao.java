package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtils;
import vo.BookVO;

public class UserDao {
	public ArrayList<BookVO> userList() {
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select * from book_tbl");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BookVO vo = new BookVO();
				vo.setBook_id(rs.getInt("book_id"));
				vo.setUser_id(rs.getString("user_id"));
				vo.setTrainer_name(rs.getString("trainer_name"));
				vo.setBook_hour(rs.getInt("book_hour"));
				vo.setBook_pay(rs.getInt("book_pay"));
				
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps, rs);
		}
		
		return list;
	}
	public int getMaxBook_id() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int book_id = 0;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select max(book_id)+1 book_id from book_tbl");
			rs = ps.executeQuery();
			
			while(rs.next()){
				book_id = rs.getInt("book_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, ps, rs);
		}
		return book_id;
	}
	public int userBook(BookVO book) throws SQLException{
		
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		System.out.println(book.getBook_id());
		System.out.println(book.getUser_id());
		System.out.println(book.getTrainer_name());
		System.out.println(book.getBook_hour());
		System.out.println(book.getBook_pay());
		
		try {
			
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("insert into book_tbl values(?,?,?,?,?)");
			ps.setInt(1, book.getBook_id());
			ps.setString(2, book.getUser_id());
			ps.setString(3, book.getTrainer_name());
			ps.setInt(4, book.getBook_hour());
			ps.setInt(5, book.getBook_pay());
			n = ps.executeUpdate();
			if(n>0) {
				conn.commit();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			DBUtils.close(conn, ps);
		}
		return n;
	}
	public BookVO getUser(int book_id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BookVO vo = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select book_id, user_id, trainer_name, book_hour,\r\n"
					+ " to_char(book_pay,'l999,999,999') book_pay from book_tbl where book_id = ?");
			ps.setInt(1, book_id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				vo = new BookVO();
				vo.setBook_id(rs.getInt("book_id"));
				vo.setUser_id(rs.getString("user_id"));
				vo.setTrainer_name(rs.getString("trainer_name"));
				vo.setBook_hour(rs.getInt("book_hour"));
				vo.setBook_pay(rs.getInt("book_pay"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return vo;
	}
	public int userUpdate(BookVO book) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("Update book_tbl set "
					+ " trainer_name=?, "
					+ " book_hour=?, book_pay=? where book_id = ?");
			ps.setString(1, book.getTrainer_name());
			ps.setInt(2, book.getBook_hour());
			ps.setInt(3, book.getBook_pay());
			ps.setInt(4, book.getBook_id());
			n = ps.executeUpdate();
			System.out.println(book.getBook_id());
			
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			DBUtils.close(conn, ps);
		}
		return n;
	}
	public int userDelete(int book_id) {
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			conn = DBUtils.getConnection();
			String sql = " Delete from book_tbl where book_id=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, book_id);
			n = ps.executeUpdate();
			if(n>0) {		
				DBUtils.commit(conn);
			}
		}catch(Exception e) {
			e.printStackTrace();
			DBUtils.rollback(conn);
		} finally {
			DBUtils.close(conn, ps);
		}
		return n;
	}
}