package base;

import com.google.common.base.Throwables;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by wufan on 15/11/11.
 */
public class ThrowablesTest {

    @Test (expected = RuntimeException.class)
    public void testPropagation() {
        Throwables.propagate(new RuntimeException());
    }

    @Test (expected = RuntimeException.class)
    public void testPropagation2() {
        Throwables.propagate(new IOException());
    }

    @Test
    public void testPropagationIfInstanceOf() throws IOException {
        FileNotFoundException e = new FileNotFoundException();
        try {
            Throwables.propagateIfInstanceOf(e, IOException.class);
        } catch (IOException e1){
        }
    }

    @Test
    public void testPropagationIfInstanceOf2() throws IOException {
        SQLException e = new SQLException();
        Throwables.propagateIfInstanceOf(e, IOException.class);
    }

    @Test
    public void testPropagationIfPossible() {
        Throwables.propagateIfPossible(new IOException());
    }

    @Test (expected = NullPointerException.class)
    public void testPropagationIfPossible2() {
        Throwables.propagateIfPossible(new NullPointerException());
    }
}
