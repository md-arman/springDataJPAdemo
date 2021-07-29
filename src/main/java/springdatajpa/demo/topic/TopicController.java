package springdatajpa.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    //Declare the dependency
    // not using 'new', Spring looks for instance of TopicService in its registry, and
    // injects that to this instance
    @Autowired
    private springdatajpa.demo.topic.TopicService topicService;


    //whatever is returned here gets automatically converted to JSON bcz of @RestController
    @RequestMapping("/topics")
    public List<Topic> getAllTopics ()
    {
        //return: MVC converts response into JSON on its own(internal mechanism)
        return topicService.getAllTopics();
    }


    //PathVariable takes variable: foo from path: topics/foo and passes it to parameter: id
    @RequestMapping("/topics/{foo}")
    public Topic getTopic(@PathVariable String id)
    {
        return topicService.getTopic(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic)
    {
        topicService.addTopic(topic);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id)
    {
        topicService.updateTopic(topic, id);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id)
    {
        topicService.deleteTopic(id);
    }

}
