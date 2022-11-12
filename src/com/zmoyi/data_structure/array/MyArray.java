package com.zmoyi.data_structure.array;

public class MyArray {

    int[] array;

    int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    /**
     * 插入元素
     * @param index
     * @param element
     */
    public void insert(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数据下标超限");
        }

        // 扩容操作
        if (size >= array.length) {
            resize();
        }

        // 从右向左右移一位
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = element;
        size++;
    }

    /**
     * 扩容操作
     */
    public void resize() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    /**
     * 删除元素
     * @param index
     * @return
     */
    public Integer delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数据下标超限");
        }
        int deletedElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return deletedElement;
    }

    /**
     * 打印数组
     */
    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(10);
        myArray.insert(0,1);
        myArray.insert(1, 7);
        myArray.insert(2, 9);
        myArray.insert(3, 5);
        myArray.insert(1, 6);
        myArray.output();

        System.out.println("---");
        myArray.delete(0);
        myArray.output();
    }
}
