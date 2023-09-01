let userInput  = document.getElementById("userInput")
let list = document.getElementById('list')
let startDatePicker = document.getElementById("startDatePicker")
let endDatePicker = document.getElementById("endDatePicker")


function addToList(){
    alert(1)

    fetch("http://localhost:8080/todo", {
        method: "POST",
        body: JSON.stringify({
                txt:userInput.value,
                startdate: startDatePicker.value,
                enddate: endDatePicker.value
        }),
        headers:{
            "Content-type":"application/json"
        }
    })
        .then((respone) => respone.json())
        .then((json) => alert(json.body))



    // let newLi = document.createElement('li')
    //
    // let newLabel = document.createElement('label')
    // newLabel.textContent = userInput.value
    //
    // let newBtn = document.createElement('button')
    // newBtn.textContent = 'delete'
    // newBtn.addEventListener('click',()=>removeElement(newLi))
    //
    // newLi.appendChild(newLabel)
    // newLi.appendChild(newBtn)
    //
    // list.appendChild(newLi)
}

function removeElement(element){
    element.remove()
}