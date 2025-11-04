package com.bn.tasks.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "task_list")
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false )
    private String tile;

    private String description;

    @OneToMany(mappedBy = "taskList"
            , cascade = {
            CascadeType.REMOVE,
            CascadeType.PERSIST
        }
    )
    private List<Task> tasks;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(insertable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
