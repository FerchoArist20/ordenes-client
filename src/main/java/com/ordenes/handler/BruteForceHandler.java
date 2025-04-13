package com.ordenes.handler;

import com.ordenes.model.Request;
import org.springframework.stereotype.Component;

@Component
public class BruteForceHandler extends Handler {
    @Override
    public boolean handle(Request request) {
        if ("user123".equals(request.user) && "pass123".equals(request.credentials)) {
            System.out.println("✅ Usuario autenticado");
            return super.handle(request);
        } else {
            System.out.println("❌ Fallo de autenticación");
            return false;
        }
    }
}
