package Service;

import Entity.Property;
import Entity.User;
import Repository.PropertyRepository;
import Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService{

    @Autowired
    private final PropertyRepository propertyRepository;

    @Autowired
    private final UserRepository userRepository;
    @Override
    public Property createProperty(Property property, Long userId) {
        User owner = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found!"));
        property.setOwner(owner);
        return propertyRepository.save(property);
    }

    @Override
    public Property getPropertyById(Long propertyId) {
        return propertyRepository.findById(propertyId)
                .orElseThrow(()->new RuntimeException("Property Not Found"));
    }

    public List<Property> getAllProperties(){
        return propertyRepository.findAll();
    }


}
