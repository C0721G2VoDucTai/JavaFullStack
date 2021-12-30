import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Subscription} from 'rxjs';
import {Patient} from '../../model/patient';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {MedicalService} from '../../service/medical.service';
import {Medical} from '../../model/medical';



@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  editForm = new FormGroup({
    id: new FormControl(),
    patient: new FormControl(),
    startDay: new FormControl('', [Validators.required]),
    endDay: new FormControl('', [Validators.required]),
    reason: new FormControl('', [Validators.required]),
    treatment: new FormControl('', [Validators.required]),
    doctor: new FormControl('', [Validators.required]),
  });
  id: number;
  subscription: Subscription;
  patients: Patient[];
  medical: Medical;

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private medicalService: MedicalService,
  ) {
  }

  ngOnInit(): void {
    // Lấy list customerType
    this.subscription = this.medicalService.getAllPatient().subscribe(dataType => {
        this.patients = dataType;
        console.log(this.patients);
      }
      , error => {
      });
    // Nhận id từ link edit và sử dụng phương thức tìm theo Id để trả về đối tượng
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      console.log(this.id);
      // Lấy đối tượng từ database
      this.subscription = this.medicalService.findById(this.id).subscribe(data => {
        this.medical = data;
        console.log(this.medical);
        this.editForm.setValue(this.medical);
        console.log(this.editForm.value);
      });
      // end
    });
  }

  // Phương thức để hiển thị list customer type
  compareFn(c1: Patient, c2: Patient): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  onSubmit() {
    this.medical.patient.name = this.editForm.value.patient;
    this.editForm.value.patient = this.medical.patient;

    if (this.editForm.valid) {
      if (this.editForm.valid) {
        this.subscription = this.medicalService.updateMedical(this.id, this.editForm.value).subscribe(data => {
            console.log(this.editForm.value);
            alert('Edit customer successfully');
            confirm('Do you want return to list page');
            if (confirm) {
              this.router.navigate(['/medical']);
            } else {
              this.onSubmit();
            }
          }
          , error => {
            console.log('Not found');
          });
      }
    }
  }

  get patient() {
    return this.editForm.get('patient');
  }

  get startDay() {
    return this.editForm.get('startDay');
  }

  get endDay() {
    return this.editForm.get('endDay');
  }

  get reason() {
    return this.editForm.get('reason');
  }

  get treatment() {
    return this.editForm.get('treatment');
  }

  get doctor() {
    return this.editForm.get('doctor');
  }
}
