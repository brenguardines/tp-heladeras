package ar.edu.utn.frba.dds.server.handlers;

import io.javalin.Javalin;

// Los Handlers atrapan excepciones particualres y hacen algo en particular una vez que las atrapan.

public interface IHandler {
    void setHandle(Javalin javalin);
}
