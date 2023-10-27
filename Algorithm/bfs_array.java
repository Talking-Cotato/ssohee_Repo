package bfs;

import java.util.*;

//Array 인접행렬 + queue(FIFO)
//O(n^2)
public class bfs_array {
	
	public static void bfs_array_queue(int v, int[][] node, boolean visited[]) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int l = node.length-1;
		
		queue.add(v);
		visited[v] = true;
		//queue.add(v);
		
		while( !queue.isEmpty() ) {
			v = queue.poll();
			System.out.print(v + " ");
			
			for(int i = 1; i <= l; i++) {	//배열 인덱스 1부터 시작하며 반복해야함!!
				if (node[v][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		
		boolean visited[] = new boolean[n+1];
		
		int[][] node = new int[n+1][n+1];
		
		for(int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			node[v1][v2] = 1;
			node[v2][v1] = 1;
		}
		
		System.out.println("BFS 예제 - array");
		bfs_array_queue(v, node, visited);
	}
}
