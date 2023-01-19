#include <stdio.h>
#include <stdlib.h>

typedef struct node
{
  int data;
  struct node *l, *r;
} tree;

tree *getnode(int d)
{ // Creation of nodes
  tree *node = (tree *)malloc(sizeof(tree));
  node->l = node->r = NULL;
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

tree *insert(tree *node, int d)
{ // Insertion of nodes
  if (node == NULL)
    return getnode(d);
  else
  {
    if (d < node->data)
      node->l = insert(node->l, d);
    else if (d > node->data)
      node->r = insert(node->r, d);
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

  printf("\n Enter the number of nodes : ");
  scanf("%d", &n);

  // Insertion
  for (i = 0; i < n; i++)
  {
    printf(" Enter the data for node %d\t: ", (i + 1));
    scanf("%d", &d);
    root = insert(root, d);
  }

  // Traversal
  printf("\n Pre-order traversal :\n");
  preorder(root);
  printf("\n In-order traversal :\n");
  inorder(root);
  printf("\n Post-order traversal :\n");
  postorder(root);

  // Searching
  printf("\n Enter the value to be searched : ");
  scanf("%d", &k);
  search(root, k) == NULL
      ? printf("\n Key not found!\n")
      : printf("\n Key found : %d\n", search(root, k)->data);

  return 0;
}