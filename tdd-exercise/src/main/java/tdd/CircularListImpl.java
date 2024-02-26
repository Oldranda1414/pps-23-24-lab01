package tdd;

import java.util.ArrayList;
import java.util.Optional;

public class CircularListImpl extends ArrayList<Integer> implements CircularList{

    private int currentIndex = 0;

    @Override
    public void add(int element) {
        super.add(element);
    }

    @Override
    public Optional<Integer> next() {
        if(this.isEmpty()){
            return Optional.ofNullable(null);
        }
        else{
            int result = this.get(this.currentIndex);
            this.currentIndex++;
            if(this.indexOutOfBounds()){
                currentIndex = 0;
            }
            return Optional.ofNullable(result);
        }
    }

    @Override
    public Optional<Integer> previous() {
        if(this.isEmpty()){
            return Optional.ofNullable(null);
        }
        else{
            if(this.currentIndex == 0){
                this.currentIndex = this.size();
            }
            int result = this.get(--this.currentIndex);
            return Optional.ofNullable(result);
        }
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }

    private boolean indexOutOfBounds(){
        return (this.currentIndex >= this.size());
    }
}