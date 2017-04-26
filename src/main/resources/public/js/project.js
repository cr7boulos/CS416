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
    $('.deletePostButton').click(function (){
        console.log()
        $.post('/deletePost?postId=' +
            $("#id").val(),
            function (data) {
                console.log(data);
            });
    });
}

createPost()
deletePost()