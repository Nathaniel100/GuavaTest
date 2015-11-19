package base;

import java.io.Serializable;

/**
 * Created by wufan on 15/11/18.
 */
public class BaseComparable implements Comparable<BaseComparable>, Serializable{
    private final String s;

    public BaseComparable(String s) {
        this.s = s;
    }

    @Override
    public int hashCode() {
        return s.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        else if(obj instanceof BaseComparable) {
            return s.equals(((BaseComparable)obj).s);
        } else {
            return false;
        }
    }

    public int compareTo(BaseComparable o) {
        return s.compareTo(o.s);
    }
}
