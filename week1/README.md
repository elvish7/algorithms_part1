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
## Quick Union
## Quick Union Improvement
## Union Find Application 


