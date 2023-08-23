package philips.courier.cont;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/Create")
    public String Create()
    {
        return "Create";
    }

     @RequestMapping("/Update")
    public String Update()
    {
        return "Update";
    }

     @RequestMapping("/Delete")
    public String Delete()
    {
        return "Delete";
    }


}
