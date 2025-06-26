"""Finding the Minimum Spanning Tree using Kruskal's Algorithm"""


class Edge:
    """Class for storing the edge data"""

    def __init__(self, s, e, wt):
        self.start = s
        self.end = e
        self.weight = wt

    @staticmethod
    def display_edges(edges):
        print("\nEdges are as follows :\n")
        for e in edges:
            print(e)

    def __repr__(self) -> str:
        return f"( start : {self.start}, end : {self.end}, weight : {self.weight} )"


def make_set(ranks, parents):
    for node in range(n):
        ranks[node] = 0
        parents[node] = node


def find_parent(node, parent):
    if parent[node] == node:
        return node
    return find_parent(parent[node], parent)


def union_set(u_node, v_node, parent, rank):
    u_parent = find_parent(u_node, parent)
    v_parent = find_parent(v_node, parent)

    if rank[u_parent] < rank[v_parent]:
        parent[u_parent] = v_parent
        rank[v_parent] += 1

    elif rank[v_parent] < rank[u_parent]:
        parent[v_parent] = u_parent
        rank[u_parent] += 1

    else:
        parent[u_parent] = v_parent
        rank[v_parent] += 1


def mst(edges, nodes):
    min_weight = 0
    edges.sort(key=lambda x: x.weight)

    rank = [0] * nodes
    parent = [0] * nodes

    make_set(rank, parent)

    for e in edges:
        n1 = find_parent(e.start, parent)
        n2 = find_parent(e.end, parent)

        if n1 != n2:
            min_weight += e.weight
            union_set(n1, n2, parent, rank)

    return min_weight


if __name__ == "__main__":
    data = []
    (n, m) = list(map(int, input("Enter the number of vertices and edges : ").split()))

    print("\nEnter the edge data :- (start, end, weight)\n")
    for i in range(m):
        (u, v, w) = list(map(int, input(f"Enter edge #{i + 1} : ").split()))
        edge = Edge(u, v, w)
        data.append(edge)

    Edge.display_edges(data)
    print(f"\nTotal cost of the Minimum Spanning Tree = {mst(data, n)}")
