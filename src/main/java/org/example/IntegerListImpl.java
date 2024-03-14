
package org.example;

import org.example.Exceptions.FullArrayException;
import org.example.Exceptions.MyNotFoundException;
import org.example.Exceptions.NotCorrectIndexException;
import org.example.Interfaces.IntegerList;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private final Integer[] Integers;
    int size;

    public IntegerListImpl() {
        this.Integers = new Integer[10];
    }

    public IntegerListImpl(int size) {
        this.Integers = new Integer[size];
    }

    void validateSize() {
        if (this.size == this.Integers.length) {
            throw new FullArrayException();
        }
    }

    void validateIndex(int index) {
        if (this.size < 0 || this.size >= this.Integers.length) {
            throw new NotCorrectIndexException();
        }
    }

    void validateItem(Integer item) {
        if (item == null) {
            throw new NotCorrectIndexException();
        }
    }

    public Integer add(Integer item) {
        this.validateItem(item);
        this.validateSize();
        this.Integers[this.size++] = item;
        return item;
    }

    public Integer add(int index, Integer item) {
        this.validateItem(item);
        this.validateSize();
        this.validateIndex(index);
        if (this.size == index) {
            this.Integers[this.size++] = item;
            return item;
        } else {
            System.arraycopy(this.Integers, index, this.Integers, this.size + 1, this.size - (index + 1));
            this.Integers[index] = item;
            ++this.size;
            return item;
        }
    }

    public Integer set(int index, Integer item) {
        this.validateItem(item);
        this.validateIndex(index);
        this.Integers[index] = item;
        return item;
    }

    public Integer removeItem(Integer item) {
        this.validateItem(item);
        int index = this.indexOf(item);
        if (index == -1) {
            throw new MyNotFoundException();
        } else {
            if (index != this.size) {
                System.arraycopy(this.Integers, index + 1, this.Integers, index, this.size - index);
            }

            --this.size;
            return item;
        }
    }

    public Integer remove(int index) {
        this.validateIndex(index);
        Integer item = this.Integers[index];
        if (index != this.size) {
            System.arraycopy(this.Integers, index + 1, this.Integers, index, this.size - index);
        }

        --this.size;
        return item;
    }

    public boolean contains(Integer item) {
        this.validateItem(item);
        Integer[] arrCopy = toArray();
        sortInsertion(arrCopy);
        return binarySearch(arrCopy, item);
    }

    public int indexOf(Integer item) {
        for (int i = 0; i <= this.Integers.length - 1; ++i) {
            if (this.Integers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Integer item) {
        for (int i = this.Integers.length - 1; i >= 0; --i) {
            if (this.Integers[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    public Integer get(int index) {
        this.validateIndex(index);

        for (int i = 0; i < this.Integers.length; ++i) {
            if (i == index) {
                return this.Integers[i];
            }
        }

        return null;
    }

    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    public int size() {
        return this.Integers.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.size = 0;
    }

    public Integer[] toArray() {
        return (Integer[]) Arrays.copyOf(this.Integers, this.size);
    }

    private static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }

    }


    public boolean binarySearch(Integer[] arr, int item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}

