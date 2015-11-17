package base;

import com.google.common.base.Objects;
import com.luffy.Foo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * CFCA Copyright
 * Created by wufan on 15/11/17.
 */
public class ObjectMethodsTest {

    private Foo f1, f2, f3, f4;

    @Before
    public void setUp() {
        f1 = new Foo(1, "a");
        f2 = new Foo(1, "a");
        f3 = new Foo(2, "a");
        f4 = new Foo(2, "b");
    }


    @Test
    public void testEquals() {
        assertTrue(Objects.equal(null, null));
        assertFalse(Objects.equal("a", "b"));
        assertFalse(Objects.equal("a", null));
        assertFalse(Objects.equal(null, "b"));
        assertTrue(Objects.equal(f1, f2));
        assertFalse(Objects.equal(f1, f3));
        assertFalse(Objects.equal(f1, f4));
        assertEquals(f1, f2);
    }

    @Test
    public void testHashCode() {
        assertEquals(f1.hashCode(), f2.hashCode());
        assertFalse(Objects.equal(f1.hashCode(), f3.hashCode()));
        assertFalse(Objects.equal(f1.hashCode(), f4.hashCode()));
    }

    @Test
    public void testToString() {
        assertEquals("Foo{x=1, s=a}", f1.toString());
        assertEquals(f1.toString(), f2.toString());
        assertFalse(Objects.equal(f1.toString(), f3.toString()));
        assertFalse(Objects.equal(f1.toString(), f4.toString()));
    }

    @Test
    public void testComparator() {
        Foo f5 = new Foo(0, "b");
        assertEquals(0, f1.compareTo(f2));
        assertEquals(-1, f1.compareTo(f3));
        assertEquals(-1, f1.compareTo(f4));
        assertEquals(1, f4.compareTo(f3));
        assertEquals(1, f1.compareTo(f5));
    }


}
