package mano.com.Practising.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import mano.com.Practising.model.AssistantMessage;
import mano.com.Practising.repository.AssistantMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AssistantService {

    @Autowired
    private AssistantMessageRepository repository;

    @Autowired
    private OpenRouterAssistant openRouterAssistant;

    public AssistantMessage ask(String userInput) {
        String response = openRouterAssistant.getAIResponse(userInput);

        AssistantMessage msg = new AssistantMessage();
        msg.setUserMessage(userInput.trim());
        msg.setAiResponse(response);
        msg.setTimestamp(LocalDateTime.now());
        return repository.save(msg);
    }

    public List<AssistantMessage> getAllMessages() {
        return repository.findAll();
    }
}
