import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {DictionaryService} from '../service/dictionary.service';
import {Dictionary} from '../model/dictionary';

@Component({
  selector: 'app-list-word',
  templateUrl: './list-word.component.html',
  styleUrls: ['./list-word.component.css']
})
export class ListWordComponent implements OnInit {
dictionaries: any;
  constructor(
    private dictionaryService: DictionaryService,
    private activatedRoute: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.dictionaries = this.dictionaryService.getAll();
  }

}
