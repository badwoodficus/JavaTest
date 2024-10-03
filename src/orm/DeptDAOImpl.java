package orm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

//名稱XXXXImpl實作介面的類別
public class DeptDAOImpl implements DeptDAO {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver"; // 注意大小寫一致
	public static final String URL = "jdbc:mysql://localhost:3306/jdbcsample?serverTimezone=Asia/Taipei";
	public static final String USER = "root";
	public static final String PASSWORD = "123456";

	public static final String INSERT_STMT = "insert into department values(?,?,?)";
	public static final String FIND_BY_DEPTNO = "select * from department where deptno = ?";
	public static final String GET_ALL = "select * from department order by deptno DESC";
	
	
	static {// static 區塊在程式載入時就會執行一次
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void add(Dept dept) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pstmt != null) {// 關閉前確認不為空值表示有指令
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			if (con != null) {// 關閉前確認不為空值表示有連線
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}

	}

	@Override
	public void update(Dept dept) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer deptno) {
		// TODO Auto-generated method stub

	}

	@Override
	public Dept findByDeptno(Integer deptno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dept dept = null;

		try {

			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_DEPTNO);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// 建立部門物件Dept Bean,用來包裝查詢到的資料
				dept = new Dept();
				dept.setDeptno(deptno);
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (rs != null) {// 關閉前確認不為空值表示有指令
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			if (pstmt != null) {// 關閉前確認不為空值表示有指令
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			if (con != null) {// 關閉前確認不為空值表示有連線
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}

		return dept;
	}

	@Override
	public List<Dept> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Dept> deptList = new ArrayList<>();

		try {

			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// 建立部門物件Dept Bean,用來包裝查詢到的資料
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				
				//將包裝好的Dept Bean , 再用集合收集起來
				deptList.add(dept);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (rs != null) {// 關閉前確認不為空值表示有指令
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			if (pstmt != null) {// 關閉前確認不為空值表示有指令
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			if (con != null) {// 關閉前確認不為空值表示有連線
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
		return deptList;
	}

}
