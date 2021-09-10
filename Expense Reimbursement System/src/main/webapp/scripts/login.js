// console.log('Grocery List Applet')
let loginForm = document.getElementById("login-form");

/* session  */
window.onload = async function(){
    console.log("login")
    
    const sessionRes = await fetch(`${domain}/api/check-session`)
    const sessionUserData = await sessionRes.json();

    console.log(sessionUserData)

    if(sessionUserData.data.userRoleId_Fk === 1){
        console.log("Login Successful")
        
        window.location =`${domain}/reimbEmpDashboard?id=${sessionUserData.data.ersUsersId}`
}    
           
        if(sessionUserData.data.userRoleId_Fk === 2){
            console.log("Login Successful")

        window.location =`${domain}/reimbManagerDashboard?id=${sessionUserData.data.ersUsersId}`
    }
}

//login function when click on login button
loginForm.onsubmit = async function(e){
    e.preventDefault();

 console.log("submitted");

    //get values from the input field
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    console.log(username, password)

    //how do we send values to the backend?
    //fetch by default GET method, but here we have method body with username, password
    let response = await fetch(`http://localhost:9000/api/login`,{
        method: "POST",
        body: JSON.stringify({
            ersUserName: username,
            ersPassword: password            
        })
    })

    let responseData = await response.json();
    console.log(responseData)
    console.log(responseData.data.userRoleId_Fk)

    if(responseData.success){

        if(responseData.data.userRoleId_Fk === 1){console.log("Login Successful")
        window.location =`${domain}/reimbEmpDashboard?id=${responseData.data.ersUsersId}`
}    
           
        if(responseData.data.userRoleId_Fk === 2){
            console.log("Login Successful")

        window.location =`${domain}/reimbManagerDashboard?id=${responseData.data.ersUsersId}`
    }
}else{

    console.log("given credentials are not correct");
    document.getElementById('login-form').innerText="Login failed"; 
    //alert("invalid credentials")       
}

}

