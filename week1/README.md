# Union Find
## Dynamic Connectivity
Given a set of N objects.
- Union command: connect two objects.
- Find/connected query: is there a path connecting the two objects?
```
union(x, y) // connects two nodes
connected(x, y) // checks if there is a path from x to y in a connected graph
```
### Conection
We assume "is connected to" is an equivalence relation:
- Reflexive: p is connected to p.
- Symmetric: if p is connected to q, then q is connected to p.
- Transitive: if p is connected to q and q is connected to r,
then p is connected to r.
### Connected components
Maximal set of objects that are mutually connected.  
ex. {1}, {2, 5}, {3, 4, 6, 7}

## Quick Find
Also called eager approach.
- Find: Check if p and q have the same id.
- Union: To merge components containing p and q, change all entries whose id equals id[p] to id[q].

### Cost model
|  algorithm   | initialize  | union  | find  |
|  ----  | ----  | ----  | ----  |
| quick-find | N | N |1 |

Union is too expensive. It takes $N^2$ array accesses to process a sequence of N union commands on N objects.
(need to go through all objects)
## Quick Union
- Integer array id[] of length N.
- Interpretation: id[i] is parent of i.
- **Root** of i is id[id[id[...id[i]...]]]. (keep going until it doesn’t change)
### Cost model
|  algorithm   | initialize  | union  | find  |
|  ----  | ----  | ----  | ----  |
| quick-find | N | N | 1 |
| quick-union | N | N | N |

- find is expensive
- could have tall trees
## Quick Union Improvement
### #1 Weighted quick-union
- Modify quick-union to avoid tall trees.
- Keep track of size of each tree (number of objects).
- Balance by **linking root of smaller tree to root of larger tree**.
#### Running time.
- Find: takes time proportional to depth of p and q.
- Union: takes constant time, given roots.
#### Proposition
Depth of any node x is at most lg N.
- proof  
Increases by 1 when tree T1 containing x is merged into another tree T2.
-> The size of the tree containing x at least doubles since | T 2 | ≥ | T 1 |
### #2 Path compression
Just after computing the root of p, set the id of each examined node to point to that root.
- Simpler one-pass variant
Make every other node in path point to its grandparent (thereby halving path length).
To implement, there's only one extra line of code needed:
```
private int root(int i){
	while (i != id[i]){
		id[i] = id[id[i]];
		i = id[i];
	}
	return i;
}

```
### Comparison
|  algorithm   | worst-case time  |
|  ----  | ----  |
| quick-find | M N |
| quick-union | M N |
| weighted QU | N + M log N |
| QU + path compression | N + M log N |
| weighted QU + path compression | N + M log N |

*M union-find operations on a set of N objects

## Union Find Application 
### Percolation(滲透)
![image](https://www.cs.princeton.edu/courses/archive/spring11/cos226/assignments/percolates.png)  

A model for many physical systems:
- N-by-N grid of sites.
- Each site is open with probability p (or blocked with probability 1 – p).
- System percolates iff top and bottom are connected by open sites.

When N is large, theory guarantees a __sharp threshold__ p*
- p > p* : almost certainly percolates.
- p < p* : almost certainly does not percolate.