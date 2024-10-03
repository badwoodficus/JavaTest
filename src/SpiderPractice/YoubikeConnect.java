package SpiderPractice;
//參考module01_05 GetTaipeiYouBikeInfo
import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
public class YoubikeConnect {
	public static final String YOUBIKE_URL = "https://tcgbusfs.blob.core.windows.net/dotapp/youbike/v2/youbike_immediate.json";
	public static void main(String[] args) throws IOException {
		URL url = new URL(YOUBIKE_URL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
	}
}
