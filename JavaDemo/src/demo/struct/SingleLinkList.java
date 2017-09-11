package demo.struct;

/**
 * Created by wim on 2017/8/30.
 */
public class SingleLinkList {
    private SingleLinkNode head = null;
    private int size = 0;

    public SingleLinkList() {
        head = new SingleLinkNode();
    }


    public void insert(int data, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index out of size");
        }
        SingleLinkNode preNode = preNode(index);
        SingleLinkNode newNode = new SingleLinkNode(data);
        if (preNode.next != null) {
            SingleLinkNode curNode = preNode.next;
            newNode.next = curNode;
        }
        preNode.next = newNode;
        size++;
    }

    public void delete(int index) throws Exception {
        if (index < 0 || index > size-1){
            throw new IllegalArgumentException("index out of size");
        }
        if (isEmpty()){
            throw new Exception("list can't be empty!");
        }

        SingleLinkNode preNode = preNode(index);
        SingleLinkNode curNode = preNode.next;
        preNode.next = curNode.next;
        size--;
    }

    public int get(int index) {
        if (index < 0 || index > size-1 || isEmpty()){
            return -1;
        }
        SingleLinkNode curNode = preNode(index).next;
        return curNode.data;
    }

    public void set(int data, int index) {
        if (index < 0 || index > size-1 || isEmpty()){
            return;
        }
        SingleLinkNode curNode = preNode(index).next;
        curNode.data = data;
    }

    public boolean isEmpty() {
        return size == 0 ? true:false;
    }

    public int getLength() {
        return size;
    }

    public void printList() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        SingleLinkNode node = head;
        while (i < size) {
            node = node.next;
            if (i == size -1) {
                stringBuilder.append(node.data);
            }
            else {
                stringBuilder.append(node.data+" > ");
            }

            i++;
        }
        System.out.println("linkList == "+stringBuilder);
    }

    private SingleLinkNode preNode(int index) {
        int i = 0;
        SingleLinkNode preNode = head;
        while (i < index) {
            preNode = preNode.next;
            i++;
        }
        return preNode;
    }

    public static void main(String[] args) {
        SingleLinkList list = new SingleLinkList();
        for (int i = 0; i < 8; i++) {
            list.insert(i,i);
        }
        list.printList();

        int data = list.get(3);
        System.out.println(data);
    }
}
