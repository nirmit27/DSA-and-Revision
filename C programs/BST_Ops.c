#include <stdio.h>
#include <stdlib.h>

typedef struct node
{
  int data, index;
  struct node *l, *r;
} tree;

tree *getnode(int d, int i)
{ // Creation of nodes
  tree *node = (tree *)malloc(sizeof(tree));
  node->l = node->r = NULL;
  node->index = i;
  node->data = d;
  return node;
}

void preorder(tree *root)
{ // Pre-order Travsersal
  if (root != NULL)
  {
    printf("\t%d\n", root->data);
    preorder(root->l);
    preorder(root->r);
  }
}

void inorder(tree *root)
{ // In-order Traversal
  if (root != NULL)
  {
    inorder(root->l);             // left sub-tree
    printf("\t%d\n", root->data); // root node
    inorder(root->r);             // right sub-tree
  }
}

void postorder(tree *root)
{ // Post-order Traversal
  if (root != NULL)
  {
    postorder(root->l);
    postorder(root->r);
    printf("\t%d\n", root->data);
  }
}

tree *insert(tree *node, int d, int i)
{ // Insertion of nodes
  if (node == NULL)
    return getnode(d, i);
  else
  {
    if (d < node->data)
      node->l = insert(node->l, d, i);
    else if (d > node->data)
      node->r = insert(node->r, d, i);
  }
  return node;
}

tree *search(tree *root, int key)
{ // Recursive Search
  if (root != NULL)
  {
    if (root->data == key)
      return root;
    else if (root->data > key)
      return search(root->l, key); // for smaller key, search in left ST
    else
      return search(root->r, key); // for larger key, search in right ST
  }
  else
    return NULL;
}

int main()
{ // Driver
  int d, n, i, k;
  tree *root = NULL; // Root node

  printf("\n Binary Search Tree Operations - \n");
  printf("\n Enter the number of nodes : ");
  scanf("%d", &n);

  // Insertion
  printf("\n");
  for (i = 0; i < n; i++)
  {
    printf(" Enter the data for node %d : ", (i + 1));
    scanf("%d", &d);
    root = insert(root, d, (i + 1));
  }

  // Traversal
  printf("\n Pre-order traversal :\n");
  preorder(root);
  printf("\n In-order traversal :\n");
  inorder(root);
  printf("\n Post-order traversal :\n");
  postorder(root);

  // Searching
  printf("\n Enter the key to be searched : ");
  scanf("%d", &k);
  root = search(root, k);
  root == NULL
      ? printf("\n Key not found!\n\n")
      : printf("\n Key found at node %d : %d\n\n", root->index, root->data);

  return 0;
}