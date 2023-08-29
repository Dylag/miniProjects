let userInput  = document.getElementById("userInput")
let list = document.getElementById('list')


function addToList(){
    let newLi = document.createElement('li')
    newLi.textContent=userInput.value
    list.appendChild(newLi)
}