#include <bits/stdc++.h>
using namespace std;

class Node
{
public:
  int value;
  Node *left;
  Node *right;

  Node() : value(0), left((Node *)NULL), right((Node *)NULL) {}
  Node(int data) : value(data), left((Node *)NULL), right((Node *)NULL) {}
  Node(int data, Node *leftNode, Node *rightNode)
      : value(data), left(leftNode), right(rightNode) {}
};

Node *buildTree(Node *root)
{
  int d;
  cout << endl
       << "Enter the data for node : ";
  cin >> d;

  root = new Node(d);

  if (d == -1)
    return NULL;

  cout << endl
       << "Enter data for LEFT sub-tree to node " << d << " :" << endl;
  root->left = buildTree(root->left);

  cout << endl
       << "Enter data for RIGHT sub-tree to node " << d << " :" << endl;
  root->right = buildTree(root->right);

  return root;
}

void postOrderTraversal(Node *root)
{
  if (!root)
    return;

  postOrderTraversal(root->left);
  postOrderTraversal(root->right);
  cout << root->value << " ";
}

void preOrderTraversal(Node *root)
{
  if (!root)
    return;

  cout << root->value << " ";
  postOrderTraversal(root->left);
  postOrderTraversal(root->right);
}

void inOrderTraversal(Node *root)
{
  if (!root)
    return;

  inOrderTraversal(root->left);
  cout << root->value << " ";
  inOrderTraversal(root->right);
}

void levelOrderTraversal(Node *root)
{
  queue<Node *> q;
  q.push(root);
  q.push(NULL);

  while (!q.empty())
  {
    Node *temp = q.front();
    q.pop();

    if (temp == NULL)
    {
      cout << endl;

      if (!q.empty())
        q.push(NULL);
    }

    else
    {
      cout << temp->value << " ";

      if (temp->left)
        q.push(temp->left);

      if (temp->right)
        q.push(temp->right);
    }
  }
}

int main()
{
  int ch;
  Node *root = NULL;

  // 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
  cout << endl
       << "Building the Tree ... (enter -1 to stop)" << endl;
  root = buildTree(root);

  cout << endl
       << endl
       << "Traversal Menu :\n\n1) Level-Order Traversal\n2) In-Order "
          "Traversal\n3) Pre-Order Traversal\n4) Post-Order Traversal"
       << endl
       << endl
       << "Enter your choice : ";
  cin >> ch;

  switch (ch)
  {
  case 1:
    cout << endl
         << endl
         << "Level Order Traversal ..." << endl
         << endl;
    levelOrderTraversal(root);
    break;
  case 2:
    cout << endl
         << endl
         << "In-order Traversal ..." << endl
         << endl;
    inOrderTraversal(root);
    break;
  case 3:
    cout << endl
         << endl
         << "Pre-order Traversal ..." << endl
         << endl;
    preOrderTraversal(root);
    break;
  case 4:
    cout << endl
         << endl
         << "Post-order Traversal ..." << endl
         << endl;
    postOrderTraversal(root);
    break;
  default:
    cout << endl
         << endl
         << "Wrong choice!" << endl
         << endl;
  }

  return 0;
}
