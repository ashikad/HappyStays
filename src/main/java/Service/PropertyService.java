package Service;

import Entity.Property;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyService {

    public Property createProperty(Property property, Long userId);

    public Property getPropertyById(Long propertyId);
}
