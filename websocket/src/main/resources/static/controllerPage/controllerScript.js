function sendCommand(command){
    fetch("http://localhost:8080/commandReceiver?command="+command,{
        method:"POST",
    })
}