package com.anz.ddtb.account.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;
import static com.anz.ddtb.account.common.Constants.CREATED_BY;
import static com.anz.ddtb.account.common.Constants.CREATED_ON;
import static com.anz.ddtb.account.common.Constants.UPDATED_BY;
import static com.anz.ddtb.account.common.Constants.UPDATED_ON;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
/**
 * Super Entity for Audit
 */
public class SuperEntity {

    @Column(name = CREATED_BY, length = 100)
    private String createdBy;

    @Column(name = CREATED_ON)
    @CreationTimestamp
    private LocalDateTime createdOn;

    @Column(name = UPDATED_BY, length = 100)
    private String updatedBy;

    @Column(name = UPDATED_ON)
    @CreationTimestamp
    private LocalDateTime updatedOn;

    @PrePersist
    public void prePersist(){
        createdOn = LocalDateTime.now();
    }

}
