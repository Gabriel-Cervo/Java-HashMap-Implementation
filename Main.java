public class Main {
    public static void main(String[] args) {
        ChainHashMap hashMap = new ChainHashMap(10000);
        ChainHashMap hashMap2 = new ChainHashMap(100);

        for (int i = 0; i < 1000000; i += 2) {
            String[] pares = { "a" + i, "" + (i + 1) };
            hashMap.add(pares[0], pares[1]);
        }

        for (int i = 0; i < 1000000; i += 2) {
            String[] pares = { "b" + i, "" + (i + 1) };
            hashMap2.add(pares[0], pares[1]);
        }

        System.out.println(hashMap.getLoadFactor());
        System.out.println(hashMap2.getLoadFactor());
    }
}
