import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculation',
  templateUrl: './calculation.component.html',
  styleUrls: ['./calculation.component.css']
})
export class CalculationComponent implements OnInit {
  numberOne: number;
  numberTwo: number;
  cal: string;
  result: string;

  calculator() {
    if (this.cal === '+') {
      console.log(this.cal);
      this.result = ' = ' + (this.numberOne + this.numberTwo).toString();
    } else if (this.cal === '-') {
      this.result = ' = ' + (this.numberOne - this.numberTwo).toString();
    } else if (this.cal === '*') {
      this.result = ' = ' + (this.numberOne * this.numberTwo).toString();
    } else{
      if (this.numberTwo !== 0) {
        this.result = ' = ' + (this.numberOne / this.numberTwo).toString();
      }else{
        this.result = 'Cant division by 0';
      }
    }
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
