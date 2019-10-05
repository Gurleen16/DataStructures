#include<iostream>
#include <bits/stdc++.h>

using namespace std;

struct Queue
{
  stack<int>s1,s2;

  void enqueue(int item)
  {
    s1.push(item);
  }
  int dequeue()
  {
    if(s1.empty())
    return -1;

    while(!s1.empty())
    {
      int d=s1.top();
      s1.pop();
      s2.push(d);
    }
    int item=s2.top();
    s2.pop();
    while(!s2.empty())
    {
      int d=s2.top();
      s2.pop();
      s1.push(d);
    }
    return item;
  }
};

int main()
{
  Queue q;
  q.enqueue(4);
  q.enqueue(5);
  q.enqueue(6);
  cout<<q.dequeue()<<endl;
  cout<<q.dequeue()<<endl;
  cout<<q.dequeue()<<endl;
  q.enqueue(7);
  cout<<q.dequeue()<<endl;
  cout<<q.dequeue()<<endl;
  q.enqueue(8);
  cout<<q.dequeue()<<endl;

}
