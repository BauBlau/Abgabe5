package Abgabe5;
//test
public class HashTableArrayDemo {
    public static void main(String[] args) {
        HashTableArray<Integer> hm= new HashTableArray<>(10);
        hm.put(1, 77);
        hm.put(2, 88);
        hm.put(3, 99);

        System.out.println(hm.get(3));
    }
}
