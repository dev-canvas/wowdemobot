package ru.wowdemobot.bot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @CreatedDate
    @Column (name = "created_at", nullable = false, updatable = false)
    @JsonProperty (access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column (name = "updated_at")
    @JsonProperty (access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime updatedAt;

    @CreatedBy
    @Column (name = "created_by")
    private String createdBy;

    @LastModifiedBy
    @Column (name = "modified_by")
    @JsonProperty (access = JsonProperty.Access.READ_ONLY)
    private String modifiedBy;

    @Column (name = "is_active", nullable = false)
    private boolean isActive = true;

}
