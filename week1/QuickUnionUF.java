/*
Quick Union
example demo
*/
import java.util.Arrays;

public class QuickUnionUF{
	private int[] id;

	public QuickUnionUF(int N){
		id = new int[N];
		for (int i=0; i<N; i++){
			id[i] = i;
		}
	} 

	// find out the root (keep going until stop)
	private int root(int i){
		while (i != id[i]){
			i = id[i];
		}
		return i;
	}

	public boolean connected(int p, int q){
		return root(p) == root(q);
	}

	public void union(int p, int q){
		int i = root(p);
		int j = root(q);
		id[i] = j;
		System.out.println("Union ("+p+", "+q+")");
		System.out.println(Arrays.toString(id));
	}

	public static void main(String[] args){
		QuickUnionUF qu = new QuickUnionUF(10);
		qu.union(4, 3);
		qu.union(3, 8);
		qu.union(6, 5);
		qu.union(9, 4);
		qu.union(2, 1);
		System.out.println("Connected (8, 9): "+qu.connected(8, 9));
		System.out.println("Connected (5, 4): "+qu.connected(5, 0));
		qu.union(5, 0);
		qu.union(7, 2);
		qu.union(6, 1);
		qu.union(7, 3);
	}
}