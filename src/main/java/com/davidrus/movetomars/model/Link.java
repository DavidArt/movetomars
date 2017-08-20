package com.davidrus.movetomars.model;

/**
 * @author david
 * <p>
 * Self refering link, used to get the
 * resource directly, by Id number
 */
public class Link {

    /**
     * A self instance where we store the URI to
     * the module object
     */
    private Self self;

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }
}
