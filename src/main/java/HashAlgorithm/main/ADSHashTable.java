package HashAlgorithm.main;

import HashAlgorithm.hash.IHash;
import HashAlgorithm.probing.IProbing;

public class ADSHashTable {

    private static final String sMsgKeyInsertedAt = "Key '%d' inserted at index '%d' in hash table.";
    private static final String sMsgKeyMarkedAsDeleted = "Key '%d' mark as deleted at index '%d' in hash table.";
    private static final String sMsgKeyFoundAt = "Key '%d' found at index '%d' in hash table.";
    private static final String sMsgCollision = "Increment collision counter j++ -> %d : [index=%d, key=%d]";
    private static final String sExceptionMsgKeyNotFound = "Key '%d' not found in hash table!";
    private static final String sExceptionMsgNoFreeSpace = "No free space in hash table for key '%d'!";

    private int m;
    private IHash hashAlgorithm;
    private IProbing probingAlgorithm;
    private HashArray hashArray;
    private boolean debug;

    public ADSHashTable(int size, IHash hashAlgorithm, IProbing probingAlgorithm) {
        super();
        this.m = size;
        this.hashAlgorithm = hashAlgorithm;
        this.probingAlgorithm = probingAlgorithm;
        this.hashArray = new HashArray(size);
        this.debug = true;
    }

    private void debug(String s) {
        if (debug) {
            System.out.println("  " + s);
            System.out.flush();
        }
    }

    private int calculateIndex(int hashValue, int key, int j) {
        return Math.floorMod((hashValue - probingAlgorithm.probe(key, j)), m);
    }

    void insert(int key) throws Exception {
        int j = 0;
        int hashValue = hashAlgorithm.hash(key);
        do {
            int addr = calculateIndex(hashValue, key, j);
            if (hashArray.isFree(addr) || hashArray.isMarkAsDeleted(addr)) {
                hashArray.set(addr, key);
                debug(String.format(sMsgKeyInsertedAt, key, addr));
                return;
            }
            j++;
            debug(String.format(sMsgCollision, j, addr, this.hashArray.get(addr)));
        } while (j < m);
        throw new Exception(String.format(sExceptionMsgNoFreeSpace, key));
    }

    void remove(int key) throws Exception {
        int j = 0;
        int hashValue = hashAlgorithm.hash(key);
        do {
            int addr = calculateIndex(hashValue, key, j);
            if (hashArray.isFree(addr)) {
                break;
            }
            if (hashArray.compareKeys(addr, key)) {
                hashArray.markAsDeleted(addr);
                debug(String.format(sMsgKeyMarkedAsDeleted, key, addr));
                return;
            }
            j++;
            debug(String.format(sMsgCollision, j, addr, this.hashArray.get(addr)));
        } while (j < m);
        throw new Exception(String.format(sExceptionMsgKeyNotFound, key));
    }

    int search(int key) throws Exception {
        int j = 0;
        int hashValue = hashAlgorithm.hash(key);
        do {
            int addr = calculateIndex(hashValue, key, j);
            if (hashArray.isFree(addr)) {
                break;
            }
            if (hashArray.compareKeys(addr, key)) {
                debug(String.format(sMsgKeyFoundAt, key, addr));
                return hashArray.get(addr);
            }
            j++;
            debug(String.format(sMsgCollision, j, addr, this.hashArray.get(addr)));
        } while (j < m);
        throw new Exception(String.format(sExceptionMsgKeyNotFound, key));
    }

    void clear() {
        this.hashArray.clear();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(hashAlgorithm.toString());
        builder.append(" method with ");
        builder.append(probingAlgorithm.toString());
        builder.append(" - HashTable: ");
        builder.append(hashArray);
        return builder.toString();
    }

}
