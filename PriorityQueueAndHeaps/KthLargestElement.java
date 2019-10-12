import java.util.*;

public class KthLargestElement
{
  static class MinHeap
  {
    int harr[];
    int capacity;
    int heap_size;

    MinHeap(int arr[],int k)
    {
      heap_size=k;
      harr=arr;
    }
    public int parent(int i){return (i-1)/2;}

    public int left(int i){return (2*i+1);}

    public int right(int i){return (2*i+2);}

    public int getMin(){return harr[0];}

    public void swap(int x,int y)
    {
      int temp=harr[x];
      harr[x]=harr[y];
      harr[y]=temp;
    }
    public void buildHeap()
    {
      int i=(heap_size-1)/2;
      while(i>=0)
      {
        MinHeapify(i);
        i--;
      }
    }
    public int extractMin()
    {
      if(heap_size<=0)
      return -1;
      if(heap_size==1)
      {
        heap_size--;
        return harr[0];
      }

      int root=harr[0];
      harr[0]=harr[heap_size-1];
      heap_size--;
      MinHeapify(0);

      return root;
    }

    public void MinHeapify(int i)
    {
      int l=left(i);
      int r=right(i);
      int smallest=i;

      if(l<heap_size && harr[l]<harr[i])
      smallest=l;
      if(r<heap_size && harr[r]<harr[smallest])
      smallest=r;
      if(smallest!=i)
      {
        swap(i,smallest);
        MinHeapify(smallest);
      }
    }

    public void replaceMin(int n)
    {
      harr[0]=n;
      MinHeapify(0);
    }

  }
  static public void kthLargest(int k)
  {
    int count=0,n;
    Scanner sc=new Scanner(System.in);
    int arr[]=new int[k];
    MinHeap h=new MinHeap(arr,k);

    while(true)
    {
      System.out.println("Enter element or enter -1 to exit");
      n=sc.nextInt();

      if(n==-1)
      return;
      if(count<k-1)
      {
        arr[count]=n;
        count++;
      }
      else
      {
        if(count==k-1)
        {
          arr[count]=n;
          h.buildHeap();
        }
        else
        {
          if(n>h.getMin())
          h.replaceMin(n);
        }

        System.out.println("Kth Largest Element:"+h.getMin());
        count++;
      }
    }
  }

  public static void main(String args[])
  {
    int k=3;
    kthLargest(k);
  }
}
