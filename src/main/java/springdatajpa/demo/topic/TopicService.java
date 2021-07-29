package springdatajpa.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Basically Singleton. When App starts Spring creates an instance and keeps(registers) it in memory
//Dependency Injection: Other classes (Controller, service, etc.) which depends on this.
// Hey Spring i need this service and then Spring injects this to that caller class
@Service
public class TopicService {

    /*using embedded apache derby database. see pom.xml*/
    /*The framework sees the embedded Derby db in the classpath and assumes that to be the db to connect to.
    No connection info necessary.*/

    /*
    //PREVIOUS:
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
                new Topic("spring", "SpringFramework", "SF Description"),
                new Topic("java", "Core Java", "CJ Description"),
                new Topic("javascript", "JavaScript", "JS Description")
        ));*/


    @Autowired
    private TopicRepository topicRepository;


    public List<Topic> getAllTopics()
    {
        //******topicRepository.findAll()*********//
        //1. Connect to DB
        //2. Run a query
        //3. Get all the topics
        //4. Convert each of those rows into Topic instances
        //5. fetch it
        List<Topic> topicList = new ArrayList<>();
        //topicRepository.findAll().forEach(topic -> { topicList.add(topic); });
        //OR use method reference:
        topicRepository.findAll().forEach(topicList::add);
        return topicList;
        //PREVIOUSLY: return topics;
    }


    public Optional<Topic> getTopic(String id)
    {
        Optional<Topic> topic = topicRepository.findById(id);
        return topic;
        // PREVIOUSLY: return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }


    public void addTopic(Topic topic)
    {
        topicRepository.save(topic);
        //PREVIOUSLY: topics.add(topic);
    }


    public void updateTopic(Topic topic, String id)
    {
        //Repository knows, does an insert if topic (id) does not exist
        //Otoh it updates if topic (id) exists
        topicRepository.save(topic);
    }

    public void deleteTopic(String id)
    {
        topicRepository.deleteById(id);
        //PREVIOUSLY: topics.removeIf(topic -> topic.getId().equals(id));
    }
}
