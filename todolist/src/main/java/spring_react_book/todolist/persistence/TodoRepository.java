package spring_react_book.todolist.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_react_book.todolist.model.TodoEntity;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity,String> {
    List<TodoEntity> findByUserId(String userId);
}
