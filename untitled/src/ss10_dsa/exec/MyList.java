package ss10_dsa.exec;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    public void clear(){
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }
    public boolean add(E e){
        if (size == elements.length){
            ensureCapacity();
        }
        elements[size] = e;
        size++;
        return true;
    }
    private void ensureCapacity(){
        int newSize = elements.length*2;
        elements = Arrays.copyOf(elements, newSize);

    }
    public void add(int index, E e){
        if (index > elements.length)
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
        else if (elements.length == size)
            ensureCapacity();
        if (elements[index] != null) {
            for (int i = size; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
        }
        elements[index] = e;
        size++;
    }
    public E remove(int index){
        checkIndex(index);
        E e = (E) elements[index];
        for (int j = index; j < size - 1; j++)
            elements[j] = elements[j+1];
        elements[size -1] = null;
        size--;
        return e;
    }
    private void checkIndex(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
    }
    public int size(){
        return this.size;
    }


    public E get(int i){
        checkIndex(i);
        return (E) elements[i];
    }
    public boolean contains(E e){
        for (int i = 0; i< size; i++)
            if (e.equals(elements[i]))
                return true;
        return false;
    }
    public int indexOf(E e){
        for (int i=0; i<size; i++)
            if (e.equals(elements[i])) return i;
        return -1;
    }
    public MyList<E> clone(){
        MyList<E> a = new MyList<>();
        a.elements = Arrays.copyOf(this.elements,this.size);
        a.size = this.size;
        return a;
    }

}
