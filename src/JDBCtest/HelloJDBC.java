package JDBCtest;

//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HelloJDBC {
	// DRIVER是固定的名字，由廠商實作
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver"; // 注意大小寫一致
	public static final String URL = "jdbc:mysql://localhost:3306/jdbcsample?serverTimezone=Asia/Taipei";
	public static final String USER = "root";
	public static final String PASSWORD = "123456";

	// 上面的String打錯任何一個字，報錯會出現ClassNotFoundException與NullPointerException
	public static void main(String[] args) {
		Connection con = null;// 宣告在方法內的try外面才可以在finally關閉，不可以宣告成實體變數
		Statement stmt = null;// 注意引用java.sql.Statement
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入要新增的編號");
		int deptno = sc.nextInt();
		System.out.println("請輸入要新增的部門名稱");
		String dname = sc.next();
		System.out.println("請輸入此部門的所在地點");
		String loc = sc.next();
		
		sc.close();
		try {
			// step.1:載入驅動
			Class.forName(DRIVER);// 類別載入器
			System.out.println("載入成功");// 檢查是否有載入資料庫

			// step.2:建立連線
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("連線成功");// 檢查是否連線MySQL，注意上方引數字串的順序

			// step.3:送出SQL指令
//			stmt = con.createStatement();
//			int count = stmt.executeUpdate("insert into department values (50,'人事部','南京復興')");// 在Java寫SQL用單引號''不然要加/跳脫麻煩
//			executeUpdate()回傳一個整數表示成功更新幾筆資料
//			System.out.println(count + "row(s) updated");
//			stmt = con.createStatement();
//			rs = stmt.executeQuery("select * from department order by deptno DESC"); // 注意SQL語法 還有 * ，直接用SQL ORDER語法可以省略java的comparator
//			while (rs.next()) {// 移動游標且回傳一個boolean，不確定要查幾次所以使用while迴圈
//				int deptno = rs.getInt("deptno");// 欄位名放引數
//				String dname = rs.getString("dname");
//				String loc = rs.getString("loc");
//
//				System.out.println("DEPTNO = " + deptno + " DNAME = " + dname + " LOC " + loc);
//				System.out.println("=====================");
//			}
//			PreparedStatement
			pstmt = con.prepareStatement("insert into department values (?,?,?)");//跟介面差一個 d ,?代表未知的value
//			注意SQL的索引值從1開始，對應到相對的"?"參數順序
			pstmt.setInt(1, deptno); // 參數搭配型別與對應的欄位
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			
			pstmt.executeUpdate();
			System.out.println("已新增資料!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
			if (stmt != null) {// 關閉前確認不為空值表示有指令
				try {
					stmt.close();
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
//			con.close();//con若是宣告在try內的話是區域變數屬於try所以不能用
		}
	}
}
