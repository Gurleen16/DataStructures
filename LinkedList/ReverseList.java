public class ReverseList
{
  static class Node
  {
    int data;
    Node next;
    Node(int d)
    {
      data=d;
      next=null;
    }
  }
  static void addNode(Node head,int d)
  {
    Node n=head;
    Node temp=new Node(d);
    while(n.next!=null)
    n=n.next;

    n.next=temp;
  }
  static public void printList(Node head)
  {
     Node n=head;
     while(n!=null)
     {
       System.out.print(n.data + " ");
       n=n.next;
     }
  }
  static Node reverse(Node head)
  {
    Node current=head;
    Node prev=null;
    Node next=null;
    while(current!=null)
    {
      next=current.next;
      current.next=prev;
      prev=current;
      current=next;
    }
    head=prev;
    return head;
  }

  static Node reverseRecur(Node head)
  {
    if(head==null || head.next==null)
    return head;

    Node temp=reverseRecur(head.next);
    head.next.next=head;

    head.next=null;
    return temp;
  }

  public static void main(String args[])
  {
    Node head=new Node(1);
    addNode(head,2);
    addNode(head,3);
    addNode(head,4);
    addNode(head,5);

    Node temp=reverse(head);
    printList(temp);
    System.out.println();
    Node temp1=reverseRecur(temp);
    printList(temp1);

  }
}
