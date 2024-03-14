package org.example.Interfaces;

public interface IntegerList {
    Integer add(Integer Integer);

    Integer add(int index, Integer item);

    Integer set(int index, Integer item);

    Integer removeItem(Integer item);

    Integer remove(int index);

    boolean contains(Integer item);

    int indexOf(Integer item);

    int lastIndexOf(Integer item);

    Integer get(int index);

    boolean equals(IntegerList otherList);

    int size();

    boolean isEmpty();

    void clear();

    Integer[] toArray();
}
