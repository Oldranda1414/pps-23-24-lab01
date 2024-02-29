package tdd2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CircularList2Impl implements CircularList2 {

    private ArrayList<Integer> list = new ArrayList<Integer>();
    private int currentSize = 0;

    @Override
    public void add(int element) {
        this.list.add(element);
        this.currentSize++;
    }

    @Override
    public int size() {
        return this.currentSize;
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        if(this.isEmpty()){
            return Collections.emptyIterator();
        }
        return new Iterator<Integer>(){

            private int currentIndex = 0;
            
            @Override
            public Integer next(){
                int value = list.get(this.currentIndex);
                this.currentIndex++;
                fixIndex();
                return value;
            }

            @Override
            public boolean hasNext(){
                return true;
            }

            private void fixIndex(){
                if (this.currentIndex < 0){
                    this.currentIndex = this.currentIndex + currentSize;
                }
                else if(this.currentIndex >= currentSize){
                    this.currentIndex = this.currentIndex - currentSize;
                }
            }
        };
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return Collections.emptyIterator();
    }
    
}
