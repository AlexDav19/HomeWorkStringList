package org.example;

import org.example.exceptions.ValidationIndexException;
import org.example.exceptions.ValidationItemNullException;
import org.example.exceptions.ValidationSizeException;

import java.util.Objects;

public class StringListImpl implements StringList {
    String[] arr;
    private int size = 0;

    StringListImpl(int length) {
        arr = new String[length];
    }

    @Override
    public String add(String item) {
        validationSize();
        validationItemNull(item);
        arr[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validationSize();
        validationItemNull(item);
        if (index >= size) {
            arr[size] = item;
        } else {
            for (int i = size; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = item;
        }
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validationSize();
        validationItemNull(item);
        if (index >= size) {
            arr[size] = item;
        } else {
            arr[index] = item;
        }
        size++;
        return item;
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(arr[i], item)) {
                for (int j = i; j < size - i; j++) {
                    arr[i] = arr[i + 1];
                }
                size--;
                arr[size] = null;
                return item;
            }
        }
        throw new ValidationItemNullException();
    }

    @Override
    public String remove(int index) {
        validationIndex(index);
        String unit = arr[index];
        for (int i = index; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        arr[size] = null;
        return unit;

    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(arr[i], item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(arr[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(arr[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validationIndex(index);
        return arr[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList.isEmpty()) {
            throw new RuntimeException();
        }
        if (size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(arr[i], otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] newList = new String[size];
        System.arraycopy(arr, 0, newList, 0, size);
        return newList;
    }

    //Увеличить количество ячеек
    public StringListImpl addNewPlace(int newLength) {
        StringListImpl newArr = new StringListImpl(newLength);
        System.arraycopy(arr, 0, newArr.arr, 0, 3);

        return newArr;
    }

    public void validationSize() {
        if (size >= arr.length) {
            throw new ValidationSizeException("В массиве больше нет места");
        }
    }

    public void validationIndex(int index) {
        if (index >= size) {
            throw new ValidationIndexException("Элемента с таким индексом нет");
        }
    }

    public void validationItemNull(String item) {
        if (item == null) {
            throw new ValidationItemNullException("Не передано значение");
        }
    }
}
