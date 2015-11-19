package base;

import com.google.common.collect.Ordering;
import com.luffy.Foo;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * CFCA Copyright
 * Created by wufan on 15/11/17.
 */
public class OrderingTest {

    private Foo f1, f2, f3, f4;

    @Before
    public void setUp() {
        f1 = new Foo(1, "a");
        f2 = new Foo(1, "a");
        f3 = new Foo(2, "a");
        f4 = new Foo(0, "b");
    }

    @Test
    public void testCreation() {
        Ordering<Foo> fooOrderingNatural = Ordering.natural();
        Ordering<Object> fooOrderingString = Ordering.usingToString();
        testCompare(fooOrderingNatural);
        testCompare(fooOrderingString);
    }

    private void testCompare(Ordering<? super Foo> ordering) {
        assertEquals(0, ordering.compare(f1, f2));
        assertEquals(-1, ordering.compare(f1, f3));
        assertEquals(1, ordering.compare(f1, f4));
    }

}
