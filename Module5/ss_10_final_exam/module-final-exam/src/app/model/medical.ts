import {Patient} from './patient';

export interface Medical {
  id: number;
  patient: Patient;
  startDay: string;
  endDay: string;
  reason: string;
  treatment: string;
  doctor: string;
}

