#include<iostream>
#include <bits/stdc++.h>

using namespace std;

struct Stack
{
  queue<int>q1,q2;
  void push(int item)
  {
    q2.push(item);

    while(!q1.empty())
    {
      q2.push(q1.front());
      q1.pop();
    }

    queue<int>q=q1;
    q1=q2;
    q2=q;
  }
  int pop()
  {
    if(q1.empty())
    return -1;
    int item=q1.front();
    q1.pop();
    return item;
  }
};

int main()
{
  Stack s;
  s.push(4);
  s.push(5);
  s.push(6);
  cout<<s.pop()<<endl;
  cout<<s.pop()<<endl;
  cout<<s.pop()<<endl;
  s.push(7);
  s.push(8);
  cout<<s.pop()<<endl;
  cout<<s.pop()<<endl;
  s.push(9);
  cout<<s.pop()<<endl;

}
