let registerForm = document.getElementById("register-form");

registerForm.onsubmit = async function(e){
    e.preventDefault();

    //get values from the input field
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let firstname = document.getElementById("firstname").value;
    let lastname = document.getElementById("lastname").value;
    let email = document.getElementById("email").value;
    let userrole = document.getElementById("userrole").value;

    console.log(username,password,firstname,lastname,email,userrole);

    //how do we send values to the backend?
    let response = await fetch(`${domain}/api/register`,{
        method: "POST",
        body: JSON.stringify({
            ersUserName: username,
            ersPassword: password,
            userFirstName: firstname,
            userLastName: lastname,
            userEmail: email,
            userRoleId_Fk: userrole

        })
    })

    let responseData = await response.json();
    console.log(responseData)

    if(responseData.success){
        window.location = `${domain}/login?id=${responseData.data.ersUsersId}`
    }
}
