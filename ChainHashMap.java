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

    public ChainHashMap(int numberOfBuckets) {
        buckets = new ArrayList<Node>(numberOfBuckets);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String get(String key) {

        return null;
    }

    @Override
    public String put(String key, String value) {
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
