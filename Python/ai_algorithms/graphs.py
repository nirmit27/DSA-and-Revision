""" 
--- Implementation of the Graph data structure ---
"""

from collections import defaultdict, deque


class Graph:
    def __init__(self) -> None:
        self.graph = defaultdict(list[int])

    def __len__(self) -> int:
        return len(self.graph)

    def __getitem__(self, u: int) -> list[int]:
        return self.graph[u]

    def add_edge(self, u: int, v: int) -> None:
        self.graph[u].append(v)
        self.graph[v].append(u)

    def bfs(self, src: int) -> None:
        print(f"\nBFS Traversal starting from vertex {src} : ", end="")

        q: deque[int] = deque()
        visited: list[bool] = [False] * len(self.graph)

        q.append(src)
        visited[src] = True

        while q:
            current: int = q.popleft()
            print(f"{current} ", end="")

            for v in self.graph[current]:
                if not visited[v]:
                    q.append(v)
                    visited[v] = True
        print()

    def dfs_util(self, visited: list[bool], u: int) -> None:
        visited[u] = True
        print(f"{u} ", end="")

        for v in self.graph[u]:
            if not visited[v]:
                self.dfs_util(visited, v)

    def dfs(self, src: int) -> None:
        print(f"\nDFS Traversal starting from vertex {src} : ", end="")
        visited: list[bool] = [False] * len(self.graph)

        self.dfs_util(visited, src)
        print()


def main() -> None:
    graph: Graph = Graph()

    # Constructing the graph
    graph.add_edge(0, 1)
    graph.add_edge(0, 2)
    graph.add_edge(1, 3)
    graph.add_edge(1, 4)
    graph.add_edge(2, 4)

    # BFS traversal
    graph.bfs(src=0)

    # DFS traversal
    graph.dfs(src=0)


if __name__ == "__main__":
    main()
