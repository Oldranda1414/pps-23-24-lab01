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
        return this.performStep("forward", Optional.ofNullable(null));
    }

    @Override
    public Optional<Integer> previous() {
        return this.performStep("backward", Optional.ofNullable(null));
    }

    @Override
    public void reset() {
        this.currentIndex = 0;
    }

    @Override
    public Optional<Integer> filteredNext(Function<Integer, Boolean> filter) {
        return this.performStep("forward", Optional.of(filter));
    }

    private Optional<Integer> performStep(String type, Optional<Function<Integer, Boolean>> filter){
        if(this.isEmpty()){
            return Optional.ofNullable(null);
        }
        else{

            final int FORWARD_STEP = 1;
            final int BACKWARD_STEP = -1;
            
            int value;
            int step;
    
            if(filter.isPresent()){
                value = this.findNextFiltered(filter.get());
            }
            else{
                value = this.list.get(this.currentIndex);
            }
            
            if(type.equals("forward")){
                step = FORWARD_STEP;
            } 
            else{
                step = BACKWARD_STEP;
            } 

            this.updateIndex(step);
            return Optional.of(value);
        }
    }

    private void fixIndex(){
        if(this.currentIndex >= this.size()){
            this.currentIndex = this.currentIndex - this.size();
        }
        else if(this.currentIndex < 0){
            this.currentIndex = this.currentIndex + this.size();
        }
    }

    private void updateIndex(int update){
        this.currentIndex = this.currentIndex + update;
        this.fixIndex();
    }

    private int findNextFiltered(Function<Integer, Boolean> filter){
        while(!filter.apply(this.list.get(this.currentIndex))){
            this.currentIndex++;
            this.fixIndex();
        }
        return this.list.get(this.currentIndex);
    }
    
}
