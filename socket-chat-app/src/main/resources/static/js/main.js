
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
        stomp.connect({}, connectedDone)
    }
    event.preventDefault()                     // Because Form Submit By Default
}

function connectedDone(){

    stomp.subscribe("/app/chat.send", sendMessage)
    // app : Is Prefix
    // chat.send : Is Message Mapping In Back End
    // Subscribe : Subscribe This Message When change happens Do Execute sendMessage Function

    stomp.send("/app/chat.logIn", {},
        JSON.stringify({sender: userName, chatType: 'JOIN'})
    )
    // app : Is Prefix
    // chat.logIn : Is Message Mapping In Back End
    // JSON.stringify : To Send Body For API
}

function sendMessage(){

}

userForm.addEventListener('submit', connectSocket)