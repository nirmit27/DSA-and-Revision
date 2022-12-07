#include <stdio.h>
// #include<conio.h>
#include <stdlib.h>

typedef struct node
{
    int data;
    struct node *next;
} cll;

cll *start = NULL;

cll *getnode()
{
    cll *node = (cll *)malloc(sizeof(cll));
    printf("\nEnter the data to be inserted : ");
    scanf("%d", &(node->data));
    node->next = NULL;
}

cll *create_cll(cll *start)
{
    int num;
    cll *new_node, *temp;
    printf("\nEnter 0 to stop.");
    while (num)
    {
        new_node = getnode();
        if (start == NULL)
        {
            new_node->next = new_node;
            start = new_node;
        }
        else
        {
            temp = start;
            while (temp->next != start)
                temp = temp->next;
            temp->next = new_node;
            new_node->next = start;
        }
        printf("More nodes? (0/1) : ");
        scanf("%d", &num);
    }
    return start;
}

cll *display(cll *start)
{
    cll *temp = start;
    while (temp->next != start)
    {
        printf(" %d =>", temp->data);
        temp = temp->next;
    }
    printf(" %d => NULL", temp->data);
    return start;
}

cll *insert_beg(cll *start)
{
    cll *temp = start;
    cll *new_node = getnode();
    while (temp->next != start)
        temp = temp->next;
    temp->next = new_node;
    new_node->next = start;
    start = new_node;
    return start;
}

cll *insert_end(cll *start)
{
    cll *temp = start;
    cll *new_node = getnode();
    while (temp->next != start)
        temp = temp->next;
    temp->next = new_node;
    new_node->next = start;
    return start;
}

cll *delete_beg(cll *start)
{
    cll *temp = start;
    while (temp->next != start)
        temp = temp->next;
    temp->next = start->next;
    free(start);
    start = temp->next;
    return start;
}

cll *delete_end(cll *start)
{
    cll *temp, *prev;
    temp = prev = start;
    while (temp->next != start)
    {
        prev = temp;
        temp = temp->next;
    }
    prev->next = temp->next;
    free(temp);
    return start;
}

cll *delete_after(cll *start)
{
    int val;
    cll *temp, *prev;
    temp = prev = start;
    printf("\nEnter the value after which the node is to be deleted... ");
    scanf("%d", &val);
    while (prev->data != val)
    {
        prev = temp;
        temp = temp->next;
    }
    prev->next = temp->next;
    if (temp == start)
        start = prev->next;
    free(temp);
    return start;
}

cll *delete_list(cll *start)
{
    cll *temp = start;
    while (temp->next != start)
        start = delete_end(start);
    free(start);
    return start;
}

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
        printf("\n 8. Delete the entire list");
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