
public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_SIZE = 10;
    private int size = 0;
    private T[] a = (T[]) new Object[DEFAULT_SIZE];

    @Override
    public void add(T item){
        if( size == a.length){
            grow_array();
        }
        a[size++] = item;
    }

    @Override
    public void add(int pos, T item){
        if( pos  < 0 || pos > size){
            //throw new Exception();
        }
        if( size == a.length){
            grow_array();
        }
        for( int i = size - 1; i > pos; i--){
            a[i + 1] = a[i];
        }
        a[pos] = item;
        ++size;
    }

    @Override
    public T get(int pos) throws Exception{
        if( pos < 0 || pos >= size){
            throw new Exception();
        }
        return a[pos];
    }

    @Override
    public T remove(int pos) throws Exception {
        if( pos < 0 || pos >= size) {
            throw new Exception();
        }
        T temp = a[ pos];
        for( int i = pos; i < size - 1; i ++){
            a[i] = a[i+1];
        }
        --size;
        return temp;
    }

    @Override
    public int size(){
        return size;
    }

    public void grow_array(){
        T[] new_a = (T[]) new Object[size*2];
        for(int i = 0; i < size; i++) {
            new_a[i] = a[i];
        }
        a = new_a;
    }
}
