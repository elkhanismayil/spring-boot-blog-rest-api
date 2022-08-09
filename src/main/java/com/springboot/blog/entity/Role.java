package com.springboot.blog.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "role")
@RequiredArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    private @NonNull String name;
}
