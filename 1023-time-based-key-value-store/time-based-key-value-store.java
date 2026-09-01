class Pair {
    int timestamp;
    String value;
    Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}
class TimeMap {
    private Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<Pair>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        List<Pair> list = map.get(key);
        int low = 0;
        int high = list.size() - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            Pair p = list.get(mid);
            if(p.timestamp == timestamp) {
                return p.value;
            }
            else if(p.timestamp > timestamp) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        if(high >= 0) {
            return list.get(high).value;
        }
        return "";
    }
}
