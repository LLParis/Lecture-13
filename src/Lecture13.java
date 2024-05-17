import java.util.*;

public class Lecture13 {
    private static int[] elementData;
    private static int size;

    public static void main(String[] args) {
        System.out.println("Hello from lecture 13");

        // Self-Check Problems:
        // Section 15.1: Simple ArrayIntList

        // 1. What is the difference between an array list’s size and its capacity?
        // What is the relationship between the two values? (Is one always larger or
        // smaller than the other, for instance?)
        // Its size is how many elements are currently stored in the array list.
        // The capacity is the number of elements the array list can hold before resizing.
        // Size <= Capacity

        // 2. What fields must be included in the ArrayIntList class, and why is each
        // field important? Would the class still work correctly if we removed any of
        // these fields?
        // The fields that must be included in the ArrayIntList class are an array and size variable.
        // The array holds the elements of the list while the size keeps track of how many elements are
        // currently in the list.
        // By removing the array, we remove our entire storage device causing the class to work incorrectly.
        // Without size, we won't know how many elements are stored causing resizing issues.

        // 3. Why does the list class use a toString method rather than a print method?
        // toString is applicable to multiple use cases whereas printing limits to printing to console.
        // You can also modify the way toString displays your information.

        // 4. We wrote the class to have public methods called size (to read the number
        // of elements of the list) and get (to access the element value at a specific
        // index).
        // Why is this approach better than declaring the fields (such as size) public?
        // This approach introduces encapsulation where you can control the internal state without
        // needing to change every piece of code that accesses the field

        // 7. An element can be inserted at the beginning, middle, or end of an array
        // list.
        // Which of the three insertion points is the most computationally expensive,
        // and why? Which is the most expensive location to remove an element from the
        // list?
        // The beginning is the most computationally expensive because you have to shift n elements.

        // 8. Write methods called min and max that return the smallest and largest
        // values in the list respectively.
        // For example, if a variable called list stores [11, –7, 3, 42, 0, 14], the
        // call of list.min() should return –7 and the call of list.max() should return
        // 42. If the list is empty, the methods should throw an IllegalStateException.
        ArrayIntList list = new ArrayIntList(10);
        list.add(11);
        list.add(-7);
        list.add(3);
        list.add(42);
        list.add(0);
        list.add(14);

        System.out.println("Min: " + list.min()); // Should print -7
        System.out.println("Max: " + list.max()); // Should print 42


        // Section 15.2: A More Complete ArrayIntList

        // 9. Describe the overall preconditions placed on the list class in this
        // section.
        // What assumptions do we make about how clients will use the list?
        // The preconditions are: Initial Capacity, Index Bounds, Non-Empty list, add.
        // We assume the client will initialize the ArrayIntList with more thn zero capacity.
        // The index you try to reach will be in bounds
        // The list is not empty
        // Clients will use add to insert elements into the list.

        // 10. What is the purpose of the checkIndex method?
        // Where is it called in the list class? Describe a way that the client can
        // utilize an ArrayIntList that will be caught by checkIndex.

        // 11. What is the purpose of the checkCapacity method?
        // Where is it called in the list class? Describe a way that the client can
        // utilize an ArrayIntList that will be caught by checkCapacity.

        // 12. Once we check thoroughly for preconditions in the code, what data
        // invariants can we now assume about the list?

        // 13. Why do we bother to add the contains, isEmpty, and remove methods to the
        // list class, when the client can already perform this same functionality with
        // the indexOf, size, and remove methods, respectively?

        // Exercises:
        // None
    }

}

class ArrayIntList {
    private int[] elementData;
    private int size;

    public ArrayIntList(int initialCapacity) {
        elementData = new int[initialCapacity];
        size = 0;
    }

    // Method to add elements to the list
    public void add(int value) {
        ensureCapacity(size + 1);
        elementData[size] = value;
        size++;
    }

    // Ensure the internal array has enough capacity
    private void ensureCapacity(int capacity) {
        if (capacity < elementData.length) {
            int newCapacity = Math.max(elementData.length * 2, capacity);
            int[] newArray = new int[newCapacity];
            System.arraycopy(elementData, 0, newArray, 0, size);
            elementData = newArray;
        }
    }
    // Method to get the number of elements in the list
    public int size() {
        return size;
    }

    // Method to get the element at a specific index
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elementData[index];
    }

    // Method to find the minimum value in the list
    public int min() {
        if (size == 0) {
            throw new IllegalStateException("The list is empty.");
        }
        int min = elementData[0];
        for (int i = 1; i < size; i++) {
            if (elementData[i] < min) {
                min = elementData[i];
            }
        }
        return min;
    }

    // Method to find the maximum value in the list
    public int max() {
        if (size == 0) {
            throw new IllegalStateException("The list is empty.");
        }
        int max = elementData[0];
        for (int i = 1; i < size; i++) {
            if (elementData[i] > max) {
                max = elementData[i];
            }
        }
        return max;
    }
}
