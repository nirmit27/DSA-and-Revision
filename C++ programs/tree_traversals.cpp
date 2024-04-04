#include <bits/stdc++.h>
using namespace std;

class Node {
public:
  int value;
  Node *left;
  Node *right;

  Node(int data) : value(data), left((Node *)NULL), right((Node *)NULL){};
};

void postOrderTraversal(Node *root) {
  //
}

void preOrderTraversal(Node *root) {
  //
}

void inOrderTraversal(Node *root) {
  //
}

void levelOrderTraversal(Node *root) {
  queue<Node *> q;
  q.push(root);
  q.push(NULL);

  while (!q.empty()) {
    Node *temp = q.front();
    q.pop();

    if (temp == NULL) {
      cout << endl;

      if (!q.empty())
        q.push(NULL);
    }

    else {
      cout << temp->value << " ";

      if (temp->left)
        q.push(temp->left);

      if (temp->right)
        q.push(temp->right);
    }
  }
}

Node *buildTree(Node *root) {
  int d;
  cout << endl << "Enter the data for node : ";
  cin >> d;

  root = new Node(d);

  if (d == -1)
    return NULL;

  cout << endl << "Enter data for LEFT sub-tree to node " << d << " :" << endl;
  root->left = buildTree(root->left);

  cout << endl << "Enter data for RIGHT sub-tree to node " << d << " :" << endl;
  root->right = buildTree(root->right);

  return root;
}

int main() {
  Node *root = NULL;

  // 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
  cout << endl << "Building the Tree ... (enter -1 to stop)" << endl;
  root = buildTree(root);

  cout << endl << endl << "Level Order Traversal ..." << endl << endl;
  levelOrderTraversal(root);

  // cout << endl << endl << "In-order Traversal ..." << endl << endl;
  // inOrderTraversal(root);

  // cout << endl << endl << "Pre-order Traversal ..." << endl << endl;
  // preOrderTraversal(root);

  // cout << endl << endl << "Post-order Traversal ..." << endl << endl;
  // postOrderTraversal(root);

  return 0;
}
