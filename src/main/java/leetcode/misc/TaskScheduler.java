package leetcode.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

    class Item {
        public Item(int last, int rem){
            this.last = last;
            this.rem = rem;
            this.orig = rem;
        }
        int last;
        int rem;
        int orig;
    }

    public int leastInterval(char[] tasks, int n) {

        Map<Character,Integer> map = new HashMap();

        for(int i=0;i<tasks.length;i++)
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);

        PriorityQueue<Item> q = new PriorityQueue<Item>((i1,i2)->i2.rem-i1.rem);
        List<Item> l = new ArrayList();

        for(Map.Entry<Character,Integer> entry: map.entrySet())
            q.add(new Item(-1, entry.getValue()));

        int start = 0;

        while(!q.isEmpty()){

            //find next eligible item
            boolean found = false;
            while(!q.isEmpty() && !found){
                Item i = q.poll();
                if(i.last == -1 || (start - i.last) >n){
                    found = true;
                    if(i.rem > 1){
                        i.rem -=1;
                        i.last = start;
                        q.add(i);
                    }
                } else{
                    l.add(i);
                }
            }

            q.addAll(l);
            l.clear();
            start++;
        }

        return start;
    }
}