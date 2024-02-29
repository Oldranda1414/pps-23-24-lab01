import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd3.CircularList3;
import tdd3.CircularList3Impl;

public class CircularList3Test {
    private CircularList3 circularList;

    @BeforeEach
    void BeforeAll(){
        circularList = new CircularList3Impl();
    }

    @Test
    void testEmptyList(){
        assertAll(
            () -> assertTrue(circularList.isEmpty()),
            () -> assertEquals(0, circularList.size())
        );
    }
}
