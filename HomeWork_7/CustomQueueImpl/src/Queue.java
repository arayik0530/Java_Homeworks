import java.util.Collection;

/**
 * This class is a custom implementation of java.util.Queue
 * @param <T> This class is generic and can take any object
 */

public class Queue<T> {

    private T arr[];
    private int length;
    private int front;
    private int end;
    private int count;

    /**
     * constructor
     * @param size
     */
    public Queue(int size) {
        this.arr = (T[]) new Object[size];
        this.length = size;
        this.front = 0;
        this.end = -1;
        this.count = 0;
    }

    /**
     * Checks wether the Queue is empty or not
     * @return boolean
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Checks wether the Queue is full or not
     * @return boolean
     */
    public boolean isFull() {
        return (count == length);
    }

    /**
     * adds an element in Queue
     * @param t takes an argument of any object type
     */
    public void enqueue(T t) {

        if (isFull()) {
            System.out.println("The Queue is full.");
            return;
        }
        arr[++end] = t;
        ++count;
        System.out.println("Inserting... " + t);
    }

    /**
     * deletes the first added element from Queue
     */
    public void dequeue(){

        if(isEmpty()){
            System.out.println("The Queue is empty.");
            return;
        }

        System.out.println("Removing... " + arr[front]);

        for (int i = 0; i < count-1; ++i){
            arr[i] = arr[i + 1];
        }
        arr[count-1] = null;
        --count;
        if(count != 0)
            System.out.println("Now in the Queue are " + count + " items.");
        else
            peek();
    }

    /**
     * prints the first added element
     */
    public void peek(){
        if(isEmpty()){
            System.out.println("The Queue is empty.");
            return;
        }
        System.out.println(arr[front]);
    }
}
