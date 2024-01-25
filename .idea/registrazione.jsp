<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="ParteCSS/Registrazione.css">
    <title>Registrazione</title>
</head>
<body>
<img src="logo.png" class="sfondo" height="101" width="85">
<form method="post" action="RegistrazioneServlet">
    <table>
        <tr>
            <th>
                <label for="nome">Inserisci il nome</label><br>
                <input type="text" placeholder="Mario" name="nome" id="nome" required><br>
                <label for="cognome">Inserisci il cognome</label><br>
                <input type="text" placeholder="Rossi" name="cognome" id="cognome" required><br>
                <label for="email">Inserisci l'email</label><br>
                <input type="email" placeholder="prova@esempio.it" name="email" id="email" required><br>
                <label for="password">Inserisci la password</label><br>
                <input type="password" placeholder="Esempio2!" name="password" id="password" required ><br>


            </th>

        </tr>
    </table>
    <button onclick="return(doSave())" type="submit" class="cart">Registrati</button>
    <p style="color: #1959bb; text-align: center"></p>
</form>
<br>

</body>
</html>
