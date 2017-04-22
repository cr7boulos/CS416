/**
 * Created by cr7bo on 4/7/2017.
 */
var setUpLinks = function () {
    $('.requests').click( function() {
        console.log("/requestJoin?projectId=" +
            $(this).attr('data-request') + "&userId=" +
            $('#dynView').attr('data-userId'));
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
        $.post("/projects?userId=" +
            $('#dynView').attr('data-userId'),
            function (data) {
                $('#dynView').html(data);
                //setUpLinks();
            }
        );

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

            //set up the emails for deleting
            $('.deleteEmail').click(function () {
                $.post('/deleteEmail?emailId='+
                    $(this).attr('data-eid'),
                    function (data) {
                        console.log(data);
                        getEmail(); // only when the user clicks to delete
                                    // an email, does this function recursively
                                    // calls itself and sets up the handler
                                    // again thus it is not infinite recursion.
                    });

            });
        });
}

}

var users = function () {
    $('#userButton').click(function () {
        $.post("/getAllUsers",
            function (data) {
                $('#dynView').html(data);
            });
    })

}

var requests = function () {
    $('#requestButton').click(function () {
        getRequests();
    });
}

var getRequests = function () {
    $.post("/projectRequests?userId=" +
        $('#dynView').attr('data-userId'),
        function (data) {
            $('#dynView').html(data);
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
                        getRequests();
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

    users();

    requests();

});