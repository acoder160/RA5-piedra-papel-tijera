<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Piedra, Papel o Tijera</title>
</head>
<body>
    <h1>Juego: Piedra, Papel o Tijera</h1>

    <#if finalizado??>
        <h2>Resultados de la partida:</h2>
        <p>Jugador <b>${nombre}</b> ha eligido: ${eleccionJugador}</p>
        <p>La maquina ha eligido: ${eleccionMaquina}</p>

        <h3>${mensaje_resultado}</h3>

        <br>
        <a href="/">Volver a jugar</a>
    <#else>
        <form action="/jugar" method="POST">
            <label for="nombre">Escribe tu nombre:</label>
            <input type="text" id="nombre" name="nombre" required><br><br>

            <p>Elige tu arma:</p>
            <input type="radio" id="piedra" name="jugada" value="1" required>
            <label for="piedra">Piedra</label><br>

            <input type="radio" id="papel" name="jugada" value="2">
            <label for="papel">Papel</label><br>

            <input type="radio" id="tijera" name="jugada" value="3">
            <label for="tijera">Tijera</label><br><br>

            <button type="submit">Jugar</button>
        </form>
    </#if>
</body>
</html>