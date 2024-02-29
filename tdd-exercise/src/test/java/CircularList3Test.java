import org.junit.jupiter.api.BeforeAll;

import tdd3.CircularList3;
import tdd3.CircularList3Impl;

public class CircularList3Test {
    private CircularList3 circularList;

    @BeforeAll
    void BeforeAll(){
        circularList = new CircularList3Impl();
    }
}
