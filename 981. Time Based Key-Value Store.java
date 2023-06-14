// Medium. TreeMap.
// June 14 2023.

class TimeMap {

    public HashMap<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        // Create treemap if doesn't exist yet.
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new TreeMap<Integer, String>());
        }

        timeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (timeMap.containsKey(key)) {
            if (timeMap.get(key).floorEntry(timestamp) == null) {
                return "";
            }

            return timeMap.get(key).floorEntry(timestamp).getValue();

        }

        return "";

    }
}
