// Program to create a Singly linked list and perform insertion and deletion operations in all cases
#include <stdio.h>
// #include<stdio.h>
#include <stdlib.h>

typedef struct singly_linked_list
{
    int data;
    struct singly_linked_list *next;
} node;

node *start = NULL;

node *getnode()
{
    int d;
    node *new_node = (node *)malloc(sizeof(node));
    printf("\n\nEnter the value to be inserted : ");
    scanf("%d", &new_node->data);
    new_node->next = NULL;
    return new_node;
}

node *create(node *start)
{
    int ch = 1;
    node *temp, *new_node;
    printf("\n\nEnter the data for each node ...");
    while (ch)
    {
        if (start == NULL)
        {
            new_node = getnode();
            start = new_node;
        }
        else
        {
            temp = start;
            while (temp->next != NULL)
                temp = temp->next;
            new_node = getnode();
            temp->next = new_node;
        }
        printf("\nMore nodes? (0/1)\t");
        scanf("%d", &ch);
    }
    return start;
}

node *display(node *start)
{
    node *temp = start;
    printf("\n\nStatus of the linked list : \n");
    while (temp != NULL)
    {
        printf("%d => ", temp->data);
        temp = temp->next;
    }
    printf("NULL");
    return start;
}

node *ins_beg(node *start)
{
    node *new_node = getnode();
    new_node->next = start;
    start = new_node;
    return start;
}

node *ins_end(node *start)
{
    node *temp = start;
    node *new_node = getnode();
    while (temp->next != NULL)
        temp = temp->next;
    temp->next = new_node;
    return start;
}

node *ins_before(node *start)
{
    int val;
    printf("\nEnter the value before which the data is to be inserted : ");
    scanf("%d", &val);
    node *temp, *prev, *new_node;
    temp = prev = start;
    while (temp->data != val)
    {
        prev = temp;
        temp = temp->next;
    }
    new_node = getnode();
    prev->next = new_node;
    new_node->next = temp;
    return start;
}

node *ins_after(node *start)
{
    int val;
    printf("\nEnter the value after which the data is to be inserted : ");
    scanf("%d", &val);
    node *temp, *new_node;
    temp = start;
    while (temp->data != val)
    {
        temp = temp->next;
    }
    new_node = getnode();
    new_node->next = temp->next;
    temp->next = new_node;
    return start;
}

node *del_beg(node *start)
{
    node *temp = start;
    start = start->next;
    free(temp);
    return start;
}

node *del_end(node *start)
{
    node *temp = start;
    node *prev;
    while (temp->next != NULL)
    {
        prev = temp;
        temp = temp->next;
    }
    prev->next = NULL;
    free(temp);
    return start;
}

node *del_node(node *start)
{
    int val;
    printf("\nEnter the value of the node to be deleted : ");
    scanf("%d", &val);
    node *temp, *prev;
    prev = temp = start;
    while (temp->data != val)
    {
        prev = temp;
        temp = temp->next;
    }
    prev->next = temp->next;
    free(temp);
    return start;
}

node *del_after(node *start)
{
    int val;
    printf("\nEnter the value after which the data is to be deleted : ");
    scanf("%d", &val);
    node *prev, *temp;
    prev = temp = start;
    while (prev->data != val)
    {
        prev = temp;
        temp = temp->next;
    }
    prev->next = temp->next;
    free(temp);
    return start;
}

int main()
{
    int option;
    // clrscr();
    do
    {
        printf("\n\n-------------MAIN MENU-------------");
        printf("\n 1. Create");
        printf("\n 2. Display");
        printf("\n 3. Insert at beginning");
        printf("\n 4. Insert at end");
        printf("\n 5. Insert before a given element");
        printf("\n 6. Insert after a given element");
        printf("\n 7. Delete at beginning");
        printf("\n 8. Delete at end");
        printf("\n 9. Delete at intermediate position");
        printf("\n 10. Delete after a given element");
        printf("\n 11. EXIT");
        printf("\n-----------------------------------");
        printf("\nEnter your choice of operation : ");
        scanf("%d", &option);
        switch (option)
        {
        case 1:
            start = create(start);
            printf("\nSingly Linked List created successfully!");
            break;

        case 2:
            start = display(start);
            break;

        case 3:
            start = ins_beg(start);
            printf("\nNode inserted at the beginning!");
            break;

        case 4:
            start = ins_end(start);
            printf("\nNode inserted at the end!");
            break;

        case 5:
            start = ins_before(start);
            printf("\nNode inserted successfully!");
            break;

        case 6:
            start = ins_after(start);
            printf("\nNode inserted successfully!");
            break;

        case 7:
            start = del_beg(start);
            printf("\nNode deleted successfully!");
            break;

        case 8:
            start = del_end(start);
            printf("\nNode deleted successfully!");
            break;

        case 9:
            start = del_node(start);
            printf("\nNode deleted successfully!");
            break;

        case 10:
            start = del_after(start);
            printf("\nNode deleted successfully!");
            break;
        }
    } while (option != 11);
    // getch();
    return 0;
}