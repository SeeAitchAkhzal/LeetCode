package leetcode.misc;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Runtime: 56 ms, faster than 88.00% of Java online submissions for Design Hit Counter.
 */
public class DesignHitCounter {

    class Node {
        int timestamp;
        int count;

        public Node(int timestamp, int count){
            this.timestamp = timestamp;
            this.count = count;
        }
    }

    PriorityQueue<Node> q = new PriorityQueue<Node>(new Comparator<Node>(){
        @Override
        public int compare(Node n, Node m){
            return m.timestamp - n.timestamp;
        }
    });


    /** Initialize your data structure here. */
    public DesignHitCounter() {

    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {

        if(q.size() > 0 && q.peek().timestamp == timestamp){
            q.peek().count++;
        } else{
            q.add(new Node(timestamp, 1));
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {

        int start  = timestamp - (5*60);
        int hits = 0;
        PriorityQueue<Node> temp = new PriorityQueue<Node>(new Comparator<Node>(){
            @Override
            public int compare(Node n, Node m){
                return m.timestamp - n.timestamp;
            }
        });

        while(q.size() > 0 && q.peek().timestamp > start){
            Node n = q.poll();
            hits += n.count;
            temp.add(n);
        }

        q.clear();
        q = temp;
        return hits;
    }

}
