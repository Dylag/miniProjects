let login_nameInput = document.getElementById("login_nameInput")
let login_passwordInput = document.getElementById("login_passwordInput")


let reg_nameInput = document.getElementById("reg_nameInput")
let reg_passwordInput = document.getElementById("reg_passwordInput")

function login(){

    login_nameInput.value = login_nameInput.value.trim()
    login_passwordInput.value = login_passwordInput.value.trim()

    fetch("http://localhost:8080/todo/login",{
        method: "POST",
        body: JSON.stringify({
            name:login_nameInput.value,
            password: login_passwordInput.value
        }),

        headers: {
            "Content-type":"application/json"
        }
    })
        .then(response => response.json())
        .then(json =>{
            alert(json.text)
        })
}

function registration(){

    reg_nameInput.value = reg_nameInput.value.trim()
    reg_passwordInput.value = reg_passwordInput.value.trim()


    fetch("http://localhost:8080/todo/reg", {
        method: "POST",
        body: JSON.stringify({
            name: reg_nameInput.value,
            password: reg_passwordInput.value
        }),
        headers: {
            "Content-type": "application/json"
        }
    }).then( response => response.json())
        .then(json => {
            alert(json.text)
        })

}



