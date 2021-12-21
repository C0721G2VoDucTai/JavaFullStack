package furama_resort.repository;

import furama_resort.bean.contract.Contract;
import furama_resort.bean.service.Service;

import java.util.List;

public interface IContractRepository {
    public List< Contract > selectAllContract();
    public void insertContract(Contract contract);
}
