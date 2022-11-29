class RandomizedSet {
    private List<Integer> nums;
    private Map<Integer,Integer> locations;
    public RandomizedSet() {
        nums = new ArrayList<>();
        locations = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(locations.containsKey(val)){
            return false;
        }
        
        locations.put(val,nums.size());
        nums.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!locations.containsKey(val)){
            return false;
        }
        
        int index = locations.get(val);
        if(index < nums.size() - 1){ //mns val is not the last element in list, we could have done size--
            int lastDataInArray = nums.get(nums.size() - 1);
            nums.set(index,lastDataInArray);
            locations.put(lastDataInArray,index);
        }
        
        locations.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }
    
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */