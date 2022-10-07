class MyCalendarThree {

    TreeMap<Integer, Integer> count;
    int max;

    public MyCalendarThree() {
        count = new TreeMap();
        count.put(-1, 0);
        max = 0;
    }
    
    public int book(int start, int end) {
        count.put(start, count.floorEntry(start).getValue());
        count.put(end, count.floorEntry(end).getValue());
        for(Map.Entry<Integer, Integer> entry : count.subMap(start, end).entrySet()){
            int val = entry.getValue() + 1;
            entry.setValue(val);
            max = Math.max(max, val);
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */