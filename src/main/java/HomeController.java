import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
    @RequestMapping("")
    public String home()
    {
        System.out.println("response accepted");
        return "src/main/webapp/index.html";
    }
}
