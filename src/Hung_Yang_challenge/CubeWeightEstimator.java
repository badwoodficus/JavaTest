package Hung_Yang_challenge;

//尚未完成，輸出的數值錯誤

/*
 * 一個能幫忙運送貨物的機器人,它依序分別對貨物的6個方向拍攝照片
(前、左、後、右、上、下)·並依據這些照片去推斷貨物重量是否超過
機器人所能承受的重量上限。
假設貨物是由N*N*N的立方體所組成,其中一些小立方體可能有空
缺·1*1*1的小立方體重1公斤,每個立方體塗有一種顏色,顏色由A
至Z表示,而當小立方體有整列空缺時·則以’·'符號表示。試寫一程
式,依據輸入的照片顏色推斷該貨物的重量。

限制:
1.輸入值範圍:1 <= N <= 10
2.執行時間需小於100毫秒
輸入/輸出範例
1.立方體為3*3*3,照片為3*3,照片方向依序為前、左、後、右、
上、下
輸入:
前面  左側  後面   右側  上面  下面
 · R ·    YYR    ·Y ·     RYY   · Y ·    · R ·
GRB    YGR   BYG    RBY   GYB    GRB
 · R ·    YRR   · Y ·     RRY   · R ·    · Y ·

輸出:11
2.立方體為2*2*2,照片為2*2,照片方向依序為前、左、後、右、
上、下
輸入:
ZZ ZZ ZZ ZZ ZZ ZZ
ZZ ZZ ZZ ZZ ZZ ZZ

輸出:8
 */
public class CubeWeightEstimator {
	public static void main(String[] args) {
		// 這是範例輸入，實際情況下可以從其他輸入源獲取
		String[] photos = { "·R·YYR·Y·RYY·Y··R·", "GRBYGRBYGRBYGRB", "·R·YRR·Y·RRY·R··Y·", "YGRBYGRBYGRBYGR",
				"BYGRBYGRBYGRBYG", "GRBYGRBYGRBYGRB" };

		int weight1 = estimateWeight(photos, 3);
		System.out.println("推測的重量: " + weight1);
		
	}

	// 此方法用於根據給定的照片和立方體大小估算重量
	public static int estimateWeight(String[] photos, int N) {
		// 記錄每個小立方體是否存在
		boolean[][][] cube = new boolean[N][N][N];

		// 逐照片檢查，根據不同方向更新小立方體的存在狀況
		for (int d = 0; d < 6; d++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					char color = photos[d].charAt(i * N + j);
					if (color != '·') {
						markCube(cube, d, i, j, N);
					}
				}
			}
		}

		// 計算存在的小立方體數量
		int weight = 0;
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				for (int z = 0; z < N; z++) {
					if (cube[x][y][z]) {
						weight++;
					}
				}
			}
		}

		return weight;
	}

	// 標記小立方體存在的方法
	private static void markCube(boolean[][][] cube, int direction, int i, int j, int N) {
		switch (direction) {
		case 0: // 前
			cube[i][j][0] = true;
			break;
		case 1: // 左
			cube[j][i][0] = true;
			break;
		case 2: // 後
			cube[i][j][N - 1] = true;
			break;
		case 3: // 右
			cube[j][i][N - 1] = true;
			break;
		case 4: // 上
			cube[i][0][j] = true;
			break;
		case 5: // 下
			cube[i][N - 1][j] = true;
			break;
		}
	}
}
