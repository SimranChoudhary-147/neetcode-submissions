
class TimedValue {
    String value;
    int time;

    public TimedValue(String value, int time) {
        this.value = value;
        this.time = time;
    }
}

class TimeMap {

    Map<String, ArrayList<TimedValue>> mp;

    public TimeMap() {
        mp = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        if (!mp.containsKey(key)) {
            mp.put(key, new ArrayList<>());
        }

        mp.get(key).add(new TimedValue(value, timestamp));
    }

    public String get(String key, int timestamp) {

        if (!mp.containsKey(key))
            return "";

        return binarySearch(mp.get(key), timestamp);
    }

    private String binarySearch(ArrayList<TimedValue> arr, int target) {

        int low = 0;
        int high = arr.size() - 1;

        String ans = "";

        while (low <= high) {

            int mid = low + (high - low) / 2;

            TimedValue curr = arr.get(mid);

            if (curr.time <= target) {
                ans = curr.value;
                low = mid + 1;      
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}