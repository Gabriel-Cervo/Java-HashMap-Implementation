import java.util.ArrayList;
import java.util.Map.Entry;

class Node {
    String key, value;
    Node next;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }
}

public class ChainHashMap extends AbstractMap {
    private ArrayList<Node> buckets;
    private int size;

    public ChainHashMap(int size) {
        this.size = size;
        initializeBuckets();
    }

    private void initializeBuckets() {
        buckets = new ArrayList<Node>(this.size);
        for (int i = 0; i < this.size; i++) {
            buckets.add(null);
        }
    }

    private int compress(long hash) {
        return (int) (hash % this.size);
    }

    private int getIndex(String key) {
        int hash = key.hashCode();
        int index = compress(hash);

        return index < 0 ? index * -1 : index;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String get(String key) {
        int index = getIndex(key);
        Node head = buckets.get(index);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    @Override
    public String put(String key, String value) {
        int index = getIndex(key);
        Node head = buckets.get(index);
        while (head != null) {
            if (head.key.equals(key)) {
                String lastValue = head.value;
                head.value = value;
                return lastValue;
            }
            head = head.next;
        }

        return null;
    }

    @Override
    public String remove(String key) {
        return null;
    }

    @Override
    public Iterable<String> keySet() {
        return null;
    }

    @Override
    public Iterable<String> values() {
        return null;
    }

    @Override
    public Iterable<Entry<String, String>> entrySet() {
        return null;
    }

}
