package voductai.furama_resort.dto;

public interface CustomerUseServiceDTO {
// Task 6 - Hiển thị khách hàng sử dụng dịch vụ, nếu có dịch vụ đi kèm hiển thị ra
    public Integer getId();

    public String getName();

    public String getId_card();

    public String getService_attach();

    public Integer getUnit();

    public Double getCost();

    public Integer getQuantity();

}
