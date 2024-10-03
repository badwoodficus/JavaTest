package tw.com.softleader.interview.test2;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * 上機考題：計算人事成本
 * 
 * 題目：計算每位員工的當月總應付總薪資，並請使用printSomebodyPay 將結果顯示在console上
 * 
 * 細部描述: 目前已有取得每人每日打卡資料的功能 TimeClockService.getData() 請依據打卡資料計算日薪,然後計算每人月薪
 * 最後將每人月薪傳入 printSomebodyPay 方法進行顯示
 * 
 * 根據美國勞基法規定,工時超過8小時後,加班費應依下列倍率計算 第0~8小時給予基本時薪 第8~12小時給予基本時薪×1.5倍
 * 第12小時開始給予基本時薪×2倍
 * 
 * 答題提示: 1.除了本試題說明的註解外,你可以對這支程式的任何邏輯(含printSomebodyPay)做修改 2. 承1,但正常只需要於 main
 * 撰寫邏輯即可完成此題 3. 本程式所使用的日期時間物件為 LocalDateTime,這是一個於jdk8後才引入的class
 * LocalDateTime有一套相關的Api可以計算兩個時間的間距,請自行搜索 若要測試程式是否可以運作,可以直接執行 main 方法
 * 
 * @author Rhys
 */
public class App {
	public static void main(String[] args) {
		// 取得所有打卡資料
		final List<TimeClockEntity> timeClockDatas = TimeClockService.getData();// 這是一個VO可以使用getTimeIn,getTimeOut取得時間
		// TODO
		Map<String, Double> empSalary = new HashMap<>();
		for (int i = 0; i < timeClockDatas.size(); i++) {
			TimeClockEntity entity = (TimeClockEntity) timeClockDatas.get(i);
			String empName = entity.getEmployeeName();
			LocalDateTime start = entity.getTimeIn();
			LocalDateTime end = entity.getTimeOut();
			Duration duration = Duration.between(start, end);
			int workHours = (int) duration.toHours();
			double rate = entity.getHourilyRate();
			double dailyPay = dailyPayment(workHours, rate);
			//只差第42行直接在value計算就好
			empSalary.put(empName, empSalary.getOrDefault(empName, 0.0) + dailyPay);
		}
		empSalary.forEach((name, salary) -> printSomebodyPay(name, salary));
	}

	private static void printSomebodyPay(String name, double salary) {
		System.out.println("員工: " + name + "薪水$" + salary);
	}

	//計算員工日薪的方法
	private static double dailyPayment(int workHours, double rate) {
		double dailyPay = 0.0;
		if (workHours <= 8) {
			dailyPay = workHours * rate;
		} else if (workHours > 8 && workHours < 12) {
			dailyPay = (workHours - 8) * 1.5 * rate + 8 * rate;
		} else {
			dailyPay = (workHours - 12) * 2 * rate + 4 * 1.5 * rate + 8 * rate;
		}
		return dailyPay;
	}
}
