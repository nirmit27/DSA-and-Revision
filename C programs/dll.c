// Program to create a doubly linked list and perform insertions and deletions in all cases
#include <stdio.h>
// #include<conio.h>
#include <stdlib.h>

typedef struct node
{
    struct node *next;
    int data;
    struct node *prev;
} dll;

dll *start = NULL; // initialising the start pointer under global scope

// Creating a node
dll *getnode()
{
    dll *node = (dll *)malloc(sizeof(dll));
    printf("Enter the data to be inserted : ");
    scanf("%d", &node->data);
    node->prev = NULL;
    node->next = NULL;
    return node;
}

// Creating a linked list
dll *create_l1(dll *start)
{
    int num;
    dll *temp, *new;
    while (num != -1)
    {
        if (start == NULL)
        {
            new = getnode();
            start = new;
        }
        else
        { // insertion at the end goin' on over here
            temp = start;
            while (temp->next != NULL)
                temp = temp->next;
            new = getnode();
            temp->next = new;
            new->prev = temp;
        }
        printf("Enter -1 to stop and any other character to continue...\t");
        scanf("%d", &num);
    }
    return start;
}

// Displaying the linked list
dll *display(dll *start)
{
    int ch;
    dll *temp = start;
    printf("\nDisplay : \nLeft to right - 1\nRight to left - 2\n");
    scanf("%d", &ch);
    printf("\nLinked List status : \n");
    if (ch == 1)
    {
        while (temp != NULL)
        {
            printf(" %d=>", temp->data);
            temp = temp->next;
        }
        printf(" NULL");
    }
    else if (ch == 2)
    {
        while (temp->next != NULL) // traversing upto the last node
            temp = temp->next;
        while (temp != NULL)
        {
            printf(" %d=>", temp->data);
            temp = temp->prev;
        }
        printf(" NULL");
    }
    return start;
}

// Insertion at the beginning
dll *insert_beg(dll *start)
{
    dll *new = getnode();
    start->prev = new;
    new->next = start;
    start = new;
    return start;
}

// Insertion at the end
dll *insert_end(dll *start)
{
    dll *temp = start;
    dll *new = getnode();
    while (temp->next != NULL)
        temp = temp->next;
    temp->next = new;
    new->prev = temp;
    return start;
}

// Insertion before a given node
dll *insert_before(dll *start)
{
    int x, val;
    dll *temp = start;
    dll *new = getnode();
    printf("\nEnter the value before which the data is to inserted...\n");
    scanf("%d", &val);
    while (temp->data != val)
        temp = temp->next;
    temp->prev->next = new;
    new->prev = temp->prev;
    new->next = temp;
    temp->prev = new;
    return start;
}

// Insertion after a given node
dll *insert_after(dll *start)
{
    int val;
    dll *temp = start;
    dll *new = getnode();
    printf("\nEnter the value after which the data is to be inserted...\t");
    scanf("%d", &val);
    while (temp->data != val)
        temp = temp->next;
    temp->next->prev = new;
    new->next = temp->next;
    new->prev = temp;
    temp->next = new;
    return start;
}

// Deletion from the beginning
dll *delete_beg(dll *start)
{
    dll *temp = start;
    start = start->next;
    start->prev = NULL;
    free(temp);
    return start;
}

// Deletion from the end
dll *delete_end(dll *start)
{
    dll *temp = start;
    while (temp->next != NULL)
        temp = temp->next;
    temp->prev->next = NULL;
    free(temp);
    return start;
}

// Deleting a node before a given node
dll *delete_before(dll *start)
{
    dll *temp = start, *ptr;
    int val;
    printf("Enter the value before which the data has to be deleted...\t");
    scanf("%d", &val);
    while (temp->data != val)
        temp = temp->next;
    ptr = temp->prev;
    if (ptr == start)
        start = delete_beg(start);
    else
    {
        temp->prev = ptr->prev;
        ptr->prev->next = temp;
    }
    free(ptr);
    return start;
}

// Deleting a node after a given node
dll *delete_after(dll *start)
{
    dll *temp = start, *ptr;
    int val;
    printf("Enter the value after which the data has to be deleted...\t");
    scanf("%d", &val);
    while (temp->data != val)
        temp = temp->next;
    ptr = temp->next;
    temp->next = ptr->next;
    ptr->next->prev = temp;
    free(ptr);
    return start;
}

// Deleting the entire list!!!
dll *delete_list(dll *start)
{
    dll *temp = start;
    while(start){
        start = start->next;
        free(temp);
        temp = start;
    }
    return temp;
}

// Driver program
int main(int argc, char const *argv[])
{
    int option;
    // clrscr();
    do
    {
        printf("\n\n----------------MAIN MENU----------------");
        printf("\n 1.  Create a list");
        printf("\n 2.  Display the list");
        printf("\n 3.  Add a node at the beginning");
        printf("\n 4.  Add a node at the end");
        printf("\n 5.  Add a node before a given node");
        printf("\n 6.  Add a node after a given node");
        printf("\n 7.  Delete a node from the beginning");
        printf("\n 8.  Delete a node from the end");
        printf("\n 9.  Delete a node before a given node");
        printf("\n 10. Delete a node after a given node");
        printf("\n 11. Delete the entire list");
        printf("\n 12. EXIT");
        printf("\n-----------------------------------------");
        printf("\nEnter your option : ");
        scanf("%d", &option);

        switch (option)
        {
        case 1:
            start = create_l1(start);
            printf("\nDoubly Linked List CREATED!");
            break;
        case 2:
            start = display(start);
            break;
        case 3:
            start = insert_beg(start);
            printf("\nNode inserted successfully!\n");
            break;
        case 4:
            start = insert_end(start);
            printf("\nNode inserted successfully!\n");
            break;
        case 5:
            start = insert_before(start);
            printf("\nNode inserted successfully!\n");
            break;
        case 6:
            start = insert_after(start);
            printf("\nNode inserted successfully!\n");
            break;
        case 7:
            start = delete_beg(start);
            printf("\nNode deleted successfully!\n");
            break;
        case 8:
            start = delete_end(start);
            printf("\nNode deleted successfully!\n");
            break;
        case 9:
            start = delete_before(start);
            printf("\nNode deleted successfully!\n");
            break;
        case 10:
            start = delete_after(start);
            printf("\nNode deleted successfully!\n");
            break;
        case 11:
            start = delete_list(start);
            printf("\n Doubly Linked List DELETED!");
        }
    } while (option != 12);
    // getch();
    return 0;
}