package com.spring.ai.firstProject.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {
	
	@Bean(name="openAiChatClientBean")
	public ChatClient openAiChatModel(OpenAiChatModel chatModel) {
		return ChatClient.builder(chatModel).build();
		
	}

}
