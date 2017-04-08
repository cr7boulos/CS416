/**
 * Created by cr7bo on 4/7/2017.
 */


$(document).ready(function () {
    $('#button').click(function(){
       $.post("/projects", function (data) {
               $('#dynView').html(data);
           }
       );

    });
});