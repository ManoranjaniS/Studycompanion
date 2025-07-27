package mano.com.Practising.controller;


import mano.com.Practising.service.OpenRouterAssistant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/assistant")
public class AssistantController {

    private final OpenRouterAssistant openRouterAssistant;

    @Autowired
    public AssistantController(OpenRouterAssistant openRouterAssistant) {
        this.openRouterAssistant = openRouterAssistant;
    }

    @PostMapping("/ask")
    public ResponseEntity<String> ask(@RequestBody Map<String, String> payload) {
        String userMessage = payload.get("message");
        String response = openRouterAssistant.getAIResponse(userMessage);
        return ResponseEntity.ok(response);
    }
}
