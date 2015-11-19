package collections;

import base.DerivedComparable;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by wufan on 15/11/16.
 * Multiset Unit Test
 */
public class MultisetTest {

    @Test
    public void testMethods() {
        Multiset<DerivedComparable> treeMS = TreeMultiset.create();
        assertTrue(treeMS.size() == 0);
        treeMS.add(new DerivedComparable("Multi"));
        treeMS.add(new DerivedComparable("Set"), 2);
        treeMS.add(new DerivedComparable("Unit"), 3);
        assertEquals(6, treeMS.size());
        assertThat(treeMS.count(new DerivedComparable("Test")), is(0));
        assertEquals(1, treeMS.count(new DerivedComparable("Multi")));
        assertThat(treeMS, hasItems(
                new DerivedComparable("Multi"),
                new DerivedComparable("Set"),
                new DerivedComparable("Unit")));
        treeMS.setCount(new DerivedComparable("Multi"), 2);
        treeMS.setCount(new DerivedComparable("Test"), 1);
        assertThat(treeMS.count(new DerivedComparable("Test")), is(1));
        assertEquals(2, treeMS.count(new DerivedComparable("Multi")));
        assertEquals(8, treeMS.size());
        assertThat(treeMS, hasItem(new DerivedComparable("Test")));

        for(Multiset.Entry<DerivedComparable> entry : treeMS.entrySet()) {
            assertThat(entry.getElement(), anyOf(
                    is(new DerivedComparable("Multi")),
                    is(new DerivedComparable("Set")),
                    is(new DerivedComparable("Unit")),
                    is(new DerivedComparable("Test"))
            ));
        }
    }


}
