#include <cassert>
#include "LinkedList.hpp"

int main(int argc, const char* argv[])
{
    LinkedList<int> lista;

    for (int i = 0; i < 10; i++) {
        lista.push(i);
    }

    long long index_of_seven = lista.index_of(7);
    assert(index_of_seven == 7);

    long long not_found = lista.index_of(420);
    assert(not_found == -1);

    lista.remove(index_of_seven);
    index_of_seven = lista.index_of(7);
    assert(index_of_seven == -1);

    return 0;
}
