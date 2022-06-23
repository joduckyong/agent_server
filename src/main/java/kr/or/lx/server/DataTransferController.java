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


@RequestMapping("server/dataTransfer")
@Slf4j
@Controller
public class DataTransferController {
	
    @Value("${agent.api.url}")
    private String agentApiUrl;	
   
	@Autowired
	private ApiService<?> apiService;
	
	@GetMapping("/list")
	public String dataTransferList(ModelMap model) throws Exception{
		
		
		return "server/dataTransfer/list";
	}	
	
	// File 데이터 수집방식 상세조회
	@ResponseBody
	@PostMapping("{apiId}")
	public Object dataTransfer(@RequestBody Map<String, Object> param, ModelMap model) throws Exception{
		log.info("dataTransfer");
		
		String url = agentApiUrl+param.get("url");
		
		ResponseEntity<?> responseEntity = apiService.post(url, param);
		Object object = responseEntity.getBody();
		
		return object;
	}	

	
}
