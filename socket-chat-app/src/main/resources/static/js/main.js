
var logInElement = document.querySelector('#login');
var chatElement = document.querySelector('#chat');
var userForm = document.querySelector('#userForm');
var userName = null;
var stomp = null;

function connectSocket(event) {
    userName = document.querySelector('#username').value.trim();
    if(userName) {
        logInElement.classList.add("dis");
        chatElement.classList.remove("dis");
        var socket = new SockJS('connect');    // Connect With Socket URL With Back End
        stomp = Stomp.over(socket);            // STOMP
    }
    event.preventDefault()
}

userForm.addEventListener('submit', connectSocket)