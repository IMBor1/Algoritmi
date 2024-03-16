
package org.example;

import org.example.Exceptions.FullArrayException;
import org.example.Exceptions.MyNotFoundException;
import org.example.Exceptions.NotCorrectIndexException;
import org.example.Interfaces.IntegerList;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer[] integers;
    int size;

    public IntegerListImpl() {
        this.integers = new Integer[10];
    }

    public IntegerListImpl(int size) {
        this.integers = new Integer[size];
    }

    void validateSize() {
        if (this.size == this.integers.length) {
            throw new FullArrayException();
        }
    }

    void validateIndex(int index) {
        if (this.size < 0 || this.size >= this.integers.length) {
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
        this.integers[this.size++] = item;
        return item;
    }

    public Integer add(int index, Integer item) {
        this.validateItem(item);
        this.validateSize();
        this.validateIndex(index);
        if (size == integers.length) {
            grow();
        }
        if (this.size == index) {
            this.integers[this.size++] = item;
            return item;
        } else {
            System.arraycopy(this.integers, index, this.integers, this.size + 1, this.size - (index + 1));
            this.integers[index] = item;
            ++this.size;
            return item;
        }
    }

    public Integer set(int index, Integer item) {
        this.validateItem(item);
        this.validateIndex(index);
        this.integers[index] = item;
        return item;
    }

    public Integer removeItem(Integer item) {
        this.validateItem(item);
        int index = this.indexOf(item);
        if (index == -1) {
            throw new MyNotFoundException();
        } else {
            if (index != this.size) {
                System.arraycopy(this.integers, index + 1, this.integers, index, this.size - index);
            }

            --this.size;
            return item;
        }
    }

    public Integer remove(int index) {
        this.validateIndex(index);
        Integer item = this.integers[index];
        if (index != this.size) {
            System.arraycopy(this.integers, index + 1, this.integers, index, this.size - index);
        }

        --this.size;
        return item;
    }

    public boolean contains(Integer item) {
        this.validateItem(item);
        Integer[] arrCopy = integers;
        partition(arrCopy, 0, arrCopy.length);
        return binarySearch(arrCopy, item);
    }

    public int indexOf(Integer item) {
        for (int i = 0; i <= this.integers.length - 1; ++i) {
            if (this.integers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Integer item) {
        for (int i = this.integers.length - 1; i >= 0; --i) {
            if (this.integers[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    public Integer get(int index) {
        this.validateIndex(index);

        for (int i = 0; i < this.integers.length; ++i) {
            if (i == index) {
                return this.integers[i];
            }
        }

        return null;
    }

    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    public int size() {
        return this.integers.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.size = 0;
    }

    public Integer[] toArray() {
        return (Integer[]) Arrays.copyOf(this.integers, this.size);
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

    private void grow() {
        Integer[] newIntegers = new Integer[(int) (integers.length * 1.5)];
        System.arraycopy(integers, 0, newIntegers, 0, integers.length);
        integers = newIntegers;
    }

    private static void partition(Integer[] arr, Integer begin, Integer end) {
        Integer pivot = arr[end];
        Integer i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
    }

    private static void swapElements(Integer[] arr, Integer left, Integer right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}

