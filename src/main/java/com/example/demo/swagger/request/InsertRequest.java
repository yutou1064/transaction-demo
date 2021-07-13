package com.example.demo.swagger.request;

import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Data;

@Data
public class InsertRequest {

  private String id;

  private String name;

  private String age;

  private String email;

}
