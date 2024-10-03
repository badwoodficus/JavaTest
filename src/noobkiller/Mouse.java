package noobkiller;

class Point {
	final int x;
	final int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

interface Boss {
	void take(int[][] maze);
}

public class Mouse {
	public static void visit(int[][] maze, Point pt, Point end, Boss boss) {
		if (isVisitable(maze, pt)) {
			maze[pt.x][pt.y] = 1;
			if (isEnd(maze, end)) {
				boss.take(maze);
			} else {
				visit(maze, new Point(pt.x, pt.y + 1), end, boss);
				visit(maze, new Point(pt.x + 1, pt.y), end, boss);
				visit(maze, new Point(pt.x, pt.y - 1), end, boss);
				visit(maze, new Point(pt.x - 1, pt.y), end, boss);
			}
			maze[pt.x][pt.y] = 0;
		}
	}

	private static boolean isVisitable(int[][] maze, Point pt) {
		return maze[pt.x][pt.y] == 0;
	}

	private static boolean isEnd(int[][] maze, Point end) {
		return maze[end.x][end.y] == 1;
	}

	public static void main(String[] args) {
		Mouse.visit(new int[][] { 
				{ 2, 2, 2, 2, 2, 2, 2 }, // 0表示道路,2表示牆壁，請列印出老鼠走出迷宮的路線(不包含繞路)
				{ 0, 0, 0, 0, 0, 0, 2 }, // 入口在此列的最左邊0 [1][0]
				{ 2, 0, 2, 0, 2, 0, 2 }, 
				{ 2, 0, 0, 2, 0, 2, 2 }, 
				{ 2, 2, 0, 2, 0, 2, 2 }, 
				{ 2, 0, 0, 0, 0, 0, 2 },
				{ 2, 2, 2, 2, 2, 0, 2 } // [6][5]為迷宮出口
		}, new Point(1, 0), new Point(6, 5), maze -> {
			for (int[] row : maze) {
				for (int block : row)
					switch (block) {
					case 0:
						System.out.print("□");
						break;
					case 1:
						System.out.print("◇");
						break;
					case 2:
						System.out.print("█");
						break;
					}
				System.out.println();
			}
		});
	}
}
