package org.example;

import java.util.Objects;

public class StringListReal implements StringList {
    String[] arr;
    private int size = 0;

    StringListReal(int length) {
        arr = new String[length];
    }

    @Override
    public String add(String item) {
        if (size >= arr.length) {
            throw new RuntimeException();
        }
        arr[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (size >= arr.length) {
            throw new RuntimeException();
        }
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
        if (size >= arr.length) {
            throw new RuntimeException();
        }
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
                for (int j = i; j < size; j++) {
                    arr[i] = arr[i + 1];
                }
                size--;
                return item;
            }
        }
        throw new RuntimeException();
    }

    @Override
    public String remove(int index) {
        if (index >= size) {
            throw new RuntimeException();
        } else {
            String unit = arr[index];
            for (int i = index; i < size; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
            return unit;
        }
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
        if (index >= size) {
            throw new RuntimeException();
        }
        return arr[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList.size() == 0) {
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
        if (size == 0) {
            return true;
        }
        return false;
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
        for (int i = 0; i < size; i++) {
            newList[i] = arr[i];
        }
        return newList;
    }

}
