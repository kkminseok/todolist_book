package spring_react_book.todolist.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoEntity {
    private String id; //이 오브젝트 id
    private String userId; // user아이디
    private String title; //오브젝트의 제목
    private boolean done; // 했는지 안했는지
}

// Builder -> 매개변수 순서를 기억할 필요가 없음.
// NoArgs~ -> 매개변수가 없는 생성자 자동생성
// AllArgs~ -> 매개변수가 모두 있는 생성자 자동생성
// Data -> get/set
