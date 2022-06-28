class LRUCache {
    private class Node{
        int key,val;
        Node prev,next;
        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    
    private Node head,tail;
    Map<Integer,Node> map;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        
        if(map.size() == capacity){
            remove(tail.prev);
        }
        
        insert(new Node(key,value));
    }
    
    private void insert(Node node){
        map.put(node.key,node);
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */