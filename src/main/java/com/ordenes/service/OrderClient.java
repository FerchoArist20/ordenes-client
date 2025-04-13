package com.ordenes.service;

import com.ordenes.handler.*;
import com.ordenes.model.Request;
import org.springframework.stereotype.Service;

@Service
public class OrderClient {
    private final Handler chain;

    public OrderClient(AuthenticationHandler auth,
                       BruteForceHandler brute,
                       AuthorizationHandler authz,
                       SanitizationHandler sanitizer,
                       CacheHandler cache) {

        auth.setNext(brute)
            .setNext(authz)
            .setNext(sanitizer)
            .setNext(cache);

        this.chain = auth;
    }

    public boolean processRequest(Request request) {
        return chain.handle(request);
    }
}
