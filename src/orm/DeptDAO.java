package orm;

import java.util.List;

//一種操作對應一個方法
public interface DeptDAO {
	void add(Dept dept);//一筆資料等於一個部門物件
	void update(Dept dept);
	void delete(Integer deptno);
	
	Dept findByDeptno(Integer deptno);//用PK deptno 找到一個物件回傳物件
	List<Dept>getAll();//回傳多筆資料，使用集合(動態長度) 可以搭配Order By
}
