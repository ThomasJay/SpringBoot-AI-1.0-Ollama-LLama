package com.thomasjayconsulting.sbai.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ai.ollama.OllamaChatModel;

import java.util.Map;

@Service@Slf4j
public class OllamaLLMService {

    private OllamaChatModel chatModel;

    OllamaLLMService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

//    public String chat(String query) {
//        String response = chatModel.call(query);
//
//        return response;
//    }

//    public String chat(String query) {
//
//        Prompt prompt = new Prompt(query);
//
//        String response = chatModel.call(prompt).getResult().getOutput().getContent();
//
//        return response;
//    }

//    public String chat(String query) {
//
//        String message = """
//            <INST>You are an AI assistant that can answer your questions. If you don't know
//            the answer, don't make suggestions just say "I don't know".</INST>
//            question: {input}
//            """;
//        PromptTemplate promptTemplate = new PromptTemplate(message);
//
//        Prompt prompt = promptTemplate.create(Map.of("input", query));
//
//        String response = chatModel.call(prompt).getResult().getOutput().getContent();
//
//        return response;
//    }

    private String myContent = """
            Tom is a programmer working for Acme Programming.
            
            Tom is under paid.
            
            Bob is a programmer working for Acme Programming.
            
            Bob is paid more than Tom.
            
            Acme Programming is a consulting company that employs programmers.
            
            """;

    public String chat(String query) {

        String message = """
            <INST>You are an AI assistant that can answer your questions. Use the content provided. If you don't know
            the answer, don't make suggestions just say "I don't know".</INST>
            content: {content}
            question: {input}
            """;
        PromptTemplate promptTemplate = new PromptTemplate(message);

        Prompt prompt = promptTemplate.create(Map.of("input", query, "content", myContent));

        String response = chatModel.call(prompt).getResult().getOutput().getContent();

        return response;
    }



}
