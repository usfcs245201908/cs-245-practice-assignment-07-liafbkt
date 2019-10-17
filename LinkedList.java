
public class LinkedList<T> implements List<T> {
    //private final static int DEFAULT_SIZE = 10;
    //private T[] a = (T[]) new Node[DEFAULT_SIZE];
    private Node head = null;
    private int size = 0;
    class Node<T>{
        T data;
        Node next;
        public Node(T item){this.data = item; this.next = null;}
    }

    @Override
    public void add(T item) {
        if( head == null){
            head = new Node(item);
            ++size;
        }else{
            Node node = new Node(item);
            Node prev = head;
            while(prev.next != null){
                prev = prev.next;
            }
            prev.next = node;
            ++size;
        }

    }

    @Override
    public void add(int pos, T item) throws Exception{
        if( pos > size || pos < 0){
            throw new Exception();
        }
        if( pos == 0){ // first one special case
            Node node = new Node(item);
            node.next = head;
            head = node;
            ++size;
        }else{
            Node prev = head;
            for( int i = 0; i < pos - 1; i++){
                prev = prev.next;
            }
            Node node = new Node(item);
            node.next = prev.next;
            prev.next = node;
            ++size;
        }

    }

    @Override
    public T get(int pos) throws Exception{
        if( pos > size || pos < 0){
            throw new Exception();
        }
        if(pos == 0){
            return (T) head.data;
        }else{
            Node prev = head;
            for(int i = 0; i < pos - 1; i++){
                prev = prev.next;
            }
            return (T)prev.next.data;
        }
    }

    @Override
    public T remove(int pos) throws Exception {
        if (pos > size || pos < 0) {
            throw new Exception();
        }
        if (pos == 0) {
            Node node = head;
            head = head.next;
            --size;
            return (T)node.data;
        } else {
            Node prev = head;
            for (int i = 0; i < pos - 1; i++) { // get the prev to be the previous one that will be removed
                prev = prev.next;
            }
            Node node = prev.next;
            prev.next = node.next;
            --size;
            return (T)node.data;
        }
    }

    @Override
    public int size() {
        return size;
    }
}
