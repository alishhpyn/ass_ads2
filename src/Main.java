
class Main{
    public static void main(String[] args){
        LinkedList list  = new LinkedList();
        LinkedList list1 = new LinkedList();
        list1.insert(12);
        list1.insert(18);
        list1.insert(15);
        list1.insert(14);
        list.insert(5);
        list.insert(7);
        list.insert(12);
        list.insertAtStart(55);
        list.insertAtStart(31);
        list.insertAt(0,9);
        list.removeTheLastElement();
        list.removeByValue(9);
        list.combineLists(list,list1);
        list.reverse();
        list.show();



    }
}