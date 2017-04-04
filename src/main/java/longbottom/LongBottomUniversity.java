package longbottom;

import static spark.Spark.*;


public class LongBottomUniversity {

    public static void main(String[] args){

        //which local port application binds to
        port(1250);

        get("/hello", (req, res) -> {
           return "hello world!";
        });
    }
}
