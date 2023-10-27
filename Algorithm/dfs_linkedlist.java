package dfs;

import java.util.*;

//LinkedList 인접리스트 + 재귀로 dfs 구현
// O(n+e)
public class dfs_linkedlist {
	
	public static void dfs_list(int v, LinkedList<Integer>[] node, boolean visited[]) {
		visited[v] = true;	//정점 방문여부 표시 (시작 정점 v 부터 시작)
		System.out.print(v + "-> ");	//방문한 정점 출력
		
		//재귀로 처음 시작 정점 v를 시작으로 인접한 정점이 새로운 기준이 됨 (계속 깊이 들어감)
		Iterator<Integer> iter = node[v].listIterator();	//정점이 저장되어 있는 리스트 순회
		while(iter.hasNext()) {		//다음 순회 정점이 존재할때까지
			int w = iter.next();		//다음 정점
			if ( !visited[w] ) 	//다음 정점이 방문하지 않은 정점이라면
				dfs_list(w, node, visited);	 	//다시 dfs 재귀
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	//정점 개수
		int m = sc.nextInt();	//간선 개수
		int v = sc.nextInt();		//탐색 시작 정점
		
		boolean visited[] = new boolean[n+1];	//각 정점 방문 여부
		
		//n+1개의 노드 배열 만들고
		LinkedList<Integer>[] node = new LinkedList[n+1];
		
		for(int i = 0; i <=n; i++) {
			node[i] = new LinkedList<Integer>();
		}
		
		//m개 간선개수만큼 두 정점 사이 간선 입력
		//입력으로 주어지는 간선은 양방향으로 2번 추가
		for(int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			node[v1].add(v2);
			node[v2].add(v1);
		}
		
		//방문 순서를 위해 오름차순 정렬
		for(int i = 1; i <= n; i++) {
			Collections.sort(node[i]);
		}
		
		System.out.println("DFS예제-LinkedList");
		dfs_list(v, node, visited);
	}
}
