package org.rosicleidefranca.todosimples.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table (name ="task")
@Setter @Getter @ToString @EqualsAndHashCode @AllArgsConstructor @NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name= "user_id", nullable = false,updatable = false)
    private User user;

    @Column(name="description", nullable=false, length = 255)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String description;
}

