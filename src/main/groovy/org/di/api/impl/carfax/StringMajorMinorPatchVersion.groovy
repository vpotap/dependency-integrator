package org.di.api.impl.carfax;

import org.di.api.Version;

public class StringMajorMinorPatchVersion implements Version {
    private final String value;
    int major = -1
    int minor = -1
    int patch = -1

    public StringMajorMinorPatchVersion(String v) {
        String k = v
        if (k.contains("-SNAPSHOT")) {
          k = k-'-SNAPSHOT'
          int[] versions = mmpFromString(k)
            if (versions[2]==0) {
                versions[1] = versions[1]-1
            } else (
              versions[2] = versions[2]-1
            )
            k = versions.collect {it.toString()}.join(".")
            assignMMP(versions)
        } else {
            assignMMP(mmpFromString(v))
        }
        this.value = k;
    }

    private assignMMP(int[] versions) {
        major = versions[0]
        minor = versions[1]
        patch = versions[2]
    }

    private static int[] mmpFromString(String input) {  // "2.3.4"
        input.split(/\./).collect {Integer.parseInt(it)}.toArray()

    }

    public String getValue() {
        return value;
    }

    @Override
    public Version increment() {
        return null;
    }

    @Override
    public boolean before(Version other) {
        assert other instanceof StringMajorMinorPatchVersion
        return other.major > major
    }

    @Override
    public boolean after(Version other) {
        return !before(other) && !equals(other);
    }

    @Override
    boolean equals(Object o) {
        boolean result = false
        if (o instanceof StringMajorMinorPatchVersion) {
          result = value == o.value
        }
        result
    }

    @Override
    public int hashCode() {
        value.hashCode()
    }

    @Override
    String toString() {
        return value
    }
}