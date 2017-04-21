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
        $.post("/projects", function (data) {
                $('#dynView').html(data);
                setUpLinks();
            }
        );

    });
}

var email = function () {
    $('#emailButton').click(function () {
        $.post("/getEmail?userId=" +
            $('#dynView').attr('data-userId'),
            function (data) {
                $('#dynView').html(data);
            });
    })
}

var users = function () {
    $('#userButton').click(function () {
        $.post("/getAllUsers",
            function (data) {
                $('#dynView').html(data);
            });
    })

}

$(document).ready(function(){
    setUpLinks(); // since projects is the initial view, set
    //up the links that came through on the initial page request

    projects(); // if users click the project button
                // fetch the data and set up the links again.
    email();

    users();

});