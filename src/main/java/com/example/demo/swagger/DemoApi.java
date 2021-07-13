package com.example.demo.swagger;

import com.example.demo.swagger.request.InsertRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-29T03:14:37.943Z[GMT]")
@Validated
public interface DemoApi {

  @Operation(summary = "", description = "获取用户，只读（readOnly）", tags={ "get" })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = String.class))) })
  @RequestMapping(value = "/get",
      produces = { "application/json" },
      //consumes = { "application/json" },
      method = RequestMethod.GET)
  ResponseEntity<String> get(String id) throws Exception;

  @Operation(summary = "", description = "新增用户，事务为正常（PROPAGATION.REQUIRED）", tags={ "insert" })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = String.class))) })
  @RequestMapping(value = "/insert",
      produces = { "application/json" },
      //consumes = { "application/json" },
      method = RequestMethod.POST)
  ResponseEntity<String> insert(InsertRequest request) throws Exception;

  @Operation(summary = "", description = "修改用户，事务为新开事务（PROPAGATION.REQUIRES_NEW）", tags={ "update" })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = String.class))) })
  @RequestMapping(value = "/update",
      produces = { "application/json" },
      //consumes = { "application/json" },
      method = RequestMethod.POST)
  ResponseEntity<String> update(InsertRequest request) throws Exception;

  @Operation(summary = "", description = "删除用户，事务为新开事务（PROPAGATION.REQUIRES_NEW）", tags={ "delete" })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = String.class))) })
  @RequestMapping(value = "/delete",
      produces = { "application/json" },
      //consumes = { "application/json" },
      method = RequestMethod.GET)
  ResponseEntity<String> delete(String id) throws Exception;
}
