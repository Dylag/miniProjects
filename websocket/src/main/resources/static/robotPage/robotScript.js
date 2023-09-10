


let table = []
const robotColor = '#b595f5'

let robotPos = [4,0]
{
    cnt = 0
    let b = document.getElementById("body")
    b = $("#robotFieldBody")[0]
    for(let i  of b.children ) {
        table.push([])
        for (let j of i.children) {
            table.at(-1).push(j)
            j.textContent = cnt
            cnt++
        }
    }
}

table[robotPos[0]][robotPos[1]].style.backgroundColor = robotColor


const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/robot'
});

stompClient.onConnect = () => {
    stompClient.subscribe('/commandsThread', command => doCommand(command));
};

stompClient.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};


function doCommand(command){
    switch (command){
        case 'left':
            if(robotPos[1] === 0)
                console.log('left border')
            else
                robotPos[1]--;
            break
        case 'right':
            if(robotPos[1] === table[0].length)
                console.log('rightBorder')
            else
                robotPos[1]++
            break
        case 'up':
            if(robotPos[0]===0)
                console.log('up border')
            else
                robotPos[0]--
            break
        case 'down':
            if(robotPos[0] === table.length)
                console.log('down border')
            else
                robotPos[0]++;
            break
        default:
            console.log('incorrect command')
    }
    table[robotPos[0]][robotPos[1]].style.backgroundColor = robotColor
}


