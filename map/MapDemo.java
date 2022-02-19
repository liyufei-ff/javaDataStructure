package com.lyf.map;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * 		ʹ���ڽӾ��� �洢ͼ
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
		
		System.out.println("�ڽӾ���:");
		m.show();
		System.out.println("����Ϊ:"+m.getSideC());
		System.out.println("�����������:");
		dfs(0,m);
		System.out.println();
		System.out.println("�����������:");
		bfs(0,m);
	}
	
	static boolean []Visited = new boolean[5];
//	������ȱ���
	public static void dfs(int index,Map map) {
//		���ʵ�ǰ�ڵ�
		System.out.print(map.getAl().get(index)+" ");
		
//		�����ʹ��� �ڵ���Ϊ�ѷ���
		Visited[index] = true;
		
//		�ҵ��ڵ�� ��һ���ڽӽڵ�
		int neighbor = map.getFNode(index);
		
		while(neighbor!=-1) {
			if(!Visited[neighbor]) {
				dfs(neighbor,map);
			}else {
//				�����ʹ�  �ͼ����������ڽӵ�  ����
				neighbor = map.getNextNode(index, neighbor);
			}
		}
		
//		���� ʣ�µ�û�з��ʵĽڵ�
		for (int i = 0; i < map.getAl().size(); i++) {
			if(!Visited[i]) {
				dfs(i,map);
			}
		}
	}
	
	
	
	static boolean []isVisited = new boolean[5];
//	������ȱ���
	public static void bfs(int index , Map map) {
//		ʹ��һ������ �䵱����
		LinkedList<Integer> ll =new LinkedList<Integer>();
		
		System.out.print(map.getAl().get(index)+" ");
		isVisited[index] = true;
//		�������
		ll.add(index);
		
		while(!ll.isEmpty()) {
			int value = ll.removeFirst();
//			���ҽڵ�ĵ�һ���ڽӵ�
			int neighbor = map.getFNode(value);
			
			while(neighbor!=-1) {
				if(!isVisited[neighbor]) {
					System.out.print(map.getAl().get(neighbor)+" ");
					isVisited[neighbor] = true;
					ll.add(neighbor);
				}else {
//					��������ʹ��� ���������ڽӵ�
					neighbor = map.getNextNode(value, neighbor);
				}
			}
		}
//		����û�б���ͨ�Ľڵ�
		for (int i = 0; i < map.getAl().size(); i++) {
			if(!isVisited[i]) {
				bfs(i,map);
			}
		}
	}
}

//	ͼ
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
	
//	��ӽڵ㵽������
	public void addNode(String data) {
		al.add(data);
	}
	
//	��ȡ�ڵ�ĵ�һ����ͨ�ڵ�
	public int getFNode(int index) {
		for (int i = index; i < map.length; i++) {
			if(map[index][i]==1) {
				return i;
			}
		}
		return -1;
	}
	
//	��ȡ�ڵ����һ���ڵ�
	public int getNextNode(int index , int w) {
		for (int i = w+1; i < al.size(); i++) {
			if(map[index][i]>1) {
				return i;
			}
		}
		return -1;
	}

//	ͨ�����ݲ�ѯ���±�
	public int index(String value) {
		for (int i = 0; i < al.size(); i++) {
			if(al.get(i).equals(value)) {
				return i; 
			}
		}
		return -1;
	}
	
	
//	��ӱ�
	public void addSide(String v1,String v2,int weight) {
		int v1Index = index(v1);
		int v2Index = index(v2);
		
		map[v1Index][v2Index] = weight;
		map[v2Index][v1Index] = weight;
		sideC++;
	}
	
//	����ߵ�����
	public int sideC() {
		return sideC; 
	}
	
//	 ��ʾͼ
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
