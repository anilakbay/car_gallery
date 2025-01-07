package com.anilakbay.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createTime;
}
