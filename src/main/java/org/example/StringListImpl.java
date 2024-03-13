package org.example;

import org.example.Exceptions.FullArrayException;
import org.example.Exceptions.MyNotFoundException;
import org.example.Exceptions.NotCorrectIndexException;
import org.example.Interfaces.StringList;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private final String[] strings;
    int size;

    public StringListImpl() {
        strings = new String[10];
    }

    public StringListImpl(int size) {
        strings = new String[size];
    }

    void validateSize() {
        if (size == strings.length) {
            throw new FullArrayException();
        }
    }

    void validateIndex(int index) {
        if (size < 0 || size >= strings.length) {
            throw new NotCorrectIndexException();
        }
    }

    void validateItem(String item) {
        if (item == null) {
            throw new NotCorrectIndexException();
        }
    }

    @Override
    public String add(String item) {
        validateItem(item);
        validateSize();
        strings[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateItem(item);
        validateSize();
        validateIndex(index);
        if (size == index) {
            strings[size++] = item;
            return item;
        }
        System.arraycopy(strings, index, strings, size + 1, size - (index + 1));
        strings[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateItem(item);
        validateIndex(index);
        strings[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new MyNotFoundException();
        }
        if (index != size) {
            System.arraycopy(strings, index + 1, strings, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = strings[index];

        if (index != size) {
            System.arraycopy(strings, index + 1, strings, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        validateItem(item);
        for (int i = 0; i <= strings.length - 1; i++) {
            if (strings[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i <= strings.length - 1; i++) {
            if (strings[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        for (int i = 0; i < strings.length; i++) {
            if (i == index) {
                return strings[i];
            }
        }
        return null;
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return strings.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(strings, size);
    }


}
