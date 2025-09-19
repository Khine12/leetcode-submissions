import java.util.*;
class MyHashMap {
    
    private int size = 1000;
    
    private List<int[]>[] buckets;

    public MyHashMap() {
        
        buckets = new ArrayList[size];
        
        for(int i=0; i<size; i++){
            buckets[i] = new ArrayList<>();
        }
        
    }
    
    private int hash(int key){
        
        return key%size;
    }
    
    public void put(int key, int value) {
        
        int i= hash(key);
        
        for (int[] pairs : buckets[i]){
            
            if(pairs[0]==key){
                pairs[1] = value;
                return;
            }
        }
        
        buckets[i].add(new int[]{key,value});
    }
    
    public int get(int key) {
        
        int i = hash(key);
        
        for(int[] pairs : buckets[i]){
            
            if(pairs[0]==key) return pairs[1];
        }
        return -1;
    }
    
    public void remove(int key) {
        
        int i = hash(key);
        
        buckets[i].removeIf(pair -> pair[0]==key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
