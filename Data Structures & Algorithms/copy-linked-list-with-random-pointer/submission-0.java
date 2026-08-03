class Solution {
    public Node copyRandomList(Node head) {

        if (head == null)
            return null;
        Node temp = head;

        while (temp != null) {

            Node copy = new Node(temp.val);

            copy.next = temp.next;
            temp.next = copy;

            temp = temp.next.next;
        }

        temp = head;

        while (temp != null) {

            Node copy = temp.next;

            if (temp.random != null) {
                copy.random = temp.random.next;
            }

            temp = temp.next.next;
        }
        temp=head;
        Node dummy=new Node(0);
        Node copyTail=dummy;
        dummy=copyTail;
        while(temp!=null){
            Node copy=temp.next;
            temp.next=copy.next;
            copyTail.next=copy;
            copyTail=copy;
            temp=temp.next;
        }
        return dummy.next;
    }
}