//console.log(domain); //hit the domain page
//const url = "http://loacalhost:9000";

const urlParams = new URLSearchParams(window.location.search)
const status = urlParams.get("reimb_status")
const urlParams1 = new URLSearchParams(window.location.search)
const usersId=urlParams.get("ersUsersId")

console.log("User ID on check")


window.onload = async function(){

     //check session
     const sessionRes = await fetch(`${domain}/api/check-session`)
     const sessionUserData = await sessionRes.json()
 
     console.log(sessionUserData)
     if(sessionUserData.data){
         if(sessionUserData.data.ersUsersId != userId){
             window.location = `${domain}/`
         }
     } else{
         window.location = `${domain}/`
     }
   

        let viewReimbRes = await fetch(`${domain}/api/manager?id=${usersId}`)
        let viewData1 = await viewReimbRes.json();

        //console.log(viewData1)

        let viewReimbElem1 = document.getElementById("reimb-body")

        viewData1.data.forEach(reimb =>{
            console.log(viewData1)
            viewReimbElem1.innerHTML += `
            <td>${reimb.reimb_id}</td>
            <td>${reimb.ers_users_fk_auth}</td>        
            <td>${reimb.reimb_amount}</td>
            <td>${reimb.reimb_submitted}</td>
            <td>${reimb.reimb_resolved}</td>
            <td>${reimb.reimb_description}</td>
            <td>${reimb.reimb_receipt}</td>
            <td>${reimb.authorFirstName}</td>
            <td>${reimb.authorLastName}</td>
            <td>${reimb.resolverFirstName}</td>
            <td>${reimb.resolverLastName}</td>
            <td>${reimb.reimb_status}</td>
            <td>${reimb.reimb_type}</td>

            <td><button type="button" class="btn btn-success">Success</button></td>
            <td><button type="button" class="btn btn-danger">Danger</button></td>
            `
    })

}
