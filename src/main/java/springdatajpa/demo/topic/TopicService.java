package springdatajpa.demo.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Basically Singleton. When App starts Spring creates an instance and keeps(registers) it in memory
//Dependency Injection: Other classes (Controller, service, etc.) which depends on this.
// Hey Spring i need this service and then Spring injects this to that caller class
@Service
public class TopicService {

    //Arrays.asList creates a non-mutable List (cannot add/remove things from list)
    //So, to edit the list passed itto a new AL constructor which is mutable
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
                new Topic("spring", "SpringFramework", "SF Description"),
                new Topic("java", "Core Java", "CJ Description"),
                new Topic("javascript", "JavaScript", "JS Description")
        ));

    public List<Topic> getAllTopics()
    {
        return topics;
    }


    public Topic getTopic(String id)
    {
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }


    public void addTopic(Topic topic)
    {
        topics.add(topic);
    }


    public void updateTopic(Topic topic, String id) {
        for (int i=0; i<topics.size(); i++)
        {
            Topic t = topics.get(i);
            if (t.getId().equals(id))
            {
                topics.set(i, topic);
                return;
            }

        }
    }

    public void deleteTopic(String id)
    {
        //Topic t = topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
        //topics.remove(t);
        topics.removeIf(topic -> topic.getId().equals(id));
    }
}
