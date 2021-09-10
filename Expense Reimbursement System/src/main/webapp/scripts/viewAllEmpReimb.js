
//const url = "http://loacalhost:9000";
const urlParams = new URLSearchParams(window.location.search)
const userId = urlParams.get("ersUsersId")

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

    /* view all reimbursements by an Employee */

    const viewResponse = await fetch(`${domain}/api/ers_reimbursement?id=${userId}`)
    const viewData = await viewResponse.json();

    console.log(viewData)

    let viewReimbElem = document.getElementById("reimb-body")

    viewData.data.forEach(reimb =>{
        console.log(viewData)
        viewReimbElem.innerHTML += `
        <td>${reimb.reimb_id}</td>
        <td>${reimb.ers_users_fk_auth}</td>
        <td>${reimb.ers_users_fk_rslvr}</td>
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

