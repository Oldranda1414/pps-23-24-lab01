package tdd2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CircularList2Impl implements CircularList2 {

    private ArrayList<Integer> list = new ArrayList<Integer>();

    @Override
    public void add(int element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return Collections.emptyIterator();
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return Collections.emptyIterator();
    }
    
}
