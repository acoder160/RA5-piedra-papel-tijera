<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Piedra, Papel o Tijera</title>
</head>
<body>
    <h1>Juego: Piedra, Papel o Tijera</h1>

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
</body>
</html>