package spring_react_book.todolist.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_react_book.todolist.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {

    UserEntity findByEmail(String email);
    Boolean existsByEmail(String email);
    UserEntity findByEmailAndPassword(String email, String password);
}
