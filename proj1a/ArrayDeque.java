public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst,nextLast;

    public ArrayDeque(){
        items=(T[])new Object[8];
        size=0;
        nextFirst=0;
        nextLast=1;
    }

    private int circu(int num){
        if(num >= items.length){
            return num-items.length;
        }
        if(num < 0){
            return num+items.length;
        }
        return num;
    }

    private void resize(int capacity){
        T[] temp=(T[])new Object[capacity];
        int f = circu(nextFirst+1);
        for(int count=0;count<size;count++){
            temp[count]=items[circu(f+count)];
        }
        nextFirst=capacity-1;
        nextLast= size;
        items=temp;
    }

    public void printDeque(){
        int f = circu(nextFirst+1);
        for(int count=0;count<size;count++){
            System.out.print(items[circu(f+count)]+" ");
        }
    }

    public void addFirst(T item){
        if(size == items.length){
            resize(items.length*2);
        }
        items[nextFirst]=item;
        size++;
        nextFirst=circu(nextFirst-1);
    }

    public void addLast(T item){
        if(size== items.length){
            resize(items.length*2);
        }
        items[nextLast]=item;
        size++;
        nextLast=circu(nextLast+1);
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T temp=items[circu(nextFirst+1)];
        items[circu(nextFirst+1)]=null;
        nextFirst=circu(nextFirst+1);
        size--;
        float R=(float)size/ items.length;
        System.out.println(R);
        if(R<=0.25){
            resize(items.length/2);
            //System.out.println("Resized,now the length is "+items.length);
        }
        return temp;
    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T temp=items[circu(nextLast-1)];
        items[circu(nextLast-1)]=null;
        nextLast=circu(nextLast-1);
        size--;
        float R=(float)size/ items.length;
        System.out.println(R);
        if(R<=0.25){
            resize(items.length/2);
            //System.out.println("Resized,now the length is "+items.length);
        }
        return temp;
    }

    public T get(int index){
        return items[circu(nextFirst+1+index)];
    }
}
