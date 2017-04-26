/**
 * Created by cr7bo on 4/7/2017.
 */
var setUpLinks = function () {
    $('.requests').click( function() {
        console.log("/requestJoin?projectId=" +
            $(this).attr('data-request') + "&userId=" +
            $('#dynView').attr('data-userId'));
        $(this).css('background-color', 'green');
        $(this).text('Request Pending');
        $.post("/requestJoin?projectId=" +
            $(this).attr('data-request') + "&userId=" +
            $('#dynView').attr('data-userId')
        ), function(data){
            console.log(data);
        };
        console.log($(this).attr('data-request'));
        console.log($('#dynView').attr('data-userId'));
    });
}

var projects = function () {
    $('#button').click(function(){
        getProjects();
    });
}

var getProjects = function () {
    $('#userCreateButton').hide();
    $.post("/projects?userId=" +
        $('#dynView').attr('data-userId'),
        function (data) {
            $('#dynView').html(data);
            $(".requests").click(function(){
                $(this).css('background-color', 'green');
                $(this).text('Request Pending');
            });

            //setUpLinks();
            createProject(); //sets up the create-project btn

        }
    );
}

var createProject = function () {
    $('#createProjectBtn').click(function () {
        console.log("Hello from create project!");
        $.post('/newProject?name=' +
            $('#pName').val() +
            '&description=' +
            $("#pDescription").val() +
            '&manager=' +
            $("#pManager").val(),
            function (data) {
                console.log(data);
            });
    })
}

var users = function () {
    $('#userButton').click(function () {
        getUsers();
    });

}

var getUsers = function () {
    $('#userCreateButton').show();
    $.post("/getAllUsers",
        function (data) {
            $('#dynView').html(data);
            $('#userCreateButton').show();

            //set up users for deleting
            $('#deleteModal').on('show.bs.modal', function (event) {
                var btn = $(event.relatedTarget);
                $('#submitDelete').click(function () {
                    $.post('/deleteUser?userId=' +
                        btn.attr('data-userId'),
                        function (data) {
                            console.log(data);
                            getUsers();
                        });
                });
            });

            //set up users for potential updates
            //this code gets called when the user clicks to open the modal
            //see the bootstrap example code: http://getbootstrap.com/javascript/#modals-related-target
            $('#updateModal').on('show.bs.modal', function (event) {

                var btn = $(event.relatedTarget); // button that toggled the modal
                console.log(btn.attr('data-userId'));
                $('#submitChanges').click(function (){
                    $.post('/updateUser?userId=' +
                        btn.attr('data-userId') +
                        '&firstname=' +
                        $("#newFirstName").val() +
                        '&lastname=' +
                        $("#newLastName").val() +
                        '&email=' +
                        $("#newEmail").val() +
                        '&password=' +
                        $("#newPassword").val(),
                        function (data) {
                            console.log(data);
                            getUsers();
                        });
                });
            });

            // $('#userCreateFormButton').click(function () {



                $('#createUser').click(function (){

                    $.post('/createUser?userType=' +
                        $('input[name=User]:checked').val()+
                        '&firstname=' +
                        $("#FirstName").val() +
                        '&lastname=' +
                        $("#LastName").val() +
                        '&email=' +
                        $("#Email").val() +
                        '&password=' +
                        $("#Password").val(),
                        function (data) {
                            console.log(data);
                            getUsers();
                        });
                });
            // });

        });
}

var replyEmail = function () {
    $('.replyEmailButton').click(function (){
        $.post('/sendEmail?from=' +
            $('#dynView').attr('data-userId') +
            '&to=' +
            $("#replyTo").val() +
            '&subject=' +
            $("#replySubject").val() +
            '&message=' +
            $("#replyMessage").val(),
            function (data) {
                console.log(data);
            });
    });
}



var sendEmail = function () {
    $('.submitEmailButton').click(function (){
        console.log("sending email");
        $.post('/sendEmail?from=' +
            $('#dynView').attr('data-userId') +
            '&to=' +
            $("#toInput").val() +
            '&subject=' +
            $("#subjectInput").val() +
            '&message=' +
            $("#messageInput").val(),
            function (data) {
                console.log(data);
            });
    });
}

var email = function () {
    $('#emailButton').click(function () {
        getEmail();


    });

var getEmail = function () {
    $.post("/email?userId=" +
        $('#dynView').attr('data-userId'),
        function (data) {
            $('#dynView').html(data);
            $('#creationUser').hide();

            sendEmail();
            replyEmail();

            //set up the emails for deleting
            $('.deleteEmail').click(function () {
                $.post('/deleteEmail?emailId='+
                    $(this).attr('data-eid'),
                    function (data) {
                        console.log(data);
                        getEmail(); // only when the user clicks to delete
                                    // an email, does this function recursively
                                    // calls itself and sets up the handler
                                    // again. Thus, it is not infinite recursion.
                    });

            });
        });
}

}

var adminRequests = function () {
    $('#requestButton').click(function () {
        getAdminRequests();
    });
}

var getAdminRequests = function () {
    $('#userCreateButton').hide();
    $.post("/adminRequests?userId=" +
        $('#dynView').attr('data-userId'),
        function (data) {
            $('#dynView').html(data);
            $('.requests').click(function () {
                $.post("/adminDecision?status=" +
                    $(this).attr('data-status') +"&adminId="+
                    $('#dynView').attr('data-userId') + "&profId=" +
                    $(this).attr('data-profid') + "&projectName=" +
                    $(this).attr('data-projName') + "&projectId=" +
                    $(this).attr('data-projectid') + "&profName=" +
                    $(this).attr('data-pfname') + " " +
                    $(this).attr('data-plname'),
                    function (data) {
                        console.log(data);
                        getAdminRequests();
                    });
            });
        });
}



var profRequests = function () {
    $('#requestButton').click(function () {
        getProfRequests();
    });
}

var getProfRequests = function () {
    $('#userCreateButton').hide();
    console.log("Hello from professor requests");
    $.post("/projectRequests?userId=" +
        $('#dynView').attr('data-userId'),
        function (data) {
            $('#dynView').html(data);
            $('#creationUser').hide();
            $('.requests').click(function () {
                $.post("/professorDecision?status=" +
                    $(this).attr('data-status') + "&wid=" +
                    $(this).attr('data-wid') + "&studentId=" +
                    $(this).attr('data-sid') + "&profId=" +
                    $(this).attr('data-profid') + "&studentName=" +
                    $(this).attr('data-sfname') + " " +
                    $(this).attr('data-slname') + "&profName=" +
                    $(this).attr('data-pfname') + " " +
                    $(this).attr('data-plname') + "&projectName=" +
                    $(this).attr('data-projname'),
                    function (data) {
                        console.log(data);
                        getProfRequests();
                    });
            });
        });
}

$(document).ready(function(){
    setUpLinks(); // since projects is the initial view, set
    //up the links that came through on the initial page request

    projects(); // if users click the project button
                // fetch the data and set up the links again.
    email();



    //sendEmail();

    //admin view: show project requests
    if($('#dynView').attr('data-viewType') == 0){
        console.log('Calling admin requests');
        adminRequests();
        getAdminRequests();
        users();
        getUsers();
    }
    else if($('#dynView').attr('data-viewType') == 1){
        //professor viewType: show project join requests
        profRequests();
        getProjects();
    }
    else {
        console.log("unrecognized view type: ");
        console.log($('#dynView').attr('data-viewType'));
    }


});