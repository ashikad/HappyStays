package Controller;

import Entity.Booking;
import Service.BookingService;
import Service.BookingServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private final BookingServiceImpl bookingService;

    @PostMapping("/createBooking")
    public Booking createBooking(@RequestBody Long propertyId, @RequestBody LocalDate startDate, @RequestBody LocalDate endDate){

        return bookingService.createBooking(propertyId, startDate, endDate);
    }

    @GetMapping("/getBooking/{id}")
    public Booking getBookingById(@PathVariable Long bookingId){
        return bookingService.getBookingById(bookingId);
    }

    @GetMapping("/getBookings")
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/property/{propertyId}")
    public List<Booking> getBookingsByProperty(@PathVariable Long propertyId){
        return bookingService.getBookingsByProperty(propertyId);
    }

    @DeleteMapping("/deleteBooking/{bookindId}")
    public void deleteBooking(@PathVariable Long bookingId){
        bookingService.deleteBooking(bookingId);
    }
}
