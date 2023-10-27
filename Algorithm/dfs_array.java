package dfs;

import java.util.*;

public class dfs_array {
	
	//Array 인접행렬 + 재귀
	//O(n^2)
	public static void dfs_array_recursion(int v, int[][] node, boolean visited[]) {
		int l = node.length-1;
		visited[v] = true;
		System.out.print(v + " ");
		
		for(int i = 1; i <= l; i++) {
			if( node[v][i] == 1 && !visited[i] ) {
				dfs_array_recursion(i, node, visited);
			}
		}
	}
	
	//Array 인접행렬 + stack (LIFO)
	//O(n^2)
	public static void dfs_array_stack(int v, int[][] node, boolean visited[], boolean flag) {
		int l = node.length-1;
		
		Stack<Integer> stack = new Stack<>();
		stack.push(v);	//시작 정점부터 stack에 넣기
		visited[v] = true;
		System.out.print(v + " ");
		
		while( !stack.isEmpty() ) {	//isEmpty가 false이면=stack에 값이 있을때까지 반복
			int w = stack.peek();		//stack의 최근값 꺼내기
			flag = false;					//
			
			for(int i = 1; i <= l; i++) {	//간선 개수만큼 돌면서
				if( node[w][i] == 1 && !visited[i] ) {	//연결되어 있으면서 방문하지 않았으면
					stack.push(i);		//
					System.out.print(i + " ");
					visited[i] = true;
					flag = true;
					
					break;
				}
			}
			
			if(!flag) {		//flag이 false이면
				stack.pop();
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	//정점 개수
		int m = sc.nextInt();	//간선 개수
		int v = sc.nextInt();		//시작 정점
		
		boolean visited[] = new boolean[n+1];
		
		int[][] node = new int[n+1][n+1];
		
		//m개 간선 저장
		for(int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			node[v1][v2] = 1;
			node[v2][v1] = 1;
		}
		
		System.out.println("DFS예제-Array/재귀");
		dfs_array_recursion(v, node, visited);
		
		Arrays.fill(visited, false);	//stack dfs 돌리기 위해서 visited배열 false로 초기화
		System.out.println();
		System.out.println("DFS예제-Array/stack");
		dfs_array_stack(v, node, visited, true);
	}

}
