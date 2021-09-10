//console.log(domain); //hit the domain page
//const url = "http://loacalhost:9000";
const urlParams = new URLSearchParams(window.location.search)
const userId = urlParams.get("ersUsersId");
const statusId = urlParams.get("ers_reimbursement_status_fk");
const reimbId = urlParams.get("reimb_id");

console.log(userId)
console.log(statusId)
console.log(reimbId)

/* view all reimbursements by Manager */

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

    //populateData(userId)
   viewAllReimbursement()
        
}

 /* view all reimbursements */
 async function viewAllReimbursement(){
    let viewResponse = await fetch(`${domain}/api/manager?id=${userId}`)
let viewData = await viewResponse.json();

//console.log(viewData)

let viewReimbElem = document.getElementById("reimb-body")

//viewReimbElem.innerHTML = ''

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

    <td><button type="button" class="btn btn-success" onclick="approveBtnFunction(${reimb.reimb_id})" id="approve-btn">Approve</button></td>
    <td><button type="button" class="btn btn-danger" onclick="denyBtnFunction(${reimb.reimb_id})" id="deny-btn">Deny</button></td>
    `
})

    viewAllReimbursement()  
}

    /* Approve Reimbursement */ 
        
    console.log("Approve Reimbursement")

    let approveButton = document.getElementById("approve-btn");

    async function approveBtnFunction(reimb_id){           

        console.log("approveButton")        

        let approveReimbsResponse = await fetch(`${domain}/api/manager?reimbId=${reimb_id}&ers_reimbursement_status_fk=1`,{            
            method: "PATCH",
            body: JSON.stringify({
                reimb_id: reimb_id,
                ers_reimbursement_status_fk: 1
            })

        })          

        let approveDataResponse = await approveReimbsResponse.json()
        console.log(approveDataResponse)

        //window.location = `${domain}/viewAllReimb?ersUsersId=${ersUsersId}`

        //window.location = `${domain}/viewAllReimb?ersUsersId=${userId}&statusId=1&reimb_id=${reimbId}`

    }      

    /* Deny Reimbursement */
    console.log("Deny Reimbursement")

    let denyButton = document.getElementById("deny-btn")

    async function denyBtnFunction(reimb_id){

        console.log("Denied Button")

        let denyReimbsResponse = await fetch(`${domain}/api/manager?reimbId=${reimb_id}&ers_reimbursement_status_fk=0`,{
            method: "PATCH",
            body: JSON.stringify({
                reimb_id: reimb_id,
                ers_reimbursement_status_fk: 0
            })
            
        })

        let denyDataResponse = await denyReimbsResponse.json();
        console.log(denyDataResponse)

        //window.location = `${domain}/viewAllReimb?ersUsersId=${userId}&statusId=0&reimb_id=${reimbId}`

    }   
    


