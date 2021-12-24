import { Injectable } from '@angular/core';
import {Dictionary} from '../model/dictionary';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
dictionaries = [
  {id: 1, word: 'House', mean: 'Ngôi nhà'},
  {id: 2, word: 'Car', mean: 'Ô tô'},
  {id: 3, word: 'Motorbike', mean: 'Xe máy'},
  {id: 4, word: 'Ship', mean: 'Con thuyền'},
  {id: 5, word: 'School', mean: 'Trường học'},
  {id: 6, word: 'Class', mean: 'Lớp học'},
  {id: 7, word: 'Stadium', mean: 'Sân vận động'},
  {id: 8, word: 'Park', mean: 'Công viên'}
  ]
  constructor() { }
  getAll(){
  return this.dictionaries;
  }
  findFindById(id: number){
    return this.dictionaries.find(item => item.id === id);
  }
}
