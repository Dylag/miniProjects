let userInput  = document.getElementById("userInput")
let list = document.getElementById('list')



function addToList(){
    let newLi = document.createElement('li')

    let newLabel = document.createElement('label')
    newLabel.textContent = userInput.value

    let newBtn = document.createElement('button')
    newBtn.textContent = 'delete'
    newBtn.addEventListener('click',()=>removeElement(newLi))

    newLi.appendChild(newLabel)
    newLi.appendChild(newBtn)

    list.appendChild(newLi)
}

function removeElement(element){
    element.remove()
}
