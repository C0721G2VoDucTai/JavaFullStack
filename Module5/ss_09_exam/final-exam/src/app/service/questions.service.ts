import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Questions} from '../model/questions';
import {Observable} from 'rxjs';
import {QuestionType} from '../model/question-type';

@Injectable({
  providedIn: 'root'
})
export class QuestionsService {

  private API_URL = ' http://localhost:3000/questions';
  private API_URL_TYPE = ' http://localhost:3000/question_type';

  constructor(
    private httpClient: HttpClient) {
  }
  getAllQuestionType(): Observable<QuestionType[]> {
    return this.httpClient.get<QuestionType[]>(this.API_URL_TYPE);
  }

  getAll(): Observable<Questions[]> {
    return this.httpClient.get<Questions[]>(this.API_URL);
  }

  // set customers(value: Customer[]) {
  //   this.customers = value;
  // }
  findById(id: number): Observable<Questions>{
    return this.httpClient.get<Questions>(this.API_URL + '/' + id);
  }
  searchNameAddress(name, customerType): Observable<Questions[]>{
    return this.httpClient.get<Questions[]>(this.API_URL + '?title_like=' + name + '&question_type.id=' + customerType);
  }
  searchName(name): Observable<Questions[]>{
    return this.httpClient.get<Questions[]>(this.API_URL + '?title_like=' + name);
  }
  searchAddress(customerType): Observable<Questions[]>{
    return this.httpClient.get<Questions[]>(this.API_URL + '?question_type.id=' + customerType);
  }

  saveQ(questions: Questions): Observable<Questions> {
    return this.httpClient.post<Questions>(this.API_URL, questions);
  }
  updateQ(id: number, customer: Questions): Observable<Questions> {
    return this.httpClient.put<Questions>(this.API_URL + '/' + id, customer);
  }
  deleteQ(id: number): Observable<Questions> {
    return this.httpClient.delete<Questions>(this.API_URL + '/' + id);
  }

}
