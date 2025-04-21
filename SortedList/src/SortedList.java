import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> list = new ArrayList<>();

    public void add(String value) {
        int index = binarySearch(value);
        if (index < 0) {
            index = -index - 1;
        }
        list.add(index, value);
    }

    public int binarySearch(String key) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(list.get(mid));
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -(low + 1); // not found
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(i).append(": ").append(list.get(i)).append("\n");
        }
        return sb.toString();
    }
}
