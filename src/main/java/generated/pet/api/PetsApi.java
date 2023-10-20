/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package generated.pet.api;

import generated.pet.model.Pet;
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
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "pets", description = "the pets API")
public interface PetsApi {

    default PetsApiDelegate getDelegate() {
        return new PetsApiDelegate() {};
    }

    /**
     * POST /pets : Create a pet
     *
     * @param pet Pet object that needs to be added to the store (required)
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "createPet",
        summary = "Create a pet",
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Pet.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/pets",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Pet> createPet(
        @Parameter(name = "Pet", description = "Pet object that needs to be added to the store", required = true) @Valid @RequestBody Pet pet
    ) {
        return getDelegate().createPet(pet);
    }


    /**
     * GET /pets : Get all pets
     *
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "getAllPets",
        summary = "Get all pets",
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Pet.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/pets",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Pet>> getAllPets(
        
    ) {
        return getDelegate().getAllPets();
    }

}