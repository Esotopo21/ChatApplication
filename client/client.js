var stompClient;

function openConnection(){
    var socket = new SockJS("http://localhost:8080/samplews");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log(frame);
        stompClient.subscribe('/topic/access', function (accessResponse) {
         document.getElementById("messages").innerHTML += "<br>" + JSON.parse(accessResponse.body).content;
        });
     });
     document.getElementById("join").disabled = false;
}

function sendName() {
    stompClient.send("/app/access",{}, JSON.stringify({'username': document.getElementById("username").value}));
 }