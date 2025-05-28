package studycompanion.service;

import org.springframework.stereotype.Service;

@Service
public class RoadmapService {
    public String generateRoadmap(String goal, int durationInDays) {
        // Stub: You can enhance this to use AI or predefined logic
        return "Roadmap for goal: " + goal + " over " + durationInDays + " days.";
    }
}