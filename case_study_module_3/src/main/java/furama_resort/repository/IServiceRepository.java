package furama_resort.repository;

import furama_resort.bean.employee.Employee;
import furama_resort.bean.service.Service;
import org.omg.PortableServer.Servant;

import java.util.List;

public interface IServiceRepository {
    public List< Service > selectAllService();
    public void insertService(Service service);
}
