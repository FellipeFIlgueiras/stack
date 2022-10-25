package br.com.linkedlist;

public class LinkedList<T> {
    
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    public LinkedList() {
        this.firstNode = null;
        this.lastNode = null;
    }

    public void add(T element) {
        Node<T> node = new Node<>(element);
        if(isEmpty()) {
            this.firstNode = node; 
            this.lastNode = node;
        } else {
            this.lastNode.setNext(node);
            node.setPrevious(this.lastNode);
            this.lastNode = node;
        }
        this.size ++;
    }

    public void add(T element, int position) {
        if(position == 0) {
            addAtBegin(element);
        } else {
            addAtPosition(element, position);
        }
        this.size ++;
    }

    private void addAtPosition(T element, int position) {
        Node<T> node = new Node<>(element);
        Node<T> current = getNode(position);
        Node<T> previous = current.getPrevious();
        previous.setNext(node);
        node.setPrevious(previous);
        node.setNext(current);
        current.setPrevious(node);
    }

    private void addAtBegin(T element) {
        Node<T> node = new Node<>(element);
        if(!isEmpty()) {
            Node<T> first = this.firstNode;
            node.setNext(first);
            node.setPrevious(null);
            first.setPrevious(node); 
            this.firstNode = node;
        } else {
            this.firstNode = node;
        }
    }

    public void remove(int position) {
        if(position == this.size - 1) {
            removeAtEnd();
        } else if(position == 0) {
            removeAtBegin();
        } else {
            removeAt(position);
        }
        this.size --;
    }

    private void removeAt(int position) {
        Node<T> node = getNode(position);
        Node<T> previous = node.getPrevious();
        Node<T> next = node.getNext();
        previous.setNext(next);
        next.setPrevious(previous);
        node.setPrevious(null);
        node.setNext(null);
    }

    private void removeAtBegin() {
        Node<T> node = this.firstNode.getNext();
        this.firstNode.setNext(null);
        node.setPrevious(null);
        this.firstNode = node;
    }

    private void removeAtEnd() {
        Node<T> node = this.lastNode.getPrevious();
        this.lastNode.setPrevious(null);
        this.lastNode = node;
        node.setNext(null);
    }

    public int indexOf(T element) {
        for(int i = 1; i < this.size; i++) {
            Node<T> node = getNode(i);
            if(node.getElement() != null && node.getElement().equals(element)){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T element) {
        for(int i = 1; i < this.size; i++) {
            Node<T> node = getNode(i);
            if(node.getElement() != null && node.getElement().equals(element)){
                return true;
            }
        }
        return false;
    }

    public T getElement(int position) {
        Node<T> node = getNode(position);
        if(node != null) {
            return node.getElement();
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    private Node<T> getNode(int position) {
        Node<T> node = this.firstNode;
        for(int i = 1; i <= position; i++) {
            node = node.getNext();
        }
        return node;
    }

    private boolean isEmpty(){
        return this.size == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("List [");
        if(!isEmpty()) {
            Node<T> node = this.firstNode;
            builder.append(node.getElement().toString());
            while(node.getNext() != null) {
                builder.append(node.getNext().getElement().toString());
                node = node.getNext();
            }              
        }
        builder.append("]");
        return builder.toString();
    }

}
