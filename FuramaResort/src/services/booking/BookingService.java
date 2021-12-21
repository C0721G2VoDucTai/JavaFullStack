package services.booking;

import services.Service;

public interface BookingService extends Service {
    @Override
    void add();

    @Override
    void display();

    @Override
    void edit();
}
