package SoftLeader;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		Employee1 emp = new Employee1("小李", 40000);
		List<DailyRecord> records = generateMockRecords();
		
		double salary = calculateMonthlySalary(emp, records);
		System.out.println(emp.getName()+"本月薪資為: "+salary);
		
	}
	
	public static double calculateMonthlySalary(Employee1 emp, List<DailyRecord> records) {
		double baseSalary = emp.getBaseSalary();
		double overtimePay = 0;
		
		for(DailyRecord record : records) {
			double dailyOvertimeHours = record.getWorkHours() -8 ;
			if(dailyOvertimeHours > 0) {
				overtimePay += calculateOvertimePay(dailyOvertimeHours);
			}
		}
		
		return baseSalary + overtimePay;
	}
	
	public static double calculateOvertimePay(double overtimeHours) {
		if(overtimeHours <= 2) {
			return overtimeHours *1.34*(1/30.0) *30000;
		}else if ( overtimeHours <= 4 ) {
			return (2*1.34*(1/30.0)+(overtimeHours - 2)*1.67*(11/30.0))*30000;
		}else {
			return (2*1.34*(1/30.0)+2*1.67*(1/30.0)+(overtimeHours - 4)*2.67*(1/30.0))*30000;
		}
	}
	
	public static List<DailyRecord> generateMockRecords(){
		List<DailyRecord> records = new ArrayList<>();
		YearMonth yearMonth = YearMonth.now();
		for(int day =1; day <= yearMonth.lengthOfMonth();day++) {
			LocalDate date = yearMonth.atDay(day);
			if(date.getDayOfWeek().getValue() <= 5) {
				records.add(new DailyRecord(date, 9));
			}
		}
		return records;
	}
	
}

class Employee1{
	private String name;
	private double baseSalary;
	
	public Employee1(String name, double baseSalary) {
		this.name = name;
		this.baseSalary = baseSalary;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBaseSalary() {
		return baseSalary;
	}
}

class DailyRecord1{
	private LocalDate date;
	private double workHours;
	
	public DailyRecord1(LocalDate date, double workHours) {
		this.date = date;
		this.workHours = workHours;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public double getWorkHours() {
		return workHours;
	}
}
