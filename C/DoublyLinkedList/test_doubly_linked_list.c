#include "doubly_linked_list.h"

#include <stdlib.h>
#include <assert.h>
#include <stdio.h>

int main(void)
{
    doubly_linked_list_t* list = (doubly_linked_list_t*)calloc(1, sizeof(doubly_linked_list_t));

    dll_insert_value(list, "alvaro");
    dll_insert_value(list, "antonio");
    dll_insert_value(list, "carlos");
    dll_insert_value(list, "daniela");

    printf("ddl count: %d\n", dll_count(list));

    bool found_carlos = dll_find_value(list, "carlos");
    assert(found_carlos == true);

    bool found_javier = dll_find_value(list, "javier");
    assert(found_javier == false);

    dll_delete_value(list, "carlos");
    found_carlos = dll_find_value(list, "carlos");
    assert(found_carlos == false);

    unsigned int count_after_carlos_delete = dll_count(list);
    printf("count after carlos delete: %d\n", count_after_carlos_delete);
    assert(count_after_carlos_delete == 3);

    bool empty = dll_is_empty(list);
    assert(empty == false);

    dll_destroy(list);

    printf("ddl count after destroy: %d\n", dll_count(list));

    empty = dll_is_empty(list);
    assert(empty == true);

    return 0;
}
