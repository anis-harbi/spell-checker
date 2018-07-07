import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KBestCounter<T extends Comparable<? super T>>{
	
     PriorityQueue heap;
     int k;
     public KBestCounter(int k){
          heap = new PriorityQueue < Integer > ();
          this.k=k;
     }
//Inserts an element into heap.
     public void count(T x) {
          if(heap.size()<k) {
              heap.add(x);
          }
/*if it already has k elements, then compare the new element
with the minimum element. if the new element is greater than the
Minimum element, remove the minimum element and insert the new element
otherwise, don not insert the new element.*/
          else if ( (x.compareTo((T) heap.peek()) > 0 ) && heap.size()==k){
              heap.remove();
              heap.add(x);
          }   

     }

     public List kbest(){
          List al = new ArrayList();
          int heapSize=heap.size();
          for(int i=0;i<heapSize;i++){
              al.add(0,heap.poll());
          }

//Restoring the the priority queue.
//this runs in O(k log k) time
          for(int j=0;j<al.size();j++) {
              heap.add(al.get(j)); //takes O(log k) in worst case
          }
          return al;
     }
}