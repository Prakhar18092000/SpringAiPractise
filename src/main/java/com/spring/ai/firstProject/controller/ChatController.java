package com.spring.ai.firstProject.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClient.Builder;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatController {
  private ChatClient openAichatClient;
  
  
//    IN THIS METHOD CHATMODEL IS AUTOWIRED WITH THE HELP OF BUILDER METHOD 
//  public ChatController(ChatClient.Builder builder)  {
//	  this.chatClient=builder.build();
//  }
  
  
     //if we dont want chatclient to be auto autowired then we can use below method
     //Genrrally this metod is used if we want to use diffrent chat models in a single project
     //For disabling this automatic bean injection we need to add property in application.properties file 
//   public ChatController(OpenAiChatModel openAichatClient)  {
//	  this.openAichatClient=ChatClient.builder(openAichatClient).build();
//  }
  
  public ChatController(@Qualifier("openAiChatClientBean") ChatClient openAichatClient) {
		
		this.openAichatClient = openAichatClient;
	}
  

	@GetMapping("/chat")
	public ResponseEntity<String> chat(
			@RequestParam(value="query" , required=true) String q
			) {
		        String responseMessage=openAichatClient.prompt(q).call().content();
				return ResponseEntity.ok(responseMessage);
		
		
	}



	
}
