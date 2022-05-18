#include "doubly_linked_list.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

unsigned int dll_count(doubly_linked_list_t* list)
{
    unsigned int count = 0;

    node_t* idx = list->root;
    while (idx != NULL) {
        ++count;
        idx = idx->next;
    }

    return count;
}

bool dll_is_empty(doubly_linked_list_t* list)
{
    printf("address of root = %p\n", list);
    if (list->root == NULL) {
        printf("root es nulo\n");
    } else {
        printf("value of root:");
        printf("%s\n", (char*)list->root->value);
    }
    return list->root == NULL;
}

node_t* create_empty_node(char* value)
{
    node_t* node = (node_t*)calloc(1, sizeof(node_t));
    node->next = node->prev = NULL;
    node->value = value;
    return node;
}

void dll_insert_value(doubly_linked_list_t* list, char* value)
{
    if (list == NULL)
        return;

    if (list->root == NULL) {
        list->root = create_empty_node(value);
    } else {
        node_t* idx = list->root;
        node_t* prev = NULL;

        while (idx != NULL) {
            prev = idx;
            idx = idx->next;
        }

        node_t* node = create_empty_node(value);
        node->prev = prev;
        node->next = NULL;

        prev->next = node;
    }
}

node_t* dll_find_value(doubly_linked_list_t* list, char* value)
{
    if (dll_is_empty(list))
        return NULL;

    node_t* idx = list->root;
    while (idx != NULL) {
        if (strcmp(idx->value, value) == 0)
            return idx;
        idx = idx->next;
    }

    return NULL;
}

void dll_destroy(doubly_linked_list_t* list)
{
    if (list == NULL)
        return;

    node_t* node = list->root;
    while (node != NULL) {
        dll_delete_value(list, node->value);
    }

    free(list);
    list = NULL;
}

void dll_delete_value(doubly_linked_list_t* list, char* value)
{
    if (dll_is_empty(list))
        return;

    node_t* node = dll_find_value(list, value);
    if (node == NULL)
        return;

    node_t* prev = node->prev;
    node_t* next = node->next;

    prev->next = next;
    next->prev = prev;

    free(node);
}
