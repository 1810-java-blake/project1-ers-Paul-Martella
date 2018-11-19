$(document).ready(function() {
    //Global variables
    let userNames = [];
    let userName;
    let passwords = [];
    let password;
    let userRoles = [];
    let userRole;

    function guests () {
        if (sessionStorage.userName == null || sessionStorage.userName == undefined)
        sessionStorage.userName = "guest";
        sessionStorage.password = "guest";
        console.log(sessionStorage.userName);
        console.log(sessionStorage.password);
    };
    guests();

    function login () {
        sessionStorage.userName = document.getElementById('loginEmail');
        console.log(sessionStorage.userName);
    };

    $("#logOutBtn").click(function() {
        sessionStorage.userName = "guest";
        sessionStorage.password = "guest";
        console.log(sessionStorage.userName);
        console.log(sessionStorage.password);
        window.location = 'index.html';
    });

    //TODO fix login api 
    $('#logInBtn').click(function () {
        userName = sessionStorage.userName;
        password = sessionStorage.password;
        let loginEmail = $('#loginEmail').val();
        let loginPass =  $('#loginPass').val();
        $.ajax({
            url: 'https://us-central1-project1-222909.cloudfunctions.net/logIn  ',
            dataType: "JSON",
            method: "GET",
            crossDomain: true,
            success: function(res) {
                let resLogin = res.rows;
                let readLogin = resLogin["0"];
                let count = res.lenght;
                console.log(count);
                userRole = 'employee';
                console.log(res.rows);
                $.each(res.rows[count], function(index) {
                console.log(readLogin.ers_username);
                console.log(readLogin.ers_password);
                console.log(readLogin.user_role);
                //count = count+1; 
                //console.log(userNames);
                //console.log(passwords);
                //console.log(userRoles);
                });
            }

        });
        if (userName == loginEmail && password == loginPass) {
            if(userRole=='employee') {
            //window.location = 'employee.html';
            } else {
                //window.location ='manager.html';
            }
        } else {
            alert('Login attempt failed!');
        }
        return false;
    });

    //TODO approve fetch api
    $('#approveBtn').click(function() {
        $.ajax({
            url: 'https://us-central1-project1-222909.cloudfunctions.net/approve',
            dataType: "JSON",
            method: "GET",
            crossDomain: true,
            success: function(res) {
                console.log("approved");
            }
        })

    });

    //TODO deny fetch api
    $('#denyBtn').click(function() {
        $.ajax({
            url: 'https://us-central1-project1-222909.cloudfunctions.net/deny',
            dataType: "JSON",
            method: "GET",
            crossDomain: true,
            success: function(res) {
                console.log('denied');
            }
        })

    });

    //TODO update table api
    $('#requestBtn').click(function() {
        $.ajax({
            url: 'https://us-central1-project1-222909.cloudfunctions.net/requestReimb',
            dataType: "JSON",
            method: "POST",
            crossDomain: true,
            data: {
                reimb_amount: "",
                reimb_submitted: "",
                reimb_description: "",
                reimb_author: "",
                reimb_status_id: "",
                reimb_type_id: ""
            },
            success: function(res) {
                console.log("sent");
            }
        })

    });


    //TODO request riemb api
    $('#getStatusEmp').click(function() {
        $.ajax({
            url: 'https://us-central1-project1-222909.cloudfunctions.net/getReimb',
            dataType: "JSON",
            method: "GET",
            crossDomain: true,
            success: function(res) {
                let update = res.rows;
                let readUpdate = update["0"];
                console.log(res.rows);
                console.log(update["0"]);
                console.log(readUpdate.reimb_amount);
            }

        })

    });

});
