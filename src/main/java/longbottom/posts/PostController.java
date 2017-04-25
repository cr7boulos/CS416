package longbottom.posts;

import longbottom.DAO.DAO;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Created by Maxwell on 4/25/2017.
 */
public class PostController {

    public static Route createPost = (Request request, Response response) -> {
        int projectId = Integer.parseInt(request.queryParams("projectId"));
        String header = request.queryParams("title");
        String body = request.queryParams("body");

        if(DAO.createPost(projectId, header, body))
            return "Post created";
        else
            return "Did not create post. Please retry.";


    };

    public static Route deletePost = (Request request, Response response) -> {

        int postId = Integer.parseInt(request.queryParams("postId"));

        if(DAO.deletePost(postId))
            return "Delete successful.";
        else
            return "Delete failed.";
    };

}
