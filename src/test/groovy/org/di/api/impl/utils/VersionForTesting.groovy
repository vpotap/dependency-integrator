package org.di.api.impl.utils

import groovy.transform.ToString
import org.di.api.Version

@ToString
class VersionForTesting implements Version {

    int value

    @Override
    Version increment() {
        return new VersionForTesting(value: value+1)
    }

    @Override
    boolean before(Version other) {
        assert other instanceof VersionForTesting
        return value < (other as VersionForTesting).value
    }

    @Override
    boolean after(Version other) {
        return !before(other) && (other as VersionForTesting).value != value
    }
}