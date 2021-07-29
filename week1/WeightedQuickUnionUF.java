/*
Weighted Quick Union
example demo
*/
import java.util.Arrays;

public class WeightedQuickUnionUF{
	private int[] id;
	private int[] sz; // tree size

	public WeightedQuickUnionUF(int N){
		id = new int[N];
		sz = new int[N];
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
		if  (i == j){
			return;
		}
		// check the tree size to decide which tree to merge into
		if (sz[i] < sz[j]){
			id[i] = j;
			sz[j] += sz[i];
		}
		else{
			id[j] = i;
			sz[i] += sz[j];
		}
		System.out.println("Union ("+p+", "+q+")");
		System.out.println(Arrays.toString(id));
	}

	public static void main(String[] args){
		WeightedQuickUnionUF wqu = new WeightedQuickUnionUF(10);
		wqu.union(4, 3);
		wqu.union(3, 8);
		wqu.union(6, 5);
		wqu.union(9, 4);
		wqu.union(2, 1);
		System.out.println("Connected (8, 9): "+wqu.connected(8, 9));
		System.out.println("Connected (5, 4): "+wqu.connected(5, 0));
		wqu.union(5, 0);
		wqu.union(7, 2);
		wqu.union(6, 1);
		wqu.union(7, 3);
	}
}