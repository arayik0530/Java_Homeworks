public class Queue<T> {

    private T arr[];
    private int length;
    private int front;
    private int end;
    private int count;

    public Queue(int size) {
        this.arr = (T[]) new Object[size];
        this.length = size;
        this.front = 0;
        this.end = -1;
        this.count = 0;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public boolean isFull() {
        return (count == length);
    }

    public void enqueue(T t) {

        if (isFull()) {
            System.out.println("The Queue is full.");
            return;
        }
        arr[++end] = t;
        ++count;
        System.out.println("Inserting... " + t);
    }

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

    public void peek(){
        if(isEmpty()){
            System.out.println("The Queue is empty.");
            return;
        }
        System.out.println(arr[front]);
    }
}
