public class Main {
    public static void main(String[] args) {
        Relize list=new Relize();
      //  list.getfrist();

        list.pushFront(1);
        list.pushback(2);
        list.print();
        System.out.println(list.getLength());
        System.out.println("----------------");
        list.clear();
        System.out.println(list.getLength());
        list.getLength();
    }
}
