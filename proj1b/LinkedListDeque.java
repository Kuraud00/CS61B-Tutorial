public class LinkedListDeque<T> implements Deque<T>{
    private class Node{
        public T item;
        public Node next;
        public Node prev;
        public Node(Node p,T i,Node n){
            prev=p;
            item=i;
            next=n;
        }
    }

    private Node sentFront;
    private Node sentBack;

    private int size;

    public LinkedListDeque(){
        sentFront = new Node(null,null,null);
        sentBack = new Node(sentFront,null,null);
        sentFront.next=sentBack;
        size=0;
    }

    @Override
    public void addFirst(T item){
        sentFront.next=new Node(sentFront,item,sentFront.next);
        sentFront.next.next.prev=sentFront.next;
        size++;
    }

    @Override
    public void addLast(T item){
        sentBack.prev=new Node(sentBack.prev,item,sentBack);
        sentBack.prev.prev.next=sentBack.prev;
        size++;
    }

    @Override
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        Node temp=sentFront.next;
        while(temp.next!=null){
            System.out.print(temp.item+" ");
            temp=temp.next;
        }
    }

    @Override
    public T removeFirst(){
        T removed=null;
        if(size==0){
            return removed;
        }
        removed=sentFront.next.item;
        sentFront.next=sentFront.next.next;
        sentFront.next.prev=sentFront;
        size--;
        return removed;
    }

    @Override
    public T removeLast(){
        T removed=null;
        if(size==0){
            return removed;
        }
        removed=sentBack.prev.item;
        sentBack.prev=sentBack.prev.prev;
        sentBack.prev.next=sentBack;
        size--;
        return removed;
    }

    @Override
    public T get(int index){
        Node temp=sentFront.next;
        while(index>0){
            temp=temp.next;
            index--;
        }
        return temp.item;
    }

    private T Recursive(int index,Node current){
        if(index==0){
            return current.item;
        }else{
            return Recursive(--index,current.next);
        }
    }

    @Override
    public T getRecursive(int index){
        return Recursive(index,sentFront.next);
    }

}
