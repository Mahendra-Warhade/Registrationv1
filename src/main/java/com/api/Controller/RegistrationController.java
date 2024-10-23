package com.api.Controller;

import com.api.Entity.Registration;
import com.api.Payload.RegistrationDto;
import com.api.Service.RegistrationService;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import lombok.Builder;
import org.hibernate.boot.model.internal.XMLContext;
import org.modelmapper.internal.bytebuddy.dynamic.scaffold.MethodGraph;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @GetMapping
    public ResponseEntity< List<RegistrationDto> >getAllRegistration(){
        List<RegistrationDto> dtos = registrationService.getRegistration();
          return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
    @PostMapping
     public ResponseEntity <Object> createRegistration(
      @Valid @RequestBody RegistrationDto registrationDto,
      BindingResult result
){
        if (result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.CREATED);
        }
    RegistrationDto regDto = registrationService.createRegistration(registrationDto);
     return new ResponseEntity<>(regDto,HttpStatus.CREATED);
}
   @DeleteMapping
    public ResponseEntity<String> deleteRegistration(
           @RequestParam long id
    ){
        registrationService.deleteRegistration(id);
        return new ResponseEntity<>("DELETED",HttpStatus.OK);
   }
   @PutMapping("/{id}")
   public ResponseEntity<Registration>updateRegistration(
           @PathVariable long id,
           @RequestBody Registration registration
   ){
     Registration updateReg =  registrationService.updateRegistration(id,registration);
    return new ResponseEntity<>(updateReg,HttpStatus.OK);
   }
@GetMapping("/{id}")
   public ResponseEntity<RegistrationDto> getRegistrationById(
           @PathVariable long id
   ){
       RegistrationDto dto = registrationService.getRegistrationById(id);
       return new ResponseEntity<>(dto,HttpStatus.INTERNAL_SERVER_ERROR);
   }
}
