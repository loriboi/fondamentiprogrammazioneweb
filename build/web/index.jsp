<%-- 
    Document   : index
    Created on : Dec 15, 2021, 12:31:38 PM
    Author     : fpw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Waves</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Lorenzo Boi">
        <meta name="description" content="Progetto B">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div id=aside class="col-2">
            <ul>
                <li>
                    <a href="#postazioni">Postazioni</a>
                </li>
                <li>
                    <a href="#forari">Fasce Orarie</a>  
                </li>
                
            </ul>
        </div>
        <div id = content class="col-8">
        <article>
        <h1>Benvenuto nel sito ufficiale di Waves!</h1>
        <p>Stanco di andare al mare portando sulla schiena ombrelloni e sdraiette?<br>
            Waves è uno stabilimento balneare situato a <b>Villasimius</b>, oltre i posti con ombrellone offre una vasta gamma di servizi tra cui chioschetto fornito di bibite e gelati, rete per giocare a pallavolo e tante altre features!<br>
           
           In questo sito potrai prenotare una postazione direttamente online, per il giorno e per l'orario che preferisci
           <br>
           Buona Navigazione
        </p>
        
        <h3>Informazioni sui prezzi e sulle postazioni</h3>
        </article>
            
        <h4 id = postazioni>Postazioni</h4>
        <img src="img/postazione.jpg" title="Postazione" alt="Immagine della postazione" width="40%" height="40%">
        <p>Una postazione comprende ombrellone e sdraietto come in figura</p>
        
        <article>
        <h4 id = forari>Fasce Orarie e Prezzi</h4>
        <p>Le prenotazioni vanno a fasce orarie.</p>
        <table id = orari>
            <tr><td>Periodo</td><td>Inizio</td><td>Fine</td></tr>
            <tr><td>Mattina</td><td>8.00</td><td>14.00</td></tr>
            <tr><td>Sera</td><td>14.00</td><td>20.00</td></tr>
        </table>
        <p id=prezzo>Una postazione per ogni fascia oraria ha il prezzo di 4€</p>
        </article>
        </div>    
          
        <jsp:include page="footer.jsp"/>
    </body>
</html>
