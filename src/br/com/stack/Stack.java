package br.com.stack;

import java.util.LinkedList;

public class Stack<T> {
    
    private LinkedList<T> elements;

    public Stack() {
        this.elements = new LinkedList<>();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T get() {
        return this.elements.getLast();
    }

    public void remove() {
        this.elements.removeLast();
    }

}
