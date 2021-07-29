/* 
id - [] int array
the nodes that are connected will have the same indexes  
This code demo the example mentioned in Quick-find section
*/
import java.util.Arrays;

public class QuickFindUF{
	private int[] id;

	public QuickFindUF(int N){
		id = new int[N];
		for (int i=0; i<N; i++){
			id[i] = i;
		}
	}

	public boolean connected(int p, int q){
		return id[p] == id[q];
	}

	public void union(int p, int q){
		int pid = id[p];
		int qid = id[q];
		for (int i=0; i<id.length; i++){
			if (id[i] == pid){
				id[i] = qid;
			}
		}
		System.out.println("Union ("+p+", "+q+")");
		System.out.println(Arrays.toString(id));
	}

	public static void main(String[] args){
		QuickFindUF qf = new QuickFindUF(10);
		qf.union(4, 3);
		qf.union(3, 8);
		qf.union(6, 5);
		qf.union(9, 4);
		qf.union(2, 1);
		System.out.println("Connected (8, 9): "+qf.connected(8, 9));
		System.out.println("Connected (5, 0): "+qf.connected(5, 0));
		qf.union(5, 0);
		qf.union(7, 2);
		qf.union(6, 1);
	}
}