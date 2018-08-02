public class CircularQueue<T> //<T> indicates that the class is of Generic type
{

    private int size;
    //front denotes the element inserted first. Useful in poll() operation
    private int front=-1;

    //end denotes where the last inserted element is present. Useful in offer() operation
    private int end=-1;
    private T data[] = null;
    public CircularQueue(int size){
        this.size = size;
        data = (T[] ) new Object[size];
    }

    public void offer(T t) throws IllegalArgumentException{
        //check if queue is full
        if(isFull())
            throw new IllegalArgumentException("Queue is already full");
        //check if the queue is currently empty
        else if(isEmpty()){
            data[0] = t;
            front=0;
            end=0;
        }
        else{
            end = (end+1)%size;
            data[end] = t;
        }
    }

    public boolean isEmpty(){
        return front==-1;
    }
    public boolean isFull(){
        return front==((end+1)%size);
    }
    public T top(){
        //first check if queue is empty
        if(isEmpty())
            throw new IllegalArgumentException();

        else return data[front];
    }

    public T poll(){
        T res=null;
        //check if queue is empty
        if(isEmpty())
            throw new IllegalArgumentException();
        //check if queue has only 1 element
        else if(front==end){
            res = data[front];
            front=-1;
            end=-1;
            return res;
        }
        else {
            res = data[front];
            front = (front+1)%size;
        }
        return res;
    }
    public static void main(String[] args) {

        CircularQueue<Integer> circularQueue = new CircularQueue<Integer>(5); //Giving the type as Integer
        circularQueue.offer(1);
        circularQueue.offer(2);
        circularQueue.offer(3);
        //System.out.println(circularQueue.poll());
        circularQueue.offer(4);
        circularQueue.offer(5);
        System.out.print(circularQueue.isFull());
        try {
            circularQueue.offer(6);
       }
        catch (IllegalArgumentException e){
           System.out.println("Inside catch block");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.print(circularQueue.isFull());

        while(!circularQueue.isEmpty()){
            System.out.println(circularQueue.poll());
        }
    }

}
