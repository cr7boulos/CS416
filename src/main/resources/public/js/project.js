var createPost = function () {
    $('.createPostButton').click(function (){
        console.log()
        $.post('/createPost?projectId=' +  $("#chatNav").attr("data-projectId") +
            '&title=' +
            $("#titleInput").val() +
            '&body=' +
            $("#bodyInput").val(),
            function (data) {
                console.log(data);
            });
    });
}

var deletePost = function () {
    $('.deletePost').click(function (){
        console.log()
        $.post('/deletePost?postId=' +
            $(this).attr('data-eid'),
            function (data) {
                console.log(data);
            });
    });
}

createPost()
deletePost()