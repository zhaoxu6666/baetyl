import java.util.HashMap;
import java.util.Map;

//对于给定的n个位于同一二维平面上的点，求最多能有多少个点位于同一直线上
//Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
//主要把斜率给搞定

public class qiongjv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public int maxPoints(Point[] points) {
		int l = points.length;
        if(l==0) {
        	return 0;
        }
        if(l==1) {
        	return 1;
        }
        int n=0;
        for(int i=0;i<l;i++) {
        	int d=1;
        	int chuizhi =0;
        	Map<Float,Integer> map=new HashMap<>();
        	Point a = points[i];
        	for(int j=0;j<l;j++) {
        		Point b = points[j];
        		if(j==i) {
        			continue;
        		}
        		if(a.x==b.x) {   //垂直的情况
        			if(a.y==b.y)    //重合情况
        				d++;
        			else
        				chuizhi++;
        		}else {
        			float k = (float)(a.y-b.y)/(a.x-b.x);  //(flaot)是个坑s
        			if(map.get(k)==null) map.put(k, 1);
        			else map.put(k, map.get(k)+1);
        		}
        	}
        	int max=chuizhi;
        	for(float k:map.keySet()) {
        		max=Math.max(max, map.get(k));
        	}
        	n=Math.max(n, max+d);        	
        }
        return n;
	}
	
class Point {
	     int x;
	     int y;
	     Point() { x = 0; y = 0; }
	     Point(int a, int b) { x = a; y = b; }
	}
}