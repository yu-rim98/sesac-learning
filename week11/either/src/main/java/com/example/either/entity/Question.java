package com.example.either.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 200)
    private String optionA;

    @Column(nullable = false, length = 200)
    private String optionB;

//    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE, orphanRemoval = true)
//    private List<Answer> answers = new ArrayList<>();

    public Question(String title, String optionA, String optionB) {
        this.title = title;
        this.optionA = optionA;
        this.optionB = optionB;
    }
}
