var createPost = function () {
    $('.createPostButton').click(function (){
        console.log()
        $.post('/createPost?projectId=' +  $("#chatNav").attr("data-projectId") +
            '&title=' +
            $("#titleInput").val() +
            '&body=' +
            $("#bodyInput").val(),
            function (data) {
                getAllPosts();
            });
    });
}

/*/
var deletePost = function () {

    $('#deletePostModal').on('show.bs.modal', function (event) {
        var btn = $(event.relatedTarget);
        $('#submitDeletePost').click(function () {
        console.log()
        $.post('/deletePost?postId=' +
            btn.attr('data-eid'),
            function (data) {
                console.log(data);
            });
        });
    });
}
/*/


var getAllPosts = function () {
    $.post("/getPostPartial?projectId=" +
        $('#chatNav').attr('data-projectId'),
        function (data) {
            $('#post_partial').html(data);

            $('#deletePostModal').on('show.bs.modal', function (event) {
                var btn = $(event.relatedTarget);
                $('#submitDeletePost').click(function () {
                console.log()
                $.post('/deletePost?postId=' +
                    btn.attr('data-eid'),
                    function (data) {
                        console.log(data);
                        getAllPosts();
                    });
                });
            });
        });
}

createPost();
getAllPosts();