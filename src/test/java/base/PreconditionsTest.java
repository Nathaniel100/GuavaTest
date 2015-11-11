package base;

import org.junit.Assert;
import org.junit.Test;

import static com.google.common.base.Preconditions.*;

/**
 * Created by wufan on 2015/11/7.
 */
public class PreconditionsTest {

    private final String str123 = "123";
    @Test
    public void testArgument() throws IllegalArgumentException{
        checkArgument(1==1);
        try {
            checkArgument(1 == 2);
        } catch (IllegalArgumentException e){
        }
    }

    @Test
    public void testNull() throws NullPointerException {
        Assert.assertEquals(str123, checkNotNull(str123));
        try {
            checkNotNull(null);
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testState() throws IllegalStateException {
        checkState(1==1);
        try {
            checkState(1 == 2);
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void testIndex() throws IndexOutOfBoundsException {
        checkElementIndex(0, str123.length());
        checkElementIndex(1, str123.length());
        try {
            checkElementIndex(3, str123.length());
        } catch (IndexOutOfBoundsException e) {
        }
        try {
            checkElementIndex(-1, str123.length());
        } catch (IndexOutOfBoundsException e) {
        }

        checkPositionIndex(0, str123.length());
        checkPositionIndex(3, str123.length());
        try {
            checkPositionIndex(4, str123.length());
        } catch (IndexOutOfBoundsException e) {
        }

        checkPositionIndexes(0, 3, str123.length());
        try {
            checkPositionIndexes(-1, 0, str123.length());
        } catch (IndexOutOfBoundsException e) {
        }
        try {
            checkPositionIndexes(1, 5, str123.length());
        } catch (IndexOutOfBoundsException e) {
        }
    }
}
