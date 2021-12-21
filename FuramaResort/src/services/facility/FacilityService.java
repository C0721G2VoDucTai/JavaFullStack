package services.facility;

import services.Service;
import utils.WrongFormatException;

public interface FacilityService extends Service {
    @Override
    void add();

    @Override
    void display();

    @Override
    void edit();

    void displayMaintenance();
}
