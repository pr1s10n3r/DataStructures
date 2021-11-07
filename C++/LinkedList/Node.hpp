#ifndef NODE_H
#define NODE_H

template <class T> class Node {
private:
  T value;
  Node<T> *next;

public:
  Node(T value);

  inline void set_value(T value) { this->value = value; };
  inline void set_next(Node<T> *next) { this->next = next; };

  inline T get_value() { return value; }
  inline Node<T> *get_next() { return next; }
};

template <typename T> Node<T>::Node(T value) : value(value), next(nullptr) {}

#endif // NODE_H
