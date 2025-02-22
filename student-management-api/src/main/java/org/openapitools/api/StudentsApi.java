/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.11.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.Student;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-21T03:24:18.366564200+05:30[Asia/Calcutta]", comments = "Generator version: 7.11.0")
@Validated
@Tag(name = "students", description = "the students API")
public interface StudentsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /students : Get all students
     *
     * @return List of students (status code 200)
     */
    @Operation(
        operationId = "studentsGet",
        summary = "Get all students",
        responses = {
            @ApiResponse(responseCode = "200", description = "List of students", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Student.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/students",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Student>> studentsGet(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"phoneNumber\" : \"1234567890\", \"name\" : \"Kshitij\", \"className\" : \"10th Grade\", \"id\" : 0, \"age\" : 25 }, { \"phoneNumber\" : \"1234567890\", \"name\" : \"Kshitij\", \"className\" : \"10th Grade\", \"id\" : 0, \"age\" : 25 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /students/{id} : Delete a student by ID
     *
     * @param id  (required)
     * @return Student deleted successfully (status code 204)
     *         or Student not found (status code 404)
     */
    @Operation(
        operationId = "studentsIdDelete",
        summary = "Delete a student by ID",
        responses = {
            @ApiResponse(responseCode = "204", description = "Student deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/students/{id}"
    )
    
    default ResponseEntity<Void> studentsIdDelete(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /students/{id} : Get a student by ID
     *
     * @param id  (required)
     * @return Student details (status code 200)
     *         or Student not found (status code 404)
     */
    @Operation(
        operationId = "studentsIdGet",
        summary = "Get a student by ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Student details", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))
            }),
            @ApiResponse(responseCode = "404", description = "Student not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/students/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Student> studentsIdGet(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"phoneNumber\" : \"1234567890\", \"name\" : \"Kshitij\", \"className\" : \"10th Grade\", \"id\" : 0, \"age\" : 25 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /students/{id} : Update a student by ID
     *
     * @param id  (required)
     * @param student  (required)
     * @return Student updated successfully (status code 200)
     *         or Student not found (status code 404)
     */
    @Operation(
        operationId = "studentsIdPut",
        summary = "Update a student by ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Student updated successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))
            }),
            @ApiResponse(responseCode = "404", description = "Student not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/students/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Student> studentsIdPut(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
        @Parameter(name = "Student", description = "", required = true) @Valid @RequestBody Student student
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"phoneNumber\" : \"1234567890\", \"name\" : \"Kshitij\", \"className\" : \"10th Grade\", \"id\" : 0, \"age\" : 25 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /students : Add a new student
     *
     * @param student  (required)
     * @return Student created successfully (status code 201)
     *         or Invalid input (status code 400)
     */
    @Operation(
        operationId = "studentsPost",
        summary = "Add a new student",
        responses = {
            @ApiResponse(responseCode = "201", description = "Student created successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/students",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Student> studentsPost(
        @Parameter(name = "Student", description = "", required = true) @Valid @RequestBody Student student
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"phoneNumber\" : \"1234567890\", \"name\" : \"Kshitij\", \"className\" : \"10th Grade\", \"id\" : 0, \"age\" : 25 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
