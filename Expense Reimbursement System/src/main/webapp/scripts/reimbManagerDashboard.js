const urlParams = new URLSearchParams(window.location.search)
const ersUsersId = urlParams.get("id")

console.log("id")

// const urlParams1 = new URLSearchParams(window.location.search)
// const reimb_status = urlParams1.get("reimb_status")

// const urlParams3 = new URLSearchParams(window.location.search)
// const reimbId = urlParams3.get("reimb_id")

/* window load */
window.onload = async function(){    

    //check session
    const sessionRes = await fetch(`${domain}/api/check-session`)
    const sessionUserData = await sessionRes.json()

    console.log(sessionUserData)
    if(sessionUserData.data){
        if(sessionUserData.data.ersUsersId != ersUsersId){
            window.location = `${domain}/`
        }
    } else{
        window.location = `${domain}/`
    }



    /* View all Reimbursements as a Manager */

    console.log("View reimbursements")
    
    let viewReimbsRes = await fetch(`${domain}/api/manager?id=${ersUsersId}`)
    let viewReimbData = await viewReimbsRes.json();

    console.log(viewReimbData)

    let viewReimbElem = document.getElementById("reimb-container")

    viewReimbData.data.forEach(element => {

        let viewAllReimbsButton = document.getElementById("viewAllReimbsButton")
        viewAllReimbsButton.onclick = async function(){
            console.log("viewAllReimbsButton")  
            let viewReimbsRes = await fetch(`${domain}/api/manager?id=${ersUsersId}`,{
                method: "GET"
                })
            let viewReimbData = await viewReimbsRes.json();
            console.log(viewReimbData)

            window.location = `${domain}/viewAllReimb?ersUsersId=${ersUsersId}`           
                        
        }

    });

    /* view Reimbursements on Status by Manager */
        console.log("Reimbursement On Status")  

        let statusButton = document.getElementById("statusButton")
        let viewReimbsResponse;
        
        statusButton.onclick = async function(){
            console.log("statusButton")

            let  viewReimburseElem = document.getElementById("reimbursementStatus").value;
            console.log(viewReimburseElem);

            viewReimbsResponse = await fetch(`${domain}/api/reimbursements?resolverId=${ersUsersId}&reimb_status=${viewReimburseElem}`,{
                method: "GET"
            })

            let viewReimburseData = await viewReimbsResponse.json();
            console.log(viewReimburseData)

            window.location = `${domain}/reimbOnStatus?resolverId=${ersUsersId}&reimb_status=${viewReimburseElem}`

        } 
        
        /* Approve or Deny Reimbursement */ 
        
        console.log("Approve or Deny")

        let updateButton = document.getElementById("updateReimbursement");

        updateButton.onclick = async function(){           

            console.log("updateButton") 

            let reimbIdElem = document.getElementById("reimb_id").value;
            let statusElem = document.getElementById("reimbursementStatusUpdate").value;

            console.log(reimbIdElem)
            console.log(statusElem)
            console.log("Update Reimbursement")

            let viewReimbsResponse = await fetch(`${domain}/api/manager`,{
                method: "PATCH",
                body: JSON.stringify({
                    reimb_id: reimbIdElem,
                    ers_reimbursement_status_fk: statusElem
                })

            })          

            let viewReimburseData = await viewReimbsResponse.json();
            console.log(viewReimburseData)            

            window.location = `${domain}/viewAllReimb?ersUsersId=${ersUsersId}&reimb_status=${reimbIdElem}`

        } 
        
    }

    /* logout button on dashboard */
            let logoutBtn = document.getElementById("logout-btn")
            //function
            logoutBtn.onclick = async function(){
            let logoutRes = await fetch(`${domain}/api/logout`)

            let logoutResData = await logoutRes.json();

                if(logoutResData.success)
                window.location = `${domain}/`
}





