function refreshTasks() {

    var request = new XMLHttpRequest();
    var vBoard = document.getElementById("tasks");

    request.onload = function () {
        vBoard.innerHTML = this.responseText;
        vBoard.style.color = "black";
        setTimeout(refreshTasks, 2000);
    };

    request.ontimeout = function () {
        vBoard.innerHTML = "Server timeout, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshTasks, 100);
    };

    request.onerror = function () {
        vBoard.innerHTML = "No server reply, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshTasks, 5000);
    };

    request.open("PUT", "/tasks", true);
    request.open("GET", "/tasks", true);
    request.timeout = 5000;
    request.send();
}