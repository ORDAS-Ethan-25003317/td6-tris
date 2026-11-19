import java.util.Comparator;
import java.util.Queue;

public class Quicksort {

    public static void qsort(Queue<K> s, Comparator<K> comp){
        int n = s.size();
        if(n <2) return;
        K pivot =s.first();
        Queue<K> l = new Queue<K>();
        Queue<K> g = new Queue<K>();
        Queue<K> e = new Queue<K>();
        while (! s.isEmpty()){
            K element = s.dequeue();
            int c = comp.compare(pivot,element);
            if(c < 0){
                l.enqueue(element);
            } else if(c == 0){
                e.enqueue(element);
            } else{
                g.enqueue(element);
            }
        }
        qsort(l,comp);
        qsort(g,comp);
        while(! l.isEmpty()){
            s.enqueue(l.dequeue());
        }
        while(! e.isEmpty()){
            s.enqueue(e.dequeue());
        }
        while(! g.isEmpty()){
            s.enqueue(g.dequeue());
        }
    }

}
