package orm;

import java.util.*;
public class AppTest {
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("請輸入要查詢的編號");
//		System.out.println("請輸入要新增的編號");
//		int deptno = sc.nextInt();
//		System.out.println("請輸入要新增的部門名稱");
//		String dname = sc.next();
//		System.out.println("請輸入此部門的所在地點");
//		String loc = sc.next();
		
//		sc.close();
		
//		從Scanner 拿到要新增的資料,用Dept Bean包裝起來
//		所以此物件(Dept)就是代表一筆要新增的部門資料
//		Dept dept = new Dept(deptno,dname,loc);
		
//		對部門表格的資料操作，一律透過DAO物件的方法完成
		DeptDAO dao = new DeptDAOImpl();
//		dao.add(dept);			//新增資料
//		System.out.println(dept);
		
//		Dept dept = dao.findByDeptno(deptno);//查詢單筆的程式
//		System.out.println(dept);
		
		List<Dept> deptList = dao.getAll();//查詢全部的程式
		for(Dept dept: deptList) {
			System.out.println(dept);
		}
	}
}
