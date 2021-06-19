// A lot of things here will have to change. This is merely a placeholder.

function refreshColaborator() {

    var request = new XMLHttpRequest();
    var vBoard=document.getElementById("colaborador");

    request.onload = function() {
        vBoard.innerHTML = this.responseText;
        vBoard.style.color="black";
        setTimeout(refreshColaborator, 2000);
    };

    request.ontimeout = function() {
        vBoard.innerHTML = "Server timeout, still trying ...";
        vBoard.style.color="red";
        setTimeout(refreshColaborator, 100);
    };

    request.onerror = function() {
        vBoard.innerHTML = "No server reply, still trying ...";
        vBoard.style.color="red";
        setTimeout(refreshColaborator, 5000);
    };

    request.open("GET", "/colaborador", true);
    request.timeout = 5000;
    request.send();
}

function refreshGestor() {
    var request = new XMLHttpRequest();
    var vBoard=document.getElementById("gestor");

    request.onload = function() {
        vBoard.innerHTML = this.responseText;
        vBoard.style.color="black";
        setTimeout(refreshGestor, 2000);
    };

    request.ontimeout = function() {
        vBoard.innerHTML = "Server timeout, still trying ...";
        vBoard.style.color="red";
        setTimeout(refreshGestor, 100);
    };

    request.onerror = function() {
        vBoard.innerHTML = "No server reply, still trying ...";
        vBoard.style.color="red";
        setTimeout(refreshGestor, 5000);
    };

    request.open("GET", "/gestor", true);
    request.timeout = 5000;
    request.send();
}