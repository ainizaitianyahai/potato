package com.potato.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.potato.entity.MySource_ES;
@Controller
@RequestMapping("/es")
public class ESController {

	@Autowired
	RestTemplateBuilder builder;
	
	@GetMapping("/insert")
	@ResponseBody
	public String insert(String id) {
		MySource_ES source = new MySource_ES();
		source.setMessage("message");
		source.setPostDate(new Date());
		source.setUser("user");
		
		RestTemplate template = builder.build();
		HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(JSONObject.toJSONString(source), headers);
        String s = template.postForObject("http://localhost:9200/potato/es/"+id+"?pretty", formEntity, String.class);
		return s;
	}
	@GetMapping("/search")
	@ResponseBody
	public String search() {
		RestTemplate template = builder.build();
		HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
     // ES 查询语句
//        String requestStr = "{" + 
//        		"  \"query\": {" + 
//        		"    \"match\": {" + 
//        		"        \"content\" : {" + 
//        		"            \"query\" : \"message\"" + 
//        		"        }" + 
//        		"    }" + 
//        		"  }" + 
//        		"}";
        String requestStr = "{ \"query\": { \"match_phrase\": {\"source.user\":\"user\"}},\"sort\": { \"_id\": { \"order\": \"desc\" } }}";
        System.out.println(requestStr); 
        
        HttpEntity<String> formEntity = new HttpEntity<String>(requestStr, headers);
        String s = template.postForObject("http://localhost:9200/potato/es/_search?pretty", formEntity, String.class);
		return s;
	}
	@GetMapping("/search_get")
	@ResponseBody
	public String search_get(Integer id) {
		RestTemplate template = builder.build();
		Map<String,Object> paras = new HashMap<String, Object>();
		paras.put("id",id);
		String str = template.getForObject("http://127.0.0.1:9200/potato/es/{id}", String.class,paras);
		return str;
	}
}
