package HashAlgorithm.main;

public class HashArray {

    private int size;

    private Item[] hashArray;

    private class Item {
        private int key = Integer.MIN_VALUE;
        private boolean markAsDeleted = false;

        public Item(int key) {
            super();
            this.key = key;
        }

        void markAsDeleted() {
            this.key = Integer.MIN_VALUE;
            this.markAsDeleted = true;
        }
    }


    public HashArray(int size) {
        super();
        this.size = size;
        this.hashArray = new Item[size];
    }

    public boolean isFree(int idx) {
        return this.hashArray[idx] == null;
    }

    public boolean isMarkAsDeleted(int idx) {
        return this.hashArray[idx].markAsDeleted;
    }

    public boolean compareKeys(int idx, int key) {
        return this.hashArray[idx].key == key;
    }

    public int get(int idx) {
        return this.hashArray[idx].key;
    }

    public void set(int idx, int key) {
        this.hashArray[idx] = new Item(key);
    }

    public void markAsDeleted(int idx) {
        this.hashArray[idx].markAsDeleted();
    }

    public void clear() {
        this.hashArray = new Item[size];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (Item item : hashArray) {
            if (item == null) {
                builder.append("**, ");
            } else {
                builder.append(item.markAsDeleted ? "##, " : item.key + ", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

}
