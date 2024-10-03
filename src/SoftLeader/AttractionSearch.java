package SoftLeader;

import java.util.*;

public class AttractionSearch {
	private List<String> attractions;

	public AttractionSearch() {
		attractions = new ArrayList<>(
				Arrays.asList("台北101", "故宮博物院", "中正紀念堂", "西門町", "九份老街", "日月潭", "阿里山", "墾丁國家公園", "太魯閣國家公園", "高雄85大樓"));
	}

	public List<String> searchAndSort(String keyword) {
		List<String> results = new ArrayList<>();

		for (String attraction : attractions) {
			if (attraction.toLowerCase().contains(keyword.toLowerCase())) {
				results.add(attraction);
			}
		}

		Collections.sort(results);
		return results;
	}

	public static void main(String[] args) {
		AttractionSearch searcher = new AttractionSearch();
		Scanner scanner = new Scanner(System.in);

		System.out.print("請輸入要搜尋的景點名稱關鍵字：");
		String keyword = scanner.nextLine();

		List<String> searchResults = searcher.searchAndSort(keyword);

		if (searchResults.size() != 0) {
			System.out.println("搜尋結果：");
			for (String result : searchResults) {
				System.out.println(result);
			}
		} else {
			System.out.println("查無結果,請再次嘗試!");
		}

		scanner.close();
	}
}
