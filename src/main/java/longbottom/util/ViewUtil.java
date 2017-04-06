package longbottom.util;

// This file was copied from the following link:
// https://github.com/tipsy/spark-basic-structure/blob/master/src/main/java/app/util/ViewUtil.java
// Link to original code license: https://github.com/tipsy/spark-basic-structure/blob/master/LICENSE

import org.apache.velocity.app.*;
import org.eclipse.jetty.http.*;
import spark.*;
import spark.template.velocity.*;
import java.util.*;


public class ViewUtil {


    public static String render( Map<String, Object> model, String templatePath) {

        //will uncomment these lines if needed in application D.B

        //model.put("currentUser", getSessionCurrentUser(request));
        //model.put("WebPath", Path.Web.class); // Access application URLs from templates
        return strictVelocityEngine().render(new ModelAndView(model, templatePath));
    }

    private static VelocityTemplateEngine strictVelocityEngine() {
        VelocityEngine configuredEngine = new VelocityEngine();
        configuredEngine.setProperty("runtime.references.strict", true);
        configuredEngine.setProperty("resource.loader", "class");
        configuredEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        return new VelocityTemplateEngine(configuredEngine);
    }
}
