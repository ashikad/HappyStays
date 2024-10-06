package Service;

import Entity.Booking;
import Entity.Property;
import Repository.BookingRepository;
import Repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

   @Autowired
   private final BookingRepository bookingRepository;

   @Autowired
   private final PropertyRepository propertyRepository;



   @Override
   public Booking createBooking(Long propertyId, LocalDate startDate, LocalDate endDate) {
      Property property = propertyRepository.findById(propertyId)
              .orElseThrow(() -> new RuntimeException("Property Not Found!"));

      Booking booking = new Booking();
      booking.setProperty(property);
      booking.setStartDate(startDate);
      booking.setEndDate(endDate);

      return bookingRepository.save(booking);

   }

   @Override
   public List<Booking> getAllBookings() {
      return bookingRepository.findAll();
   }

   public Booking getBookingById(Long bookingId){
      return bookingRepository.findById(bookingId)
              .orElseThrow(() -> new RuntimeException("No such booking found!"));
   }


   public List<Booking> getBookingsByProperty(Long propertyId) {
      return bookingRepository.findByPropertyId(propertyId);
   }

   @Override
   public void deleteBooking(Long id) {
      Booking booking = bookingRepository.findById(id)
              .orElseThrow(()-> new RuntimeException("No such booking found!"));

      bookingRepository.delete(booking);
   }
}
