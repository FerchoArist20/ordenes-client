package com.ordenes.handler;

import com.ordenes.model.Request;

public abstract class Handler {
    protected Handler next;

    public Handler setNext(Handler handler) {
        this.next = handler;
        return handler;
    }

    public boolean handle(Request request) {
        if (next != null) {
            return next.handle(request);
        }
        return true;
    }
}
