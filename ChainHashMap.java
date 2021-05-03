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
    private int capacity;
    private int size;

    public ChainHashMap() {
        this.capacity = 10;
        initializeBuckets();
    }

    public ChainHashMap(int capacity) {
        this.capacity = capacity;
        initializeBuckets();
    }

    private void initializeBuckets() {
        buckets = new ArrayList<Node>(capacity);
        size = 0;
        for (int i = 0; i < capacity; i++) {
            buckets.add(null);
        }
    }

    public Double getLoadFactor() {
        return (double) this.size / (double) this.capacity;
    }

    private Node getHead(String key) {
        int index = getIndex(key);
        return buckets.get(index);
    }

    private int getIndex(String key) {
        int hash = key.hashCode();
        int index = compress(hash);
        return index < 0 ? index * -1 : index;
    }

    private int compress(long hash) {
        return (int) (hash % this.capacity);
    }

    public void add(String key, String value) {
        Node head = getHead(key);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        head = getHead(key);
        int indexInList = getIndex(key);
        Node newValue = new Node(key, value);
        newValue.next = head;
        buckets.set(indexInList, newValue);
        size++;

        if (getLoadFactor() >= 0.75) {
            doubleCapacity();
        }
    }

    private void doubleCapacity() {
        ArrayList<Node> tempList = buckets;
        capacity *= 2;
        initializeBuckets();

        for (Node item : tempList) {
            while (item != null) {
                add(item.key, item.value);
                item = item.next;
            }
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String get(String key) {
        Node head = getHead(key);
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
        Node head = getHead(key);
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
        int index = getIndex(key);
        Node head = getHead(key);
        Node prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                size--;
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    buckets.set(index, head.next);
                }
                return head.value;
            }
            prev = head;
            head = head.next;
        }

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
