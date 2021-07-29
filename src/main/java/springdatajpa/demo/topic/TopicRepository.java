package springdatajpa.demo.topic;

import org.springframework.data.repository.CrudRepository;

//No need to implement our own data layer, just extend the Spring data jpa's CrudRepository
//Note the generic type...
//Hence, Out-of-the-box CRUD ops
public interface TopicRepository extends CrudRepository<Topic, String> {
}
