package Controller;

import Entity.Property;
import Service.PropertyService;
import Service.PropertyServiceImpl;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property")
@AllArgsConstructor
public class PropertyController {

    @Autowired
    private final PropertyServiceImpl propertyService;

    @PostMapping("/createProperty")
    public Property createProperty(@RequestBody Property property, @RequestParam Long userId){

        return propertyService.createProperty(property,userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long propertyId){
        Property property = propertyService.getPropertyById(propertyId);
        return ResponseEntity.ok(property);
    }

    @GetMapping("/getProperties")
    public List<Property> getAllProperties(){
        return propertyService.getAllProperties();
    }


}
