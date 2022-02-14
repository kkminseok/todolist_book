package spring_react_book.todolist.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_react_book.todolist.model.TodoEntity;
import spring_react_book.todolist.persistence.TodoRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public String testService(){

        //TodoEntity create
        TodoEntity entity = TodoEntity.builder().title("My first todo item").build();
        //TodoEntity save
        repository.save(entity);
        //TodoEntity search
        TodoEntity savedEntity = repository.findById(entity.getId()).get();
        return savedEntity.getTitle();
    }

    public List<TodoEntity> create(final TodoEntity entity){
        //Validations
        validate(entity);

        repository.save(entity);
        log.info("Entity Id : {} is saved.",entity.getId());
        return repository.findByUserId(entity.getUserId());

    }

    private void validate(TodoEntity entity) {
        if(entity ==null){
            log.warn("Entity cannot be null.");
            throw new RuntimeException("Entity cannot be null");
        }
        if(entity.getUserId() == null){
            log.warn("Unknown user.");
            throw new RuntimeException("Unknown user.");
        }
    }

    public List<TodoEntity> retrieve(final String userId){
        return repository.findByUserId(userId);
    }

    public List<TodoEntity> update(final TodoEntity entity){

        validate(entity);

        log.info("entity id : {}",entity.getId());
        final Optional<TodoEntity> original = repository.findById(entity.getId());
        log.info("original id = {}",original.get().getId());
        original.ifPresent(todo ->{
            todo.setTitle(entity.getTitle());
            todo.setDone(entity.isDone());

            repository.save(todo);
        });

        return retrieve(entity.getUserId());
    }

    public List<TodoEntity> delete(final TodoEntity entity){
        validate(entity);

        try{
            repository.delete(entity);
        }catch(Exception e){
            log.error("error deleting entity" , entity.getId(),e);

            throw new RuntimeException("error deleting entity" + entity.getId());
        }

        return retrieve(entity.getUserId());
    }
}
