package com.lyf.map;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * 		使用邻接矩阵 存储图
 */
public class MapDemo {
	public static void main(String[] args) {
		String []str = {"A","B","C","D","E"};
		Map m = new Map(str.length);
		for (String s : str) {
			m.addNode(s);
		}
		
		m.addSide("A", "B", 1);
		m.addSide("A", "C", 1);
		m.addSide("B", "C", 1);
		m.addSide("B", "D", 1);
		m.addSide("B", "E", 1);
		
		System.out.println("邻接矩阵:");
		m.show();
		System.out.println("边数为:"+m.getSideC());
		System.out.println("深度优先搜索:");
		dfs(0,m);
		System.out.println();
		System.out.println("广度优先搜索:");
		bfs(0,m);
	}
	
	static boolean []Visited = new boolean[5];
//	深度优先遍历
	public static void dfs(int index,Map map) {
//		访问当前节点
		System.out.print(map.getAl().get(index)+" ");
		
//		将访问过的 节点标记为已访问
		Visited[index] = true;
		
//		找到节点的 第一个邻接节点
		int neighbor = map.getFNode(index);
		
		while(neighbor!=-1) {
			if(!Visited[neighbor]) {
				dfs(neighbor,map);
			}else {
//				被访问过  就继续向后面的邻接点  查找
				neighbor = map.getNextNode(index, neighbor);
			}
		}
		
//		访问 剩下的没有访问的节点
		for (int i = 0; i < map.getAl().size(); i++) {
			if(!Visited[i]) {
				dfs(i,map);
			}
		}
	}
	
	
	
	static boolean []isVisited = new boolean[5];
//	广度优先遍历
	public static void bfs(int index , Map map) {
//		使用一个集合 充当队列
		LinkedList<Integer> ll =new LinkedList<Integer>();
		
		System.out.print(map.getAl().get(index)+" ");
		isVisited[index] = true;
//		放入队列
		ll.add(index);
		
		while(!ll.isEmpty()) {
			int value = ll.removeFirst();
//			查找节点的第一个邻接点
			int neighbor = map.getFNode(value);
			
			while(neighbor!=-1) {
				if(!isVisited[neighbor]) {
					System.out.print(map.getAl().get(neighbor)+" ");
					isVisited[neighbor] = true;
					ll.add(neighbor);
				}else {
//					如果被访问过则 找其他的邻接点
					neighbor = map.getNextNode(value, neighbor);
				}
			}
		}
//		遍历没有被连通的节点
		for (int i = 0; i < map.getAl().size(); i++) {
			if(!isVisited[i]) {
				bfs(i,map);
			}
		}
	}
}

//	图
class Map{
	private ArrayList<String> al;
	private int [][]map;
	private int nodeC;
	private int sideC;
	
	public Map(int nodeC) {
		this.nodeC = nodeC;
		sideC = 0;
		al = new ArrayList<String>(nodeC);
		map = new int[nodeC][nodeC];
	}
	
//	添加节点到集合中
	public void addNode(String data) {
		al.add(data);
	}
	
//	获取节点的第一个连通节点
	public int getFNode(int index) {
		for (int i = index; i < map.length; i++) {
			if(map[index][i]==1) {
				return i;
			}
		}
		return -1;
	}
	
//	获取节点的下一个节点
	public int getNextNode(int index , int w) {
		for (int i = w+1; i < al.size(); i++) {
			if(map[index][i]>1) {
				return i;
			}
		}
		return -1;
	}

//	通过数据查询到下标
	public int index(String value) {
		for (int i = 0; i < al.size(); i++) {
			if(al.get(i).equals(value)) {
				return i; 
			}
		}
		return -1;
	}
	
	
//	添加边
	public void addSide(String v1,String v2,int weight) {
		int v1Index = index(v1);
		int v2Index = index(v2);
		
		map[v1Index][v2Index] = weight;
		map[v2Index][v1Index] = weight;
		sideC++;
	}
	
//	输出边的条数
	public int sideC() {
		return sideC; 
	}
	
//	 显示图
	public void show() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	public ArrayList<String> getAl() {
		return al;
	}

	public void setAl(ArrayList<String> al) {
		this.al = al;
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	public int getNodeC() {
		return nodeC;
	}

	public void setNodeC(int nodeC) {
		this.nodeC = nodeC;
	}

	public int getSideC() {
		return sideC;
	}

	public void setSideC(int sideC) {
		this.sideC = sideC;
	}
}
