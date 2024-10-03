package SoftLeader;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSalaryCalculator {
    public static void main(String[] args) {
        // 模擬員工資料
        Employee employee = new Employee("張三", 30000);
        List<DailyRecord> records = generateMockRecords();
        // 計算薪資
        double salary = calculateMonthlySalary(employee, records);
        System.out.println(employee.getName() + " 的本月薪資為: " + salary);
    }

    public static double calculateMonthlySalary(Employee employee, List<DailyRecord> records) {
        double baseSalary = employee.getBaseSalary();
        double overtimePay = 0;

        for (DailyRecord record : records) {
            double dailyOvertimeHours = record.getWorkHours() - 8; // 假設正常工時為8小時
            if (dailyOvertimeHours > 0) {
                overtimePay += calculateOvertimePay(dailyOvertimeHours);
            }
        }

        return baseSalary + overtimePay;
    }

    public static double calculateOvertimePay(double overtimeHours) {
        // 加班費計算級距
        if (overtimeHours <= 2) {
            return overtimeHours * 1.34 * (1/30.0) * 30000; // 前2小時，時薪的1.34倍
        } else if (overtimeHours <= 4) {
            return 2 * 1.34 * (1/30.0) * 30000 + (overtimeHours - 2) * 1.67 * (1/30.0) * 30000; // 第3-4小時，時薪的1.67倍
        } else {
            return 2 * 1.34 * (1/30.0) * 30000 + 2 * 1.67 * (1/30.0) * 30000 + (overtimeHours - 4) * 2.67 * (1/30.0) * 30000; // 第4小時以上，時薪的2.67倍
        }
    }

    public static List<DailyRecord> generateMockRecords() {
        List<DailyRecord> records = new ArrayList<>();
        YearMonth yearMonth = YearMonth.now();
        for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
            LocalDate date = yearMonth.atDay(day);
            if (date.getDayOfWeek().getValue() <= 5) { // 假設週一到週五工作
                records.add(new DailyRecord(date, 9)); // 假設每天工作9小時
            }
        }
        return records;
    }
}

class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
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

class DailyRecord {
    private LocalDate date;
    private double workHours;

    public DailyRecord(LocalDate date, double workHours) {
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
