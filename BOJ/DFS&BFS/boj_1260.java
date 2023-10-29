package dfs_bfs_basic;

import java.util.*;

public class boj_1260 {
	public static void bfs(int v, LinkedList<Integer>[] node, boolean[] visited) {
		
		//bfs는 큐! O(n+m)
		Queue<Integer> queue = new LinkedList<>();
		
		visited[v] = true;
		queue.add(v);
		
		while(queue.size()!=0) {
			v = queue.poll();
			System.out.print(v + " ");
		
			Iterator<Integer> iter = node[v].listIterator();
			while(iter.hasNext()) {
				int w = iter.next();
				if( !visited[w] ) {
					visited[w] = true;
					queue.add(w);
				}
				
			}
		}
		
	}
	
	public static void dfs(int v, LinkedList<Integer>[] node, boolean[] visited) {
		
		//dfs는 재귀! O(n+m)
		visited[v] = true;
		System.out.print(v + " ");
		
		Iterator<Integer> iter = node[v].listIterator();
		while(iter.hasNext()) {
			int w = iter.next();
			if ( !visited[w] ) {
				visited[w] = true;
				dfs(w, node, visited);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	//정점 개수
		int m = sc.nextInt();	//간선 개수
		int v = sc.nextInt();		//탐색 시작정점
		
		//방문 여부
		boolean[] visited = new boolean[n+1];
		
		//인접 정점 저장할 배열
		LinkedList<Integer>[] node = new LinkedList[n+1];

		//정점 개수  n만큼 생성
		for(int i = 0; i <= n; i++) {		//배열 크기가 n+1이므로 n까지 반복해야함!!
			node[i] = new LinkedList<Integer>();
		}
		
		//간선 개수만큼 인접 정보 입력받아서 저장
		for(int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			node[v1].add(v2);
			node[v2].add(v1);
		}
		
		for(int i = 0; i <= n; i++) {		//배열 크기가 n+1이므로 n까지 반복해야함!!
			Collections.sort(node[i]);
		}

		dfs(v, node, visited);
		System.out.println();
		
		//다시 bfs 하기 위해 visited false로 초기화
		Arrays.fill(visited, false);
		bfs(v, node, visited);
	}

}
