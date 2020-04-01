package com.hello.entities;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("hotels")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @PrimaryKey
    private UUID id;
    private String name;
    private String address;
    private String zip;
    private Integer version;
    
}
