import java.util.Scanner;

public class HashTableLinearProbing {
    int[] keys;
    String[] values;
    int size;
    int capacity;

    HashTableLinearProbing(int capacity) {
        this.capacity = capacity;
        keys = new int[capacity];
        values = new String[capacity];
        size = 0;

        for(int i = 0; i < capacity; i++) {
            keys[i] = -1;
        }
    }

    private int hashFunction(int key) {
        return key % capacity;
    }

    public void insert(int key, String value) {

        if(size == capacity) {
            System.out.println("HashTable is Full");
            return;
        }

        int index = hashFunction(key);

        while(keys[index] != -1 && keys[index] != key) {
            index = (index + 1) % capacity;

        }
        keys[index] = key;
        values[index] = value;
        size++;
    }


    public String find(int key) {
        int index = hashFunction(key);


        while(keys[index] != -1) {
            index = (index + 1) % capacity;
        }
        if(key == keys[index]) {
            return values[index];
        }
        return null;
    }

    public void delete(int key) {
        int index = hashFunction(key);
        while(keys[index] != -1) {
            if(keys[index] == key) {
                keys[index] = -1;
                values[index] = null;
            }
            size--;
            System.out.println("key " + key + "deleted");
            return;
        }
        index = (index + 1) % capacity;
        System.out.println("key not found");
    }
    


    public void printTable() {
        for(int i = 0; i < capacity; i++) {
            System.out.println("index" + ":  " + i + "-> "+ keys[i] + " : " + values[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter capcacity : ");
        int capacity = sc.nextInt();
        HashTableLinearProbing htlp = new HashTableLinearProbing(capacity);

        htlp.insert(10,"navam");
        htlp.printTable();
    }
}