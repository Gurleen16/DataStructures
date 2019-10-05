public class MinElement
{
  static class Stack
  {
    int st[]=new int[10];
    int top=-1;
    int min;
    void push(int item)
    {
      if(top==-1)
      min=item;

      if(min>item)
      min=item;
      st[++top]=item;
    }
    int pop()
    {
      int item;
      if(top!=-1)
      {
        item=st[top];
        top--;
        return item;
      }
      return -1;
    }
    int getMin()
    {
      return min;
    }
  };

  public static void main(String args[])
  {
    Stack s=new Stack();
    s.push(4);
    s.push(5);
    s.push(6);
    System.out.println(s.pop());
    System.out.println("Min Element: "+s.getMin());
    s.push(3);
    s.push(8);
    System.out.println("Min Element: "+s.getMin());
    s.push(1);
    System.out.println("Min Element: "+s.getMin());

  }

}
