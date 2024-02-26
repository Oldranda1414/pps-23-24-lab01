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
            this.fixIndex();
            return Optional.ofNullable(result);
        }
    }

    @Override
    public Optional<Integer> previous() {
        if(this.isEmpty()){
            return Optional.ofNullable(null);
        }
        else{
            this.currentIndex--;
            this.fixIndex();
            int result = this.get(this.currentIndex);
            return Optional.ofNullable(result);
        }
    }

    @Override
    public void reset() {
        this.currentIndex = 0;
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