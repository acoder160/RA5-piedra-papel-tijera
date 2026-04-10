package org.mas;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinFreemarker;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Levantamos el servidor Freemarker
        Javalin app = Javalin.create(config -> {
            config.fileRenderer(new JavalinFreemarker());
        }).start(7070);

        // GET para mostrar el formulario
        app.get("/", ctx -> {
            Map<String, Object> modelo = new HashMap<>();
            ctx.render("juego.ftl", modelo);
        });
    }
}