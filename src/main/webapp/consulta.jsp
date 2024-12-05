<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consulta RUC</title>
    <link rel="stylesheet" href="css/styles.css">
    <script>
        // Validar RUC antes de enviar
        function validarRUC() {
            const ruc = document.getElementById("ruc").value;
            if (ruc.length !== 13 || isNaN(ruc)) {
                alert("Por favor, ingrese un RUC válido de 13 dígitos.");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<header>
    <h1>Consulta de RUC</h1>
</header>

<main>
    <!-- Formulario para ingresar el RUC -->
    <form action="ConsultaRucServlet" method="post" onsubmit="return validarRUC()">
        <label for="ruc">Ingrese el RUC:</label>
        <input type="text" id="ruc" name="ruc" required>
        <button type="submit">Consultar</button>
    </form>
</main>
</body>
</html>

