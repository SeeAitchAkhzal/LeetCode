package leetcode.misc;

import java.util.HashMap;

/**
 * Runtime: 81 ms, faster than 90.08% of Java online submissions for LRU Cache.
 */
class LRUCache {


    HashMap<Integer,Node> map = new HashMap<Integer,Node>();
    LinkedList list = new LinkedList();
    int cap = 0;
    int max;

    public LRUCache(int capacity) {
        this.max = capacity;
    }

    public int get(int key) {
        int retVal = -1;

        if(map.containsKey(key)) {
            Node temp = map.get(key);
            retVal = temp.val;
            list.update(temp);
        }
        return retVal;
    }

    public void put(int key, int value) {

        boolean exists = map.containsKey(key);

        if(exists){
            Node existingNode = map.get(key);
            existingNode.val = value;
            list.refresh(existingNode);
        }
        else{
            Node newNode = new Node(key, value);
            map.put(key, newNode);

            if (cap != max) {
                list.add(newNode);
                cap++;
            } else {

                // evict the least recently used node
                Node tailNode = list.deleteAndReturnTailNode();
                map.remove(tailNode.key);
                list.add(newNode);
            }
        }

    }

    class Node{

        public int val;
        public int key;
        public Node next;
        public Node prev;

        public Node(int key, int val){
            this.val = val;
            this.key = key;
            this.prev = this.next = null;
        }
    }


    class LinkedList {

        Node head;
        Node tail;

        public LinkedList(){
            tail = head = null;
        }

        void refresh(Node node) {
            if(node != head){

                if(node.next != null){
                    node.next.prev = node.prev;
                } else {
                    // update tail pointer too
                    tail = node.prev;
                }


                node.prev.next = node.next;
                node.prev = null;
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        Node deleteAndReturnTailNode() {

            Node temp = tail;
            tail = temp.prev;

            if(temp.prev != null){
                temp.prev.next = null;
                temp.prev = null;
            }

            if(temp == head) head = null;

            return temp;
        }

        void update(Node node){

            if(node == head) return;

            if(node.prev != null){
                node.prev.next = node.next;
            }

            if(node.next != null){
                node.next.prev = node.prev;
            }

            head.prev = node;
            node.next = head;

            if(node == tail){
                tail = node.prev;
            }
            node.prev = null;

            head = node;
        }

        Node add(Node node){

            if(head == null){
                head = node;
                tail = head;
            }
            else{

                node.next = head;
                head.prev = node;
                head = node;
            }

            return head;
        }

    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */