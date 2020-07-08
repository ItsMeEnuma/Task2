package sample;

public class List<T extends Comparable<T>>{

    private class ListNode<T>{
        private T value;
        private ListNode<T> next;

        public ListNode(T value, ListNode<T> next) {
            this.value = value;
            this.next = next;
        }

        public ListNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public ListNode<T> getNext() {
            return next;
        }

        public void setNext(ListNode<T> next) {
            this.next = next;
        }
    }

    private ListNode<T> head;
    private ListNode<T> tail;

    private int length = 0;

    public void add(T value){
        ListNode<T> node = new ListNode<>(value);

        if(head == null){
            head = node;
            tail = node;
        }
        else{
            tail.next = node;
            tail = node;
        }
        length++;
    }

    public void remove(int index){
        if(index < 0 || index >= length){
            throw new Error();
        }

        if(index == 0 && length == 1){
            head = tail = null;
        }

        else if(index == 0){
            ListNode<T> firstNode = head.getNext();
            head = firstNode;
        }

        else if(index == length - 1){
            ListNode node = head;
            for(int i = 0; i < length - 2; i++){
                node = node.next;
            }
            node.next = null;
            tail = node;
        }

        else{
            ListNode first = head;
            ListNode second = first.next;

            for(int i = 0; i < index - 1; i++){
                first = first.next;
                second = second.next;
            }

            second = second.next;
            first.next = second;
        }
        length--;
    }

    public void remove(int firstIntex, int secondIndex){
        for(int i = 0; i < secondIndex - firstIntex + 1; i++){
            remove(firstIntex);
        }
    }

    public T get(int index){
        if(index < 0 || index >= length){
            throw new Error();
        }

        ListNode<T> node = head;

        for(int i = 0; i < index; i++){
            node = node.getNext();
        }
        return node.getValue();
    }

    public int size(){
        return length;
    }

    public void clear(){
        head = tail = null;
        length = 0;
    }



}
