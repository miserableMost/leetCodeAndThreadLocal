package hash;

import Test.April.utils.HashFamily;

import java.util.Random;

public class CuckooHashTable<Integer>{
    private static final double MAX_LOAD = 0.4;
    private static final int ALLOWED_REHASHES = 1;
    private static final int DEFAULT_TABLE_SIZE = 101;

    private final HashFamily<? super Integer> hashFunctions;
    private final int numHashFunctions;
    private Integer [] array;
    private int currentSize;

    public CuckooHashTable(HashFamily<? super Integer> hf) {
        this(hf,DEFAULT_TABLE_SIZE);

    }

    public CuckooHashTable(HashFamily<? super Integer> hf,int size) {
        allocateArray(nextPrime(size));
        doClear();
        hashFunctions = hf;
        numHashFunctions = hf.getNumberOfFunctions();
    }

    public void makeEmpty(){
        doClear();
    }

    public boolean contains(Integer x){
        return findPos(x) != -1;
    }

    private int myhash(Integer x,int which){
        int hashVal = hashFunctions.hash(x,which);
        hashVal %= array.length;
        if(hashVal < 0)
            hashVal += array.length;
        return hashVal;
    }

    private int findPos(Integer x){
        for (int i = 0; i < numHashFunctions; i++) {
            int pos = myhash(x,i);
            if(array[pos] != null && array[pos].equals(x))
                return pos;
        }
        return -1;
    }

    public boolean remove(Integer x){
        int pos = findPos(x);
        if(pos != -1){
            array[pos] = null;
            currentSize --;
        }
        return pos != -1;
    }

    public boolean insert(Integer x){
        if(contains(x))
            return false;
        if(currentSize >= array.length * MAX_LOAD)
            expand();
        return insertHelperl(x);
    }

    private int rehashes = 0;
    private Random r = new Random();
    private boolean insertHelperl(Integer x) {
        final int COUNT_LIMIT = 100;
        while(true){
            int lastPos = -1;
            int pos;
            for (int count = 0; count < COUNT_LIMIT; count++) {
                for (int i = 0; i < numHashFunctions; i++) {
                    pos = myhash(x,i);
                    if(array[pos] == null){
                        array[pos] = x;
                        currentSize ++;
                        return true;
                    }
                }
                int i = 0;
                do{
                    pos = myhash(x,r.nextInt(numHashFunctions));
                }while(pos == lastPos && i++ < 5);

                Integer tmp = array[lastPos = pos];
                array[pos] = x;
                x = tmp;
            }
            if(++rehashes > ALLOWED_REHASHES){
                expand();
                rehashes = 0;
            }else{
                rehash();
            }
        }
    }
    //布谷鸟散列表的再散列和扩展代码
    private void expand() {
        rehash((int) (array.length / MAX_LOAD));
    }

    private void rehash(){
        hashFunctions.generateNewFunctions();
        rehash();
    }
    private void rehash(int newLength){
        Integer[] oldArray = array;
        allocateArray(nextPrime(newLength));
        currentSize = 0;
        for (Integer str : oldArray) {
            if(str != null)
                insert(str);
        }
    }

    private int nextPrime(int size) {
        return 0;
    }


    private void allocateArray(int arraySize){
        array = (Integer []) new Object[arraySize];
    }
    private void doClear(){
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }
}
