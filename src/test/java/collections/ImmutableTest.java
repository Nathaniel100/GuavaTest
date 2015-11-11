package collections;

import com.google.common.collect.ImmutableSet;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wufan on 15/11/11.
 */
public class ImmutableTest {
    private ImmutableSet<String> ALPHAS;
    private List<String> strs = new ArrayList<String>();
    private String[] alphaArray = {"a", "b", "c", "d", "e"};


    @Before
    public void setUp() {
        ALPHAS = ImmutableSet.of("a", "b", "c", "d", "e");
        strs.add("1");
        strs.add("a");
        strs.add("z");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAdd() {
        ALPHAS.add("z");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testClear() {
        ALPHAS.clear();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddAll() {
        ALPHAS.addAll(strs);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRemove() {
        ALPHAS.remove("a");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRemoveAll() {
        ALPHAS.removeAll(strs);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRetainAll() {
        ALPHAS.retainAll(strs);
    }


    @Test
    public void testSupportedOperation() throws UnsupportedOperationException {
        assertTrue(ALPHAS.contains("a"));
        assertFalse(ALPHAS.contains("1"));
        assertFalse(ALPHAS.containsAll(strs));
        assertFalse(ALPHAS.isEmpty());
        assertArrayEquals(alphaArray, ALPHAS.toArray());
    }
}
