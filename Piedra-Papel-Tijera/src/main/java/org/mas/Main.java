package org.mas;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinFreemarker;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
        // POST para procesar la jugada
        app.post("/jugar", ctx -> {
            // Recogemos los datos del formulario
            String nombre = ctx.formParam("nombre");
            int jugadaUsuario = Integer.parseInt(ctx.formParam("jugada"));

            // La maquina elige un numero aleatorio (1, 2 o 3)
            Random rand = new Random();
            int jugadaMaquina = rand.nextInt(3) + 1;

            // traducimos los nombres
            String textoUsuario = numeroATexto(jugadaUsuario);
            String textoMaquina = numeroATexto(jugadaMaquina);

            // Calcular el ganador
            String mensaje = "";
            if (jugadaUsuario == jugadaMaquina) {
                mensaje = "!" + nombre + " y maquina han empatado¡";
            } else if ((jugadaUsuario == 1 && jugadaMaquina == 3) ||
                    (jugadaUsuario == 3 && jugadaMaquina == 2) ||
                    (jugadaUsuario == 2 && jugadaMaquina == 1)) {
                mensaje = "¡" + nombre + ", has ganado!";
            } else {
                mensaje = "La máquina gana, ¡lo siento " + nombre + "!";
            }

            // Mandar todos los resultados a la vista de FreeMarker
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("finalizado", true); // variable que controla el if del ftl
            modelo.put("nombre", nombre);
            modelo.put("eleccionJugador", textoUsuario);
            modelo.put("eleccionMaquina", textoMaquina);
            modelo.put("mensaje_resultado", mensaje);

            ctx.render("juego.ftl", modelo);
        });
    }

    // convertir el numero al texto
    private static String numeroATexto(int numero) {
        if (numero == 1) return "Piedra";
        if (numero == 2) return "Papel";
        if (numero == 3) return "Tijera";
        return "Error";
    }
}
