
//        设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
//        在链表类中实现这些功能：
//        get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
//        addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
//        addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
//        addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
//        deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
public class Exercise1 {
    class Node{
        int val;
        Node next;

        @Override
        public String toString() {
            return String.format("%d->",val);
        }

        Node(int val){
            this.val=val;
            this.next=null;

        }
    }
    private Node head;
    /** Initialize your data structure here. */
    public Exercise1() {
        this.head = head;
    }


    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node cur=this.head;
        if(index<0||index>getlength()-1)
        return -1;
        else{
            for (int i = 0; i < index; i++) {
                cur=cur.next;
            }
            return cur.val;
        }
    }

    private int getlength() {
        Node cur=this.head;

        int n=0;
        while(cur!=null){
            n++;
            cur=cur.next;
        }
        return n;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node=new Node(val);
        if(this.head==null){
            this.head=node;
        }else{
            node.next=this.head;
            this.head=node;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node=new Node(val);
        Node cur=this.head;
        if (this.head==null) {
            this.head = node;
        }else{
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node node=new Node(val);
        Node cur=this.head;
        if(index>getlength()){
        }else if(index==getlength()){
            addAtTail(val);
        }else if(index<=0){
            addAtHead(val);
        }else{
            for (int i = 0; i < index-1; i++) {
                cur=cur.next;
            }
            node.next=cur.next;
            cur.next=node;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index>=0&&index<=getlength()-1){
            if(index==0){
                if(this.head==null){
                    throw new StringIndexOutOfBoundsException("链表为空，不能删除");
                } else if(this.head.next==null){
                    this.head=null;
                }else{
                    this.head=this.head.next;
                }
            }else if(index==getlength()-1){
                if(this.head==null){
                    throw new StringIndexOutOfBoundsException("链表为空，不能删除");
                }else if(this.head.next==null){
                     this.head=null;
                } else{
                    Node p=this.head;
                    while(p.next.next!=null){
                        p=p.next;
                    }
                    p.next=null;
                }
            }else{
                Node cur=this.head;
                for (int i = 0; i <index-1 ; i++) {
                    cur=cur.next;
                }
                cur.next=cur.next.next;
            }
        }
        }
        public void print(){
        Node cur=this.head;
        while(cur!=null){
            System.out.print(cur+" ->");
            cur=cur.next;
        }
        }

    public static void main(String[] args) {
        Exercise1 list=new Exercise1();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1,2);
        //list.deleteAtIndex(2);
        System.out.println(list.get(1));
        list.deleteAtIndex(1);
        System.out.println(list.get(1));
        list.print();
    }
    }
