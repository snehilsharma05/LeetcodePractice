class LFUCache {
    private int capacity;
    private int currSize;
    private Map<Integer,DLLNode> cache;
    private Map<Integer,DoubleLinkedList> freqMap;
    private int leastFreq;
        
    public LFUCache(int capacity) {
        this.capacity = capacity;
        currSize = 0;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
        leastFreq = 0;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            DLLNode node = cache.get(key);
            updateNode(node);
            return node.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        
        if(cache.containsKey(key)){
            DLLNode node = cache.get(key);
            node.val = value;
            updateNode(node);
        }else{
            currSize++;
            if(currSize > capacity){
                //get min freq list
                DoubleLinkedList list = freqMap.get(leastFreq);
                cache.remove(list.tail.prev.key);
                list.removeNode(list.tail.prev);
                currSize--;
            }
            
            //reset least freq to one, we are adding a new node
            leastFreq = 1;
            DLLNode newNode = new DLLNode(key,value);
            DoubleLinkedList currList = freqMap.getOrDefault(1,new DoubleLinkedList());
            currList.addNode(newNode);
            cache.put(newNode.key,newNode);
            freqMap.put(1,currList);
        }
    }
    
    private void updateNode(DLLNode node){
        int currFreq = node.freq;
        
        DoubleLinkedList list = freqMap.get(currFreq);
        list.removeNode(node); //remove node from existing list
        
        if(currFreq == leastFreq && list.listSize == 0){
            leastFreq++;
        }
        
        node.freq++;
        DoubleLinkedList newList = freqMap.getOrDefault(node.freq, new DoubleLinkedList());
        newList.addNode(node);
        freqMap.put(node.freq,newList);
    }
}

class DLLNode{
    int key;
    int val;
    int freq;
    
    DLLNode prev,next;
    
    public DLLNode(int key,int val){
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}

class DoubleLinkedList{
    int listSize;
    
    DLLNode head,tail;
    public DoubleLinkedList(){
        head = new DLLNode(0,0);
        tail = new DLLNode(0,0);
        head.next = tail;
        tail.prev = head;
        
        listSize = 0;
    }
    
    
    public void addNode(DLLNode node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
        listSize++;
    }
    
    public void removeNode(DLLNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        listSize--;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */