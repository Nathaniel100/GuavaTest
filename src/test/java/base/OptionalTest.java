package base;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

/**
 * Created by wufan on 2015/11/7.
 */
public class OptionalTest {
    private String str123456 = "123456";
    private String str123 = "123";
    private Optional optionalNormal123456;
    private Optional optionalNormal123;
    private Optional optionalNil;

    @Before
    public void setUp() {
        optionalNormal123456 = Optional.of(str123456);
        optionalNormal123 = Optional.fromNullable(str123);
        optionalNil = Optional.absent();
    }

    @Test
    public void testFromNull() throws NullPointerException {
        Optional.fromNullable(null);
    }

    @Test(expected = NullPointerException.class)
    public void testOfNull() {
        Optional.of(null);
    }

    @Test
    public void testOptionalNil() throws IllegalStateException{
        Assert.assertFalse(optionalNil.isPresent());
        try {
            optionalNil.get();
        } catch (IllegalStateException e) {
        }
        Assert.assertEquals(str123456, optionalNil.or(str123456));
        Assert.assertNull(optionalNil.orNull());
        Assert.assertEquals(Collections.emptySet(), optionalNil.asSet());
    }

    @Test
    public void testOptionalNormal() {
        Assert.assertTrue(optionalNormal123456.isPresent());
        Assert.assertEquals(str123456, optionalNormal123456.get());
        Assert.assertEquals(str123456, optionalNormal123456.or(str123));
        Assert.assertNotNull(optionalNormal123456.orNull());
        Assert.assertEquals(Collections.singleton(str123456), optionalNormal123456.asSet());
    }

    @Test
    public void testOthers() {
        Assert.assertEquals(str123, MoreObjects.firstNonNull(null, str123));
        Assert.assertEquals(str123, MoreObjects.firstNonNull(str123, optionalNil));
        Assert.assertEquals(str123, optionalNil.or(str123));
        Assert.assertEquals("", Strings.nullToEmpty(null));
        Assert.assertNotNull(Strings.emptyToNull(str123));
        Assert.assertNull(Strings.emptyToNull(""));
        Assert.assertTrue(Strings.isNullOrEmpty(""));
        Assert.assertTrue(Strings.isNullOrEmpty(null));
    }

}
