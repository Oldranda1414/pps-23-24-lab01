package tdd3;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;

public class CircularList3Impl implements CircularList3{

    private ArrayList<Integer> list = new ArrayList<Integer>();

    @Override
    public void add(int element) {
        this.list.add(element);
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
    public Optional<Integer> next() {
        return Optional.ofNullable(null);
    }

    @Override
    public Optional<Integer> previous() {
        return Optional.ofNullable(null);
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }

    @Override
    public Optional<Integer> filteredNext(Function<Integer, Boolean> filter) {
        return Optional.ofNullable(null);
    }
    
}
