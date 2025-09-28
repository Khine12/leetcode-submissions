import java.util.*;

class RandomizedSet {
    
    private final ArrayList<Integer> nums;
    
    private final HashMap<Integer,Integer> idx;
    
    private final Random rand;

    public RandomizedSet() {
        
        nums = new ArrayList<>();
        
        idx = new HashMap<>();
        
        rand = new Random();
        
    }
    
    public boolean insert(int val) {
        
        if(idx.containsKey(val)) return false;
        
        idx.put(val,nums.size());
        
        nums.add(val);
        
        return true;
    }
    
    public boolean remove(int val) {
        
        Integer i = idx.get(val);
        
        if(i==null) return false;
        
        int lastIndex = nums.size()-1;
        
        int lastVal = nums.get(lastIndex);
        
        nums.set(i,lastVal);
        
        idx.put(lastVal,i);
        
        nums.remove(lastIndex);
        
        idx.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        
        int i = rand.nextInt(nums.size());
        
        return nums.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
