package longbottom.posts;

import longbottom.DAO.DAO;
import longbottom.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static Route getAllPosts = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        int projectId = Integer.parseInt(request.queryParams("projectId"));
        List<Map<String, Object>> postList = DAO.getPostsByProjectId(projectId);
        model.put("postList", postList);
        return ViewUtil.render(model, "/velocity/post_partial.vm");
    };

}
