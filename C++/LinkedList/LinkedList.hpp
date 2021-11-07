#ifndef LINKED_LIST_H
#define LINKED_LIST_H

#include "Node.hpp"
#include <cstddef>

template <class T> class LinkedList {
private:
  Node<T> *root;
  std::size_t size;

public:
  LinkedList();
  ~LinkedList();

  void push(T value);
  void remove(std::size_t index);
  long long index_of(T value);
};

template <class T> LinkedList<T>::LinkedList() : root(nullptr), size(0) {}

template <class T> LinkedList<T>::~LinkedList() {
  Node<T> *current = root;
  while (current != nullptr) {
    Node<T> *last = current;
    current = current->get_next();
    delete last;
  }
}

template <class T> void LinkedList<T>::push(T value) {
  if (this->root == nullptr) {
    this->root = new Node<T>(value);
  } else {
    Node<T> *cursor = this->root;
    Node<T> *last = cursor;
    while (cursor != nullptr) {
      last = cursor;
      cursor = cursor->get_next();
    }

    Node<T> *next = new Node<T>(value);
    last->set_next(next);
  }

  this->size++;
}

template <class T> void LinkedList<T>::remove(std::size_t index) {
  if (index > this->size)
    return;

  Node<T> *cursor = root;
  Node<T> *last = nullptr;

  while (index > 0) {
    last = cursor;
    cursor = cursor->get_next();
    --index;
  }

  Node<T> *next = cursor->get_next();
  last->set_next(next);
  delete cursor;
  this->size--;
}

template <class T> long long LinkedList<T>::index_of(T value) {
  Node<T> *node = root;
  size_t index = 0;
  bool found = false;

  do {
    if (node->get_value() == value) {
      found = true;
      break;
    }

    index++;
    node = node->get_next();
  } while (node != nullptr);

  return found ? index : -1;
}

#endif // LINKED_LIST_H
