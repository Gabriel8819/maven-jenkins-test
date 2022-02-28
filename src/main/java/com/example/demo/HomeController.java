package com.example.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class HomeController {
	
	
	
	private MyRepo myRepo;
	private ObjectMapper objectMapper;

	public HomeController(MyRepo repo, ObjectMapper mapper) {
		this.myRepo = repo;
		this.objectMapper = mapper;
	}
	
	@GetMapping("/home")
	public String getHome() {
		
		
		String s = "http://www.google.com?name=Gabriel Boyer&another=/test";
	
		
		
		
		return "Home controller test - Hello world " + myRepo.getUser();
	}
	
	@PostMapping("/")
	public String postSmee(HttpServletRequest req) throws IOException {
		
		System.out.println("Smee incall");
		
		File file = new File("req-result.txt");
		BufferedWriter writer = Files.newBufferedWriter(file.toPath(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);

		BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String line;
		StringBuilder sb = new StringBuilder();
		while((line = reader.readLine()) != null) {
			sb.append(line);
		}
		
		writer.close();
		reader.close();
		
		String payload = sb.toString();
//		System.out.println(payload);
		
//		String decoded = URLDecoder.decode(payload, StandardCharsets.UTF_8);
		
		JsonNode node = objectMapper.readTree(payload);
		String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
//		
		System.out.println(result);
		
		return "Post Smeeee + testt + another pulll";
	}
	
	
	
	

}

//ansible 
//puppet
//ssh command software
//	run remote script
//vagrant
//shell deployment
//certificate rotation
//transfert script windows to ubuntu


