package B6_CTDLvaGTCoBan.BT.ArrayList;

import java.util.Arrays;

public class MyList<E>  {
    //số lượng phần tử có trong MyList
    private int size = 0;
    //Sức chứa của MyList
    static final int DEFAULT_CAPACITY = 10;
    //Mảng chứa các phần tử
    public Object elements[];
    //sức chứa mặc định khi khởi tạo bằng constructor không tham số
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    //sức chứa với tham số capacity
    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        }else
            throw new IllegalArgumentException("capacity: " + capacity);
    }
    //phương thức trả về số lượng phần tử
    public int size() {
        return this.size;
    }
    //phương thức clear 1 ArrayList
    public void clear() {
        size=0;
        for (int i = 0; i < elements.length; i++) {
            elements[i]=null;
        }
    }
    //phương thức thêm 1 đối tượng vào
    public boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapacity(24);
        }
        elements[size]=element;
        size++;
        return true;
    }
    //Phương thức tăng kích thước mảng với tham số nhập vào
    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = elements.length+minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        }else{
            throw new IllegalArgumentException("minCapacity: " + minCapacity);
        }
    }
    //Phương thức thêm vào phần thứ thứ index,giá trị element.
    public void add(int index, E element) {
        if (index>elements.length||index<0) {
            throw new IllegalArgumentException("index: " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(24);
        }
        if (elements[index] == null) {
            elements[index] = element;
            size++;
        }else{
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;

        }
    }
    //Phương thức lấy 1 giá trị 1 phần tử tại vị trí index
    public E get(int index) {
        return (E) elements[index];
    }

    //Phương thức tìm kiếm 1 giá trị nhập vào,trả về vị trí nếu giá trị tồn tại,trả về -1 nếu giá trị không tồn tại
    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return index;
    }
    //Phương thức tìm kiếm 1 giá trị nhập vào,trả về true nếu giá trị tồn tại và trả về false nếu giá trị không tồn tại
    boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }

    //Tạo ra bản sao của Arraylist hiện tại
    public MyList<E> clone() {
        MyList<E> v = new MyList<>();
        v.elements = Arrays.copyOf(this.elements,this.size);
        v.size = this.size;
        return v;
    }

    //Xóa 1 giá trị nhập vào tại vị trí index
    public E remove(int index) {
        if (index < 0 || index > elements.length) {
            throw new IllegalArgumentException("index: " + index);
        }else{
            E element = (E) elements[index];
            for (int i = index; i < size - 1;i++) {
                elements[i]=elements[i+1];
            }
            elements[size - 1] = null;
            size--;
            return element;
        }
    }

}


