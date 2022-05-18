#ifndef DOUBLY_LINKED_LIST_H
#define DOUBLY_LINKED_LIST_H

#include <stdbool.h>

typedef struct node {
    void* next;
    void* prev;
    void* value;
} node_t;

typedef struct doubly_linked_list {
    node_t* root;
} doubly_linked_list_t;

bool dll_is_empty(doubly_linked_list_t*);

unsigned int dll_count(doubly_linked_list_t*);

void dll_insert_value(doubly_linked_list_t*, char*);
void dll_delete_value(doubly_linked_list_t*, char*);
void dll_destroy(doubly_linked_list_t*);

node_t* dll_find_value(doubly_linked_list_t*, char*);
node_t* create_empty_node(char* value);

#endif
