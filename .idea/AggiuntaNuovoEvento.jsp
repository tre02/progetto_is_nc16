<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiunta nuovo evento</title>
    <link rel="stylesheet" type="text/css" href="ParteCSS/AggiuntaProdotto.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script>
        function validateNewProduct(){
            var IdEvento=document.getElementById('ID_evento').value;
            var idEventoRGX=/^[A-Z0-9]*$/;
            var NomeEvento=document.getElementById('Nome_evento').value;
            var nomeEventoRGX=/^[a-zA-Z' ']*$/;
            var PostiDisponibili=document.getElementById('posti_disponibili')
            var postiDisponibiliRGX=/^[a-zA-Z' ']*$/;
            var Data=document.getElementById('data')
            var DataRGX=/^[a-zA-Z' ']*$/;
            var Luogo=document.getElementById('luogo')
            var LuogoRGX=/^[a-zA-Z' ']*$/;
            var Ora=document.getElementById('ora')
            var OraRGX=/^[a-zA-Z' ']*$/;
            var Prezzo=document.getElementById('prezzo').value;
            var PrezzoRGX=/^[0-9'.']*$/;
            var Tipo=document.getElementById('tipo').value;
            var TipoRGX=/^[0-9]*$/;

            if(idEventoRGX.test(IdEvento)==false){
                alert("Errore nella definizione dell'ID");
                return false;
            }

            if(nomeEventoRGX.test(NomeEvento)==false){
                alert("Errore nella definizione del nome");
                return false;
            }
            if(postiDisponibiliRGX.test(PostiDisponibili)==false){
                alert("Errore nella definizione dei posti disponibili");
                return false;
            }
            if(DataRGX.test(Data)==false){
                alert("Errore nella definizione della data");
                return false;
            }
            if(LuogoRGX.test(Luogo)==false){
                alert("Errore nella definizione del luogo");
                return false;
            }


            if(OraRGX.test(Ora)==false){
                alert("Errore nella definizione dell'ora");
                return false;
            }

            if(PrezzoRGX.test(Prezzo)==false){
                alert("Errore nella definizione del prezzo");
                return false;
            }

            if(TipoRGX.test(Tipo)==false){
                alert("Errore nella definizione del tipo");
                return false;
            }
            return true;
        }
    </script>
    <style>
        @media screen and (max-width: 1920px) {
            textarea{
                width: 80%;
            }
        }
        table {
            border: 3px solid green;
            padding: 5px;
            border-collapse: collapse;
            margin-left: auto;
            margin-right: auto;
            margin-top: 5%;
            width: 50%;
        }
    </style>
</head>
<body>
<form method="post" action="AggiuntaEventoServlet">
    <table>
        <tr>
            <th class="inserimento1">
                <label for="IdEvento">Inserisci l'id dell'evento:</label>
                <input type="text" name="IdEvento" id="IdEvento" required> <br>

                <label>Scegli il tipo di evento:</label>
                <select name="Tipo">
                    <option id="Concerti"> Concerto </option>
                    <option id="Sport"> Sport </option>
                    <option id="Teatro"> Teatro </option>
                    <option id="Mostreemusei"> Mostre e Musei </option>
                </select><br>

                <label>Scegli il luogo dell'evento:</label>
                <select name="Luogo">
                    <option id="Ancona">Ancona</option>
                    <option id="Bari">Bari</option>
                    <option id="Bologna">Bologna</option>
                    <option id="Catania">Catania</option>
                    <option id="Firenze">Firenze</option>
                    <option id="Genova">Genova</option>
                    <option id="Lucca">Lucca</option>
                    <option id="Milano">Milano</option>
                    <option id="Monza">Monza</option>
                    <option id="Napoli">Napoli</option>
                    <option id="Palermo">Palermo</option>
                    <option id="Parma">Parma</option>
                    <option id="Roma">Roma</option>
                    <option id="Torino">Torino</option>
                    <option id="Udine">Udine</option>
                    <option id="Venezia">Venezia</option>
                    <option id="Verona">Verona</option>


                </select><br>
                <label for="NomeEvento">Inserisci il nome dell'evento</label>
                <input type="text" name="NomeEvento" id="NomeEvento" required><br>
                <label for="PostiDisponibili">Inserisci i posti disponibili</label>
                <input type="text" name="PostiDisponibili" id="PostiDisponibili" required><br>
                <label for="Data">Inserisci la data dell'evento</label>
                <input type="text" name="Data" id="Data" required><br>
                <label for="Ora">Inserisci l'ora dell'evento</label>
                <input type="text" name="Ora" id="Ora" required><br>
                <label for="Prezzo">Inserisci il prezzo dell'evento</label>
                <input type="text" name="Prezzo" id="Prezzo" required><br>

            </th>
        </tr>
    </table>
    <button onclick="return(validateNewProduct())" type="submit" class="cart"><i class="fa fa-cart-plus"></i></button>
    <button onclick="window.location.href='HomeServletAmministratore'" type="submit" class="cart"><i class="fa fa-home"></i></button>
</form>
</body>
</html>
