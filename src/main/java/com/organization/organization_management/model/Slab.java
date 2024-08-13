package com.organization.organization_management.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "slab")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Slab {
    @Id
    private String id;
    private Integer lower_limit;
    private Integer upper_limit;
    private String title;
}
