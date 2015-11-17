package com.luffy;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

/**
 * CFCA Copyright
 * Created by wufan on 15/11/17.
 */
public class Foo implements Comparable<Foo>{
    private int x;
    private String s;

    public Foo(int x, String s) {
        this.x = x;
        this.s = s;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        else if(obj == this) return true;
        else if(!(obj instanceof Foo)) return false;
        Foo f = (Foo) obj;
        return x == f.x && Objects.equal(s, f.s);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x, s);
    }

    @Override
    public String toString() {
        return MoreObjects
                .toStringHelper(this)
                .add("x", x)
                .add("s", s)
                .toString();
    }

    public int compareTo(Foo that) {
        return ComparisonChain.start()
                .compare(this.x, that.x)
                .compare(this.s, that.s)
                .result();
    }
}
