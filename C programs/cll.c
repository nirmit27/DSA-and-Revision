// Program to create a circular linked list and perform insertions and deletions in all cases
#include <stdio.h>
// #include<conio.h>
#include <stdlib.h>

typedef struct node
{
    int data;
    struct node *next;
} cll;

cll *start = NULL;

// Create a new node
cll *getnode()
{
    cll *node = (cll *)malloc(sizeof(cll));
    printf("\nEnter the data to be inserted : ");
    scanf("%d", &(node->data));
    node->next = NULL;
}

// Create a new list
cll *create_cll(cll *start)
{
    int num;
    cll *new = getnode(), *temp;
    
    return start;
}

// Display the list
cll *display(cll *start)
{

    return start;
}

// Insertion at the beginning
cll *insert_beg(cll *start)
{

    return start;
}

// Insertion at the end
cll *insert_end(cll *start)
{

    return start;
}

// Deletion from the beginning
cll *delete_beg(cll *start)
{

    return start;
}

// Deletion from the end
cll *delete__end(cll *start)
{

    return start;
}

// Deletion after a given node
cll *delete_after(cll *start)
{

    return start;
}

// Deleting the entire linked list!!!
cll *delete_list(cll *start)
{

    return start;
}

// Driver program
int main(int argc, char const *argv[])
{
    int option;
    // clrscr();
    do
    {
        printf("\n\n----------------MAIN MENU----------------");
        printf("\n 1. Create a list");
        printf("\n 2. Display the list");
        printf("\n 3. Add a node at the beginning");
        printf("\n 4. Add a node at the end");
        printf("\n 5. Delete a node from the beginning");
        printf("\n 6. Delete a node from the end");
        printf("\n 7. Delete a node after a given node");
        printf("\n 8.Delete the entire list\n");
        printf("\n 9. EXIT");
        printf("\n-------------------------------------------");
        printf("\nEnter your option : ");
        scanf("%d", &option);

        switch (option)
        {
        case 1:
            start = create_cll(start);
            printf("\nCircular Linked List CREATED!");
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
            start = delete_beg(start);
            printf("\nNode deleted successfully!\n");
            break;
        case 6:
            start = delete_end(start);
            printf("\nNode deleted successfully!\n");
            break;
        case 7:
            start = delete_after(start);
            printf("\nNode deleted successfully!\n");
            break;
        case 8:
            start = delete_list(start);
            printf("\n Doubly Linked List DELETED!");
        }
    } while (option != 9);
    // getch();
    return 0;
}