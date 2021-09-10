const urlParams = new URLSearchParams(window.location.search)
const ersUsersId = urlParams.get("id")

const successDiv = document.getElementById("success");


console.log("user id")
console.log(ersUsersId);


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

    
    /* view all Reimbursements for an Employee */

    console.log("View All Reimbursements")

    let viewReimbsRes = await fetch(`${domain}/api/ers_reimbursement?id=${ersUsersId}`)
    let viewReimbData = await viewReimbsRes.json();

    console.log(viewReimbData)

    let viewReimbElem = document.getElementById("reimb-container")

    viewReimbData.data.forEach(element => {
   
        let viewAllReimbsButton = document.getElementById("viewAllReimbsButton")
        viewAllReimbsButton.onclick = async function(){
            console.log("viewAllReimbsButton")  

            let viewReimbsRes = await fetch(`${domain}/api/ers_reimbursement?id=${ersUsersId}`,{
                method: "GET"
            })
            let viewReimbData = await viewReimbsRes.json();
            console.log(viewReimbData)

            window.location = `${domain}/viewAllEmpReimb?ersUsersId=${ersUsersId}`           
                        
        } 
    });  
     
    
    /* Reimbursement on status by Employee */ 

        console.log("Reimbursements on Status")  

        let statusButton = document.getElementById("statusButton")
        let viewReimbsResponse;

        statusButton.onclick = async function(){
            console.log("statusButton")

            let  viewReimbElem = document.getElementById("reimbursementStatus").value;
            console.log(viewReimbElem);

            viewReimbsResponse = await fetch(`${domain}/api/employee_status?authorId=${ersUsersId}&reimb_status=${viewReimbElem}`,{
                method: "GET"
            })

            let viewReimburseData = await viewReimbsResponse.json();
            console.log(viewReimburseData)

            window.location = `${domain}/viewEmpReimbOnStatus?authorId=${ersUsersId}&reimb_status=${viewReimbElem}`

        }  
    
        
        /* Add New Reimbursement as an Employee */      
        

        let newReqButton = document.getElementById("newReqButton")
        let addNewReimbResp;

        newReqButton.onclick = async function(){
            console.log("newReqButton")

            let amount = document.getElementById("ReimbursementAmount").value;
            console.log(amount)

            let description = document.getElementById("ReimbursementDescription").value;
            console.log(description)

            let receipt = document.getElementById("reimb_receipt").value;
            console.log(receipt)

            let manager = document.getElementById("manager_id").value;
            console.log(manager)

            let status = document.getElementById("reimbursementStatus").value;
            console.log(status)

            let type = document.getElementById("reimbursementType").value;
            console.log(type)
            
            addNewReimbResp = await fetch(`${domain}/api/ers_reimbursement`,{
                method: "POST",
                body: JSON.stringify({

                    reimb_amount: amount,      
                    reimb_description: description,
                    reimb_receipt: receipt,
                    ers_users_fk_auth: ersUsersId,
                    ers_users_fk_reslvr: manager,
                    ers_reimbursement_status_fk: status,
                    ers_reimbursement_type_fk : type

                })
            }) 
            
            /* message about data added will display as div in the same page */
            let addReimburseData = await addNewReimbResp.json();
            if(addReimburseData.success){
                console.log("New Reimbursement Added")
                //successDiv is captured element by id
                successDiv.innerHTML="New Reimbursement Added";
            }
            else{
                successDiv.innerHTML="Unable added reimbursement";
            }
            console.log(addReimburseData)

           /* Added data will display on viewAllReimb page */
            //window.location = `${domain}/viewAllEmpReimb/?ersUsersId=${ersUsersId}`

        } 
        
}    

        //logout button on dashboard
        let logoutBtn = document.getElementById("logout-btn")
        //function
        //logoutBtn.onclick = async () => {}
        logoutBtn.onclick = async function(){
            let logoutRes = await fetch(`${domain}/api/logout`) //fetching url

            let logoutResData = await logoutRes.json(); //response data

                if(logoutResData.success)
                     window.location = `${domain}/` //domain = localhost:9000

   }  

