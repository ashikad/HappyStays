package Service;


import Entity.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    public Booking createBooking(Long propertyId, LocalDate startDate, LocalDate endDate);

    public List<Booking> getAllBookings();

    public List<Booking> getBookingsByProperty(Long propertyId);

    public void deleteBooking(Long id);



}
