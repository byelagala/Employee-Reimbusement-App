//console.log(domain); //hit the domain page
//const url = "http://loacalhost:9000";

const urlParams = new URLSearchParams(window.location.search)
const status1 = urlParams.get("reimb_status")
const ersUsersId = urlParams.get("authorId")

console.log("User ID on check")
console.log(status1);

window.onload = async function(){

    console.log("Data on status")
    
     //check session
     const sessionRes = await fetch(`${domain}/api/check-session`)
     const sessionUserData = await sessionRes.json()
 
     console.log(sessionUserData)
     if(sessionUserData.data){
         if(sessionUserData.data.ersUsersId != status1){
             window.location = `${domain}/`
         }
     } else{
         window.location = `${domain}/`
     }

     /* View Reimbursement Response data by Employee on status */

        let viewReimbRes = await fetch(`${domain}/api/employee_status?authorId=${ersUsersId}&reimb_status=${status1}`)
        let viewData = await viewReimbRes.json();

        console.log(viewData)

        let viewReimbElem = document.getElementById("reimb-body")

        viewData.data.forEach(reimb =>{
            console.log(viewData)
            viewReimbElem.innerHTML += `
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
            `
    })
}
