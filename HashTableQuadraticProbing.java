public class HashTableQuadraticProbing {
    int[] keys;
    String[] values;
    private int size;
    int capacity;

    HashTableQuadraticProbing(int capacity) {
        this.capacity = capacity;
        size = 0;
        keys = new int[capacity];
        values = new String[capacity];

        for(int i = 0; i < capacity; i++) {
            keys[i] = -1;
        }
    }

    private int hashFunction(int key) {
        return key % capacity;
    }


    public void insert(int key, String value) {

        if(size == capacity) {
            System.out.println("Table is full");
            return;
        }


        int index = hashFunction(key);

        int prob = 1;

        while(keys[index] != -1) {
            index = (index + prob * prob) % capacity;
            prob++;
        }
        keys[index] = key;
        values[index] = value;
        size++;
    }

    public String search(int key) {
        int index = hashFunction(key);

        int prob = 1;

        while(keys[index] != -1) {
            index = (index + prob * prob) % capacity;
            prob++;

            if(keys[index] == key) {
                return values[index];
            }
        }
        return null;
    }

    public void delete(int key) {

        int index = hashFunction(key);
        int prob = 1;
        while(keys[index] != -1) {
            index = (index + prob * prob) % capacity;
            prob++;

            if(keys[index] == key) {
                keys[index] = -1;
                values[index] = null;
            }
            size--;
            System.out.println("key deleted: "+key);
        }
        System.out.println("key not found");
    }
    public void printTable() {
        for(int i = 0; i < capacity; i++) {
            System.out.println("index" + ":  " + i + "-> "+ keys[i] + " : " + values[i]);
        }
    }


    public static void main(String[] args) {
        HashTableQuadraticProbing htqb = new HashTableQuadraticProbing(10);
        htqb.insert(10, "navam");
        htqb.insert(11,"sharma");
        htqb.printTable();
    }

}