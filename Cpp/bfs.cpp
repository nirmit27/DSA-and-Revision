#include <bits/stdc++.h>
using namespace std;

void bfsTraversal(vector<vector<int>> adjList) {
  int src;
  queue<int> q;
  vector<int> visited(adjList.size(), false);

  cout << endl << "Enter the starting vertex : ";
  cin >> src;

  q.push(src);
  visited[src] = true;
  cout << endl
       << endl
       << "Breadth First Traversal from vertex " << src << " :" << endl
       << endl;

  while (!q.empty()) {
    int curr = q.front();
    q.pop();

    cout << curr << " ";

    for (int nbr : adjList[curr]) {
      if (!visited[nbr]) {
        visited[nbr] = true;
        q.push(nbr);
      }
    }
  }
}

void addEdges(vector<vector<int>> &adjList) {
  cout << endl
       << "Enter the graph data : (Enter -1 to stop adding neighbour nodes)"
       << endl;
  int u = 0;

  while (u < adjList.size()) {
    int v;
    cout << endl << "Enter the destination vertices for vertex " << u << " : ";
    cin >> v;

    if (v != -1)
      adjList[u].push_back(v);
    else
      u++;
  }
}

int main() {
  int n;

  cout << "Enter the number of nodes : ";
  cin >> n;
  vector<vector<int>> adjList(n);

  addEdges(adjList);
  bfsTraversal(adjList);

  return 0;
}
