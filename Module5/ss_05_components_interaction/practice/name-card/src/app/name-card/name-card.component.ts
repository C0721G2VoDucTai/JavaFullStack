import {Component, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-name-card',
  templateUrl: './name-card.component.html',
  styleUrls: ['./name-card.component.css']
})
export class NameCardComponent implements OnInit {
  @Input() cardName: string;
  @Input() email: string;
  @Input() number: string;

  constructor() {
  }

  ngOnInit(): void {
  }

}
