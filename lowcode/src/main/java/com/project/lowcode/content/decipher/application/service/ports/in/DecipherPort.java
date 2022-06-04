package com.project.lowcode.content.decipher.application.service.ports.in;

import java.io.IOException;

public interface DecipherPort {
    void decipher(String id) throws IOException, InterruptedException, IllegalAccessException;
}
