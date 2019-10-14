public class Relize implements MyLinkedList {
    class Node {
        private int val;
        ;private  Node next;

        public Node(int val) {
            this.val = val;
            this.next=null;
        }

        @Override
        public String toString() {
            return String.format("<Node-%d>->",val);
        }
    }
    private Node head;

    public Relize() {
        this.head = head;
    }

    @Override
    public void pushFront(int val) {
        Node node =new Node(val);
        if(this.head==null){
            this.head=node;
        }else{
            node.next=this.head;
            this.head=node;
        }
    }

    @Override
    public void pushback(int val) {
        Node node = new Node(val);
        Node cur = this.head;
        if (this.head == null) {
            this.head = node;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public void cheak(int index) {
        if(index<0||index>getLength()){
            throw new StringIndexOutOfBoundsException("下表输入有误");
        }
    }

    @Override
    public void insert(int index, int val) {
        cheak(index);
        Node node=new Node(val);
        Node cur =this.head;
        if(index==0){
            pushFront(val);
        }else if(index==getLength()){
            pushback(val);
        }else{
            for(int i=0;i<index;i++){
                cur=cur.next;
            }
            node.next=cur.next;
            cur.next=node;
        }
    }

    @Override
    public void popFront() {
        if(this.head==null){
            throw new StringIndexOutOfBoundsException("链表为空，不能删除");
        } else if(this.head.next==null){
            this.head=null;
        }else{
          this.head=this.head.next;
        }

    }

    @Override
    public void popBack() {
        if(this.head==null){
            throw new StringIndexOutOfBoundsException("链表为空，不能删除");
        }else if(this.head.next==null){
            this.head=null;
        }else{
            Node cur=this.head;
            while(cur.next.next!=null){
                cur=cur.next;
            }
            cur.next=null;
        }

    }

    @Override
    public void clear() {
        this.head=null;
    }

    @Override
    public int getLength() {
        Node cur=this.head;
        int length=0;
        while(cur!=null){
            cur=cur.next;
            length++;
        }
        return length;
    }

    @Override
    public void print() {
        Node cur=this.head;
        while(cur!=null){
            System.out.print(cur);
            cur=cur.next;
        }
        System.out.println();
    }

    @Override
    public int getfrist() {
        if(this.head==null){
            throw new StringIndexOutOfBoundsException("空表不能返回frist->val");
        }
        return this.head.val;
    }
}
