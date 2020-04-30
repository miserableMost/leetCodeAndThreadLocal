package medium2.T284;

import java.util.Iterator;
import java.util.LinkedList;

public class PeekingIterator implements Iterator<Integer> {
    private LinkedList<Integer> list;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        list = new LinkedList<>();
        while(iterator.hasNext()) {
            list.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(list.isEmpty()) {
            return -100000;
        }
       return list.peek();
    }

    @Override
    public boolean hasNext() {

        return !list.isEmpty();
    }

    @Override
    public Integer next() {

        return list.poll();
    }
}
