
import java.util.NoSuchElementException;

class Node<T>{
    T data;
    Node<T> next;
    Node(T data){
        this.data = data;
        this.next = null;
    }
}
class SList<T>{
    Node<T> head;
    Node<T> iteratorCurr = null;
    public String toString() {
        String S = "{";
        Node<T> X = head;
        if (X == null)
            return S + "}";
        while (X.next != null) {
            S += String.valueOf(X.data) + "->";
            X = X.next;
        }
        S += String.valueOf(X.data);
        return S + "}";
    }
    public SListIterator<T> iterator(){
        return  new SListIterator<>(this);
    }
}
class SListIterator<T>{
    SList<T> sl;

    SListIterator(SList<T> obj ){sl = obj; }
    void insert(T data){
        Node<T> temp = new Node<>(data);
        if(sl.head==null){
            sl.head = temp;

        }
        else{
            Node<T> curr = sl.head;
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next = temp;
        }
        sl.iteratorCurr = sl.head;
    }
    void insertAtPos(T data, int pos){
        Node<T> temp = new Node<>(data);
        if(sl.head==null)
        {
            if(pos==1)
            {
                sl.head = temp;

            }
            else{
                System.out.println("Not possible");
            }

        }
        else{
            Node<T> curr = sl.head;
            int initial = 1;
            if(pos==1)
            {
                temp.next = sl.head;
                sl.head = temp;

            }
            else{
                while(initial<pos-1 && curr!=null)
                {
                    curr = curr.next;
                    initial++;
                }
                if(initial==pos-1)
                {
                    temp.next = curr.next;
                    curr.next = temp;
                }
                else{
                    System.out.println("Not possible");
                }
            }
        }
        sl.iteratorCurr = sl.head;
    }
    void remove(T data){
        int flag = 0;
        if(sl.head.data==data)
        {
            sl.head = sl.head.next;

            flag = 1;
        }
        else {
            Node<T> prev = sl.head;
            Node<T> curr = sl.head.next;

            while (curr != null) {
                if (curr.data == data) {
                    Node<T> next1 = curr.next;
                    prev.next = curr.next;
                    curr = next1;
                    flag = 1;
                } else {
                    curr = curr.next;
                }
            }
            if (flag == 0) {
                System.out.println(data + " not found");
            }


        }
        sl.iteratorCurr = sl.head;
    }
    public boolean hasNext(){
        if(sl.iteratorCurr==null)
            return false;
        else return true;
    }
    public T next(){
        if(sl.iteratorCurr==null)
            throw new NoSuchElementException();

        T val = sl.iteratorCurr.data;
        sl.iteratorCurr = sl.iteratorCurr.next;
        return val;

    }
}
public class Assignment10 {
    public static void main(String[] args) {
        SList<Integer> sl = new SList<>();
        SListIterator<Integer> slI = sl.iterator();
        slI.insert(23);
        slI.insert(56);
        System.out.println(sl);
        slI.insert(89);
        slI.insert(45);
        System.out.println(sl);
        slI.remove(56);
        System.out.println(sl);
        slI.insertAtPos(71,3);
        System.out.println(sl);
        slI.insertAtPos(0,5);
        System.out.println(sl);
        System.out.println();
        while(slI.hasNext()){
            System.out.println(slI.next());
        }
    }
}