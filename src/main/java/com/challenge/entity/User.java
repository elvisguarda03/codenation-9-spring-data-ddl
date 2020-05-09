package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "full_name", length = 100, nullable = false)
    private String fullName;

    @Email
    @NotNull
    @Size(max = 100)
    @Column(length = 100, nullable = false)
    private String email;

    @Size(max = 50)
    @NotNull
    @Column(length = 50, nullable = false)
    private String nickname;

    @Size(max = 255)
    @NotNull
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "id.user")
    private List<Candidate> candidates;

    @OneToMany(mappedBy = "id.user")
    private List<Submission> submissions;

    @CreatedDate
    private LocalDateTime createdAt;
}
