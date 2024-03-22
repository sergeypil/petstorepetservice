package com.chtrembl.petstore.pet.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    @NotNull
    private String name;

    @NotNull
    private String photoURL;

    @ManyToMany(cascade = {CascadeType.ALL })
    @JoinTable(
        name = "pettag",
        joinColumns = { @JoinColumn(name = "pet_id") },
        inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
    private List<Tag> tags;
    
    @Convert(converter = StatusEnumConverter.class)
    private StatusEnum status;
}