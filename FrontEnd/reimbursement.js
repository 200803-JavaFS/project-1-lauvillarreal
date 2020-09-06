//url
const url = "http://localhost:8080/reimbursement/"
//Event listener for login button.
document.getElementById("loginbtn").addEventListener("click", loginFunc);

//function that will happen if button gets pressed 
async function loginFunc() {
    //values entered in text and passworrd type
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;
    //create object user with values username and password
    let user = {
        username: usern,
        password: userp
    }
    
    //send object to server as POST
    let resp = await fetch(url + "login", {
        method: 'POST',
        body: JSON.stringify(user),
        credentials: "include"
    })
    //response from server
    if (resp.status === 200) {
        console.log(resp)
        document.getElementById("login-row").innerText = "YOU HAVE LOGGED IN.";
        //get all reimbursements button show
        let button = document.createElement('button');
        button.className = "btn btn-success";
        button.id = "findAllBtn";
        button.innerText = "Find All Reimbursement Tickets";
        button.onclick = findAllFunc;
        document.getElementById("table-row").appendChild(button);
        //add reimbursement button show
        let button2 = document.createElement('button');
        button2.className = "btn btn-success";
        button2.id = "addReimBtn";
        button2.innerText = "Add a Ticket";
        button2.onclick = AddFunc;
        document.getElementById("formbtn").appendChild(button2);
        
    } else {
        document.getElementById("login-row").innerText = "Login failed!";
    }
}
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
              cell9.innerHTML = reimbursement.resolver.userID;
              row.appendChild(cell9);
           } else {
                let cell9 = document.createElement("td");
                row.appendChild(cell9);
        }
        
        
        document.getElementById("reimbody").appendChild(row);
        }
    }
}

async function AddFunc(){
    //adding to database
    let type = document.getElementById("type").value;
    let role = document.getElementById("role").value;
    let amount = document.getElementById("amount").value;
    let date = document.getElementById("date").value;
    let description = document.getElementById("description").value;
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;
    
  

    let reimbursement = {
        type : type,
        role : role,
        amount : amount,
        firstName : firstName,
        lastName : lastName,
        date : date,
        description : description,
        email :email
    }

    console.log(reimbursement)

    let resp = await fetch(url + "employee", {
        method: 'POST',
        body: JSON.stringify(reimbursement),
        credentials: "include"
    })

    if(resp.status === 201){
        findAllFunc()
    } else {
        document.getElementById("login-row").innerText = "Reimbursement could not be added.";
    }

}
