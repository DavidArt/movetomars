package com.davidrus.movetomars.model;

/**
 * @author david
 *
 * Self refering link, used to get the
 * resource directly, by Id number
 */
public class Link {

    private Self self;

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }
}
