public class Main {
    public static void main(String[] args) {
        ChainHashMap hashMap = new ChainHashMap(4);
        hashMap.add("Joao", "doce");
        hashMap.add("Thamires", "Morango");
        hashMap.add("a", "Morango");
        System.out.println(hashMap.size());
        System.out.println(hashMap.remove("Joao"));
        System.out.println(hashMap.remove("Thamires"));
        System.out.println(hashMap.size());
        System.out.println(hashMap.isEmpty());
    }
}
