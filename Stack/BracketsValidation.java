import java.util.*;

public class BracketsValidation
{

  static int validator(String s)
  {
    char st[]=new char[s.length()];
    int top=-1;

    for(int i=0;i<s.length();i++)
    {
      if(s.charAt(i)=='{' ||s.charAt(i)=='('||s.charAt(i)=='[')
      st[++top]=s.charAt(i);

      else if(s.charAt(i)=='}' )
      {
        if( top!=-1&&st[top]=='{')
        top--;
        else
        return i;
      }
      else if(s.charAt(i)==']' )
      {
        if(top!=-1&&st[top]=='[')
        top--;
        else
        return i;
      }else if(s.charAt(i)==')' )
      {
        if(top!=-1&&st[top]=='(')
        top--;
        else
        return i;
      }

    }
    return 1;
  }

  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();

    int res=validator(s);
    if(res==1)
    System.out.println("Balanced");
    else
    System.out.println("Not Balanced at "+res);

  }
}
