package kr.or.lx.server;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.lx.common.ApiService;
import lombok.extern.slf4j.Slf4j;


@RequestMapping("server/transmission")
@Slf4j
@Controller
public class TransmissionController {
	
    @Value("${agent.server.api.url}")
    private String agentApiUrl;	
   
	@Autowired
	private ApiService<?> apiService;
	
	@GetMapping("/send")
	public String sendDataList(ModelMap model) throws Exception{
		log.info("sendDataList");
		
		return "server/transmission/send";
	}
	
	@GetMapping("/reception")
	public String receptionDataList(ModelMap model) throws Exception{
		log.info("receptionDataList");
		
		return "server/transmission/reception";
	}

	@ResponseBody
	@PostMapping("{apiId}")
	public Object transmission(@RequestBody Map<String, Object> param, ModelMap model) throws Exception{
		log.info("transmission");
		
		String url = agentApiUrl+param.get("url");
		
		ResponseEntity<?> responseEntity = apiService.post(url, param);
		Object object = responseEntity.getBody();
		
		return object;
	}	
}
