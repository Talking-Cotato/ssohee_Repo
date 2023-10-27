package bfs;
import java.util.*;

//LinkedList 인접리스트 + 큐(FIFO) bfs 구현
//O(n+e)
public class bfs_linkedlist {
	public static void bfs_list(int v, LinkedList<Integer>[] node, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[v] = true;	//탐색 시작 정점 방문 t
		queue.add(v);		//큐에 시작 정점 넣기
		
		while(queue.size() != 0) {		//큐에 값이 없을때까지 반복
			v = queue.poll();				//큐에서 front 정점 꺼내기
			System.out.print(v + " ");
			
			//처음 시작 정점 v를 기준으로 인접한 정점 모두 찾아 큐에 추가 (너비 우선)
			Iterator<Integer> iter = node[v].listIterator();	//정점이 저장되어 있는 리스트 순회
			while(iter.hasNext()) {		//다음 순회 정점이 존재할때까지
				int w = iter.next();
				
				if( !visited[w] ) {			//다음 정점 방문여부가 F이면
					visited[w] = true;	//다음 정점 방문
					queue.add(w);		//큐에 추가하기
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		
		boolean[]  visited = new boolean[n+1];
		
		LinkedList<Integer>[] node = new LinkedList[n+1];
		
		for(int i = 0; i <= n; i++) {
			node[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			node[v1].add(v2);
			node[v2].add(v1);
		}
		
		for(int i = 0; i < n; i++) {
			Collections.sort(node[i]);
		}
		
		System.out.println("BFS예제 - LinkedList");
		bfs_list(v, node, visited);
		
	}

}
