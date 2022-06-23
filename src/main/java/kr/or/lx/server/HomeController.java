package kr.or.lx.server;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@RequestMapping("server/home")
@Slf4j
@Controller
public class HomeController {
	
	@GetMapping
	public String serverHome(ModelMap model) throws Exception{
		log.info("serverHome");
		
		return "server/home";
	}
	
	
}
