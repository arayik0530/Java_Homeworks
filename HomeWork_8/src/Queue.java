import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
/**
 * This class is a custom implementation of java.util.Queue.
 * Here are implemented the methods of the Queue and Collection interface,
 * so there are several methods in this class that almost do the same
 * such as add() and enqueue(). For more flexiblity boths are kept.
 * @param <T> This class is generic and can take any object
 */
public class Queue<T> implements Collection {
    private T arr[];
    private int length;
    private int front;
    private int end;
    private int count;
    /**
     * constructor
     * @param size of initial Queue
     */
    public Queue(int size) {
        this.arr = (T[]) new Object[size];
        this.length = size;
        this.front = 0;
        this.end = -1;
        this.count = 0;
    }
    /**
     * @return the size of Queue
     */
    @Override
    public int size() {
        return this.count;
    }
    /**
     * @return current capacity of Queue
     */
    public int currentCapacity() {
        return this.length;
    }
    /**
     * Checks wether the Queue is empty or not
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }
    /**
     * Checks whether the Queue contains
     * a given object or not
     * @param o any Object
     * @return boolean
     */
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < this.arr.length; i++)
            if (o.equals(arr[i]))
                return true;
        return false;
    }
    /**
     * @return object of Iterator type,
     * which iterates over the Queue
     */

    @Override
    public Iterator iterator() {
        class InnerIterator implements Iterator<T> {
            private int index = 0;
            @Override
            public boolean hasNext() {
                if (index < arr.length - 1) {
                    return true;
                }
                return false;
            }
            @Override
            public T next() {
                if (index <= arr.length - 1) {
                    return arr[index++];
                }
                return null;
            }
        }
        return new InnerIterator();
    }
    /**
     *  @return the Queue as an array
     */
    @Override
    public Object[] toArray() {
        return this.arr;
    }
    /**
     * @param o any Object type
     * @return boolean whether new element was added
     * The Queue permits dublicates, so it always returns true
     */
    private boolean linearSearch ( T arr[], Object o ) {
        for ( byte i = 0; i < arr.length; i++ ) {
            if ( arr[i].equals(o) )
                return true;
        }
        return false;
    }
    @Override
    public boolean add(Object o) {
        if ( linearSearch ( arr, o ) )
            return false;
        enqueue((T)o);
        return true;
    }
    /**
     * @param o o any Object
     * @return boolean
     */
    @Override
    public boolean remove(Object o) {
        if(this.contains(o)){
            T[] arr = (T[]) new Object[this.arr.length-1];
            int index = -1;
            for (int i = 0; i < this.arr.length; i++) {
                if(o.equals(this.arr[i])){
                    arr[i] = null;
                    continue;
                }
                arr[++index] = this.arr[i];
            }
            this.arr = arr;
            return true;
        }
        return false;
    }
    /**
     * add a collection to the Queue
     * @param collection
     * @return boolean
     */
    @Override
    public boolean addAll(Collection collection) {
        collection = (Queue)collection;
        this.arr = Arrays.copyOf(this.arr, this.arr.length + collection.size());
        for (int i = this.size(); i < this.arr.length; i++) {
            this.arr[i] = (T)((Queue) collection).arr[i - this.size()];
        }
        return true;
    }
    /**
     * truncates the Queue
     */
    @Override
    public void clear() {
        this.arr = (T[]) new Object[size()];
    }
    /**
     * @param collection
     * @return boolean
     */
    @Override
    public boolean retainAll(Collection collection) {
        T[] temp = this.arr;
        T[] newArr = (T[]) new Object[this.arr.length];
        int k = 0;
        for (int i = 0; i < this.arr.length; i++) {
            for (int j = 0; j < ((Queue) collection).arr.length; j++) {
                if(this.arr[i].equals(((Queue) collection).arr[j]));{
                    newArr[k++] = this.arr[i];
                }
            }
        }
        this.arr = newArr;
        return (!temp.equals(newArr));
    }
    /**
     * @param collection
     * @return boolean
     */
    @Override
    public boolean removeAll(Collection collection) {
        T[] temp = this.arr;
        T[] newArr = (T[]) new Object[this.arr.length];
        int k = 0;
        for (int i = 0; i < this.arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < ((Queue) collection).arr.length; count++, j++) {
                if(this.arr[i].equals(((Queue) collection).arr[j]));{
                    flag = true;
                    break;
                }
            }
            if(!flag){
                newArr[k++] = this.arr[i];
            }
        }
        this.arr = newArr;
        return (!temp.equals(newArr));
    }
    /**
     * @param collection
     * @return boolean
     */
    @Override
    public boolean containsAll(Collection collection) {
        for (int i = 0; i < ((Queue) collection).arr.length; i++) {
            if(!this.contains(((Queue) collection).arr[i])){
                return false;
            }
        };
        return true;
    }
    /**
     * @param objects
     * @return boolean
     */
    @Override
    public Object[] toArray(Object[] objects) {
        return this.arr;
    }
    /**
     * adds an element in Queue
     * @param t takes an argument of any object type
     */
    public void enqueue(T t) {
        if (this.count >= this.length * 0.75) {
            bigArray();
        }
        arr[++end] = t;
        ++count;
    }
    /**

     * deletes the first added element from Queue

     */
    public boolean dequeue() {
        if (isEmpty()) {
            return false;
        }
        for (int i = 0; i < count - 1; ++i) {
            arr[i] = arr[i + 1];
        }
        arr[--count] = null;
        if ( count == 0 )
            peek();
        return true;
    }
    /**
     * prints the first added element and
     * returns it
     */
    public T peek() {
        return arr[front];
    }
    private void bigArray (  ) {
        this.arr = Arrays.copyOf( this.arr, this.arr.length * 2 );
    }
}