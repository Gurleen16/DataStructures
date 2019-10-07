public class ListPalidrome
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
  static Node chtemp;
  static int check(Node temp)
  {
    if(temp==null)
    return 1;
    int res=0;
    if((check(temp.next)==1) && (temp.data==chtemp.data))
    res=1;
    chtemp=chtemp.next;
    return res;
  }

  static int checkPalindrome(Node head)
  {
    chtemp=head;

    return check(head);
  }

  public static void main(String args[])
  {
    Node head=new Node(1);
    addNode(head,4);
    addNode(head,3);
    addNode(head,4);
    addNode(head,1);

    if(checkPalindrome(head)==1)
    System.out.println("Palidrome");
    else
    System.out.println("Not Palidrome");
  }
}
