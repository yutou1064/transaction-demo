package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.print.DocFlavor.STRING;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "user")
@Data
@Accessors(chain = true)
public class User {

  @Id
  @Column
  private Long id;

  @Column
  private String name;

  @Column
  private Integer age;

  @Column
  private String email;

}
