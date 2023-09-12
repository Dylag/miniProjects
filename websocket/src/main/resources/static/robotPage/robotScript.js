


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
    brokerURL: 'ws://localhost:8080/robotCommander'
});

stompClient.onConnect = () => {

    console.log("stompClient connected ")

    stompClient.subscribe('/output/command', commandObject => {
        let obj = JSON.parse(commandObject.body)

        console.log(`got command ${obj.command}`)
        doCommand(obj.command)
    });
};

stompClient.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};

stompClient.activate()

function doCommand(command){

    console.log(`doing command ${command}`)

    let oldPos = robotPos.slice(0,2)
    switch (command){
        case 'left':
            if(robotPos[1] === 0)
                console.log('left border')
            else
                robotPos[1]--;
            break
        case 'right':
            if(robotPos[1] === table[0].length-1)
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
            if(robotPos[0] === table.length-1)
                console.log('down border')
            else
                robotPos[0]++;
            break
        default:
            console.log('incorrect command')
    }
    table[oldPos[0]][oldPos[1]].style.backgroundColor = ''
    table[robotPos[0]][robotPos[1]].style.backgroundColor = robotColor
}


