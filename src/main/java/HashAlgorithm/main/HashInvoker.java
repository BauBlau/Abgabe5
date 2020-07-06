package HashAlgorithm.main;

public class HashInvoker {

    static final String sMsgSearchForKey = "Search key '%d' in the hash table!";
    static final String sMsgSearchFoundKey = "Found key '%d' in hash table!";
    static final String sMsgRemoveKey = "Remove key '%d' from the hash table!";

    public static void insert(ADSHashTable table, int key) {
        try {
            table.insert(key);
            print(table.toString());
        } catch (Exception e) {
            flush(e);
        }
    }

    public static void search(ADSHashTable table, int key) {
        try {
            print(String.format(sMsgSearchForKey, key));
            print(String.format(sMsgSearchFoundKey, table.search(key)));
        } catch (Exception e) {
            flush(e);
        }
    }

    public static void remove(ADSHashTable table, int key) {
        try {
            print(String.format(sMsgRemoveKey, key));
            table.remove(key);
            print(table.toString());
        } catch (Exception e) {
            flush(e);
        }
    }

    private static void flush(Exception e) {
        System.out.flush();
        System.err.println("Exception: " + e.getMessage());
        System.err.flush();
    }

    public static void print(String text) {
        System.out.println(text);
        System.out.flush();
    }

    public static void clear(ADSHashTable table){
        try {
            table.clear();
            print("Table clear!");
        } catch (Exception e){
            flush(e);
        }
    }

}
