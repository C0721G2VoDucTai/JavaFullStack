import {Division} from './division';
import {Positions} from './positions';
import {Education} from './education';

export interface Employee {
  id?: number;
  name?: string;
  position: Positions;
  education: Education;
  division: Division;
  birthday?: string;
  id_card?: string;
  salary?: number;
  phone?: string;
  email?: string;
  address?: string;
}
