 //get all reimbursements button show
 let button = document.createElement('button');
 button.className = "btn btn-primary";
 button.id = "findAllBtn";
 button.innerText = "View All Reimbursement Tickets";
 button.onclick = findAllFunc;
 document.getElementById("table-row").appendChild(button);
 //add reimbursement button show
 let button2 = document.createElement('button');
 button2.className = "btn btn-primary";
 button2.id = "addReimBtn";
 button2.innerText = "Approve Ticket";
 button2.onclick = approveFunc;
 document.getElementById("formbtn").appendChild(button2);


//Retrieve from database
async function findAllFunc() {

document.getElementById("reimbody").innerText ="";

let resp = await fetch(url + "manager", {
 method: 'GET',
 credentials: 'include',
});

if (resp.status === 200) {
 let data = await resp.json();
 for (let reimbursement of data) {
     console.log(reimbursement);
     let row = document.createElement("tr");
     let cell = document.createElement("td");
     cell.innerHTML = reimbursement.reimID;
     row.appendChild(cell);
     let cell2 = document.createElement("td");
     cell2.innerHTML = reimbursement.reimAmount;
     row.appendChild(cell2);
     let cell3 = document.createElement("td");
     cell3.innerHTML = reimbursement.reimSubmitted;
     row.appendChild(cell3);
     let cell4 = document.createElement("td");
     cell4.innerHTML = reimbursement.reimResolved;
     row.appendChild(cell4);
     let cell5 = document.createElement("td");
     cell5.innerHTML = reimbursement.reimDescription;
     row.appendChild(cell5);
     let cell6 = document.createElement("td");
     cell6.innerHTML = reimbursement.author.firstName;
     row.appendChild(cell6);
     let cell7 = document.createElement("td");
     cell7.innerHTML = reimbursement.status.status;
     row.appendChild(cell7);
     let cell8 = document.createElement("td");
     cell8.innerHTML = reimbursement.type.type;
     row.appendChild(cell8);
     console.log(row);
     if (reimbursement.resolver != null) {
       let cell9 = document.createElement("td");
       cell9.innerHTML = reimbursement.resolver.firstName;
       row.appendChild(cell9);
    } else {
         let cell9 = document.createElement("td");
         row.appendChild(cell9);
 }
 
 
 document.getElementById("reimbody").appendChild(row);
 }
}
}

async function approveFunc(){
//adding to database

let date = document.getElementById("date").value;
let status = document.getElementById("status").value;
let id = document.getElementById("ID").value;




let managerApproval = {
 date : date,
 status : status,
 id : id,

}

console.log(managerApproval)

let resp = await fetch(url + "manager", {
 method: 'POST',
 body: JSON.stringify(managerApproval),
 credentials: "include"
})

if(resp.status === 201){
 findAllFunc()
} else {
 document.getElementById("login-row").innerText = "Reimbursement could not be added.";
}

}