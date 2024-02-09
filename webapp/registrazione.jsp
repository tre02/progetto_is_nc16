<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="ParteCSS/Registrazione.css">
    <title>Registrazione</title>
    <script>
        function validateRegistrazione(){
            var email = document.getElementById('email').value;
            var emailRGX = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
            if((emailRGX.test(email)==false)){
                alert("Formato email non valido!");
                return false;
            }

            var passwordRGX=/^[a-zA-Z0-9!@?]*$/;
            var password = document.getElementById('password').value;
            if((passwordRGX.test(password))==false){
                alert("Caratteri password non validi!");
                return false;
            }
            if((password.length<8 ||password.length>30 ))
            {
                alert("Dimensione password non valida!");
                return false;
            }

            var nomeRGX=/^[a-zA-Z' ']*$/;
            var nome=document.getElementById('nome').value;

            if((nomeRGX.test(nome))==false){
                alert("Nome non valido!");
                return false;
            }

            var cognomeRGX=/^[a-zA-Z' ']*$/;
            var cognome=document.getElementById('cognome').value;
            if((cognomeRGX.test(cognome))==false){
                alert("Cognome non valido!");
                return false;
            }

        }

    </script>
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
    <button onclick="return(validateRegistrazione())" type="submit" class="cart">Registrati</button>
    <p style="color: #1959bb; text-align: center"></p>
</form>
<br>

</body>
</html>
