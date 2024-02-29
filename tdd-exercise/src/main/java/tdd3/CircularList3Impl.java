package tdd3;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;

public class CircularList3Impl implements CircularList3{

    private ArrayList<Integer> list = new ArrayList<Integer>();
    private int currentIndex = 0;

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
        return this.performStep("forward");
    }

    @Override
    public Optional<Integer> previous() {
        return this.performStep("backward");
    }

    @Override
    public void reset() {
        this.currentIndex = 0;
    }

    @Override
    public Optional<Integer> filteredNext(Function<Integer, Boolean> filter) {
        return Optional.ofNullable(null);
    }

    private Optional<Integer> performStep(String type){
        final int FORWARD_STEP = 1;
        final int BACKWARD_STEP = -1;

        if(this.isEmpty()){
            return Optional.ofNullable(null);
        }

        int value = this.list.get(this.currentIndex);
        
        int step;
        if(type.equals("forward")){
            step = FORWARD_STEP;
        } 
        else{
            step = BACKWARD_STEP;
        } 
        this.currentIndex = this.currentIndex + step;
        this.fixIndex();
        return Optional.of(value);
    }

    private void fixIndex(){
        if(this.currentIndex >= this.size()){
            this.currentIndex = this.currentIndex - this.size();
        }
        else if(this.currentIndex < 0){
            this.currentIndex = this.currentIndex + this.size();
        }
    }
    
}
