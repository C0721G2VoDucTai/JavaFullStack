package services.contract;

import services.Service;

public interface ContractService extends Service {
    @Override
    void add();

    @Override
    void display();

    @Override
    void edit();
}
