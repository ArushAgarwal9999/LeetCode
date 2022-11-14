class SnapshotArray {
	
	int snapId= 0 ;
	HashMap<Integer, HashMap<Integer, Integer>>mainMap = new HashMap<Integer, HashMap<Integer,Integer>>();
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public SnapshotArray(int length) {
       
    }
    
    public void set(int index, int val) {
       map.put(index , val );
    }
    
    public int snap() {
       mainMap.put(snapId, new HashMap<Integer, Integer>(map));
        
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
    	if(mainMap.containsKey(snap_id) && mainMap.get(snap_id).containsKey(index))
    	{
    		return mainMap.get(snap_id).get(index);
    	}
    	return 0;
        
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */