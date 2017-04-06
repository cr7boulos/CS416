package longbottom.util;

import org.apache.commons.collections.map.HashedMap;
import spark.*;
import java.util.*;




/**
 * Created by cr7bo on 4/5/2017.
 */
public class DemoController {

    //this method is a Java 8 feature called a functional interface
    public static Route testing = (Request request, Response response) -> {
                //^ this is not the return type!
                //Tip: highlight the word "Route" in the function signature above and
                //go to the code definition by typing: Control + b
                //There you will see that the actual return type of
                //this interface is an Object
        System.out.println(request.queryParams("test"));

        //see the Spark docs for more useful methods
        //http://sparkjava.com/documentation.html#response
        //http://sparkjava.com/documentation.html#request
        Map<String, Object> model = new HashMap<>();
        return ViewUtil.render(model, "/velocity/test.vm");
    };

}
