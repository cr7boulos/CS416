package longbottom;

import longbottom.util.DemoController; //import the needed controller classes here

import static spark.Spark.*;


public class LongBottomUniversity {

        public static void main(String[] args){

        //which local port application binds to
        port(1250);
        staticFiles.location("/public");

        get("/hello", (req, res) -> {
           return "hello world!";
        });

        // Simple controller test.
        // to see the results of this controller
        // In Postman, set the request type to POST then
        // paste this URL below where is says "Enter request URL":
        // localhost:1250/post?test=456
        post("/post", DemoController.testing);
    }
}
