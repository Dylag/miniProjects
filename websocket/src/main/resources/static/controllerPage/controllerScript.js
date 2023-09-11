const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/robotCommander'
});

// stompClient.onConnect = (frame) => {
//     console.log('Connected: ' + frame);
//     stompClient.subscribe('/commandChannel', (greeting) => {
//         showGreeting(JSON.parse(greeting.body).content);
//     });
// };

stompClient.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};


stompClient.activate()
// if(stompClient.active)
//     console.log("stomp client is active")
// else
//     console.log("stomp client is inactive")

function sendCommand(command){

    console.log(`sending command ${command}`)

    stompClient.publish({
        destination:'/input/command',
        body: JSON.stringify({'command':command})
    })
}
