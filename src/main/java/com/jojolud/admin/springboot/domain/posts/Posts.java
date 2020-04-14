package com.jojolud.admin.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
//@Getter : 클래스 내 모든 필드의 Getter 메소드를 자동생성
@NoArgsConstructor
//@NoArgsConstructor : 기본 생성자 자동 추가
//public Posts() {}와 같은 효과
@Entity
//Entity : 테이블과 링크될 클래스임을 나타냄
//기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭함
// ex)SalesManager.java -> sales_manage table
public class Posts {
    @Id
    //Id : PK의 생성 규칙을 나타냄
    //스프링 부트 2.0 에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 됨
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    //@Column : 테이블의 컬럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됨
    //사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용함
    //문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나 , 타입을 TEXT로 변경하고 싶거나 등의 경우에 사용됨
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder
    //@Builder : 해당 클래스의 빌더 패턴 클래스를 생성
    //생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
