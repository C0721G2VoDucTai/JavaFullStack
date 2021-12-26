import {CustomerType} from './customer-type';

export interface Customer {
  id: number;
  name: string;
  customer_type: CustomerType;
  birthday: string;
  gender: number;
  id_card: string;
  phone: string;
  email: string;
  address: string;
}
