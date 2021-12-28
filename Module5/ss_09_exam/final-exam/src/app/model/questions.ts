import {QuestionType} from './question-type';

export interface Questions {
  id: number;
  title: string;
  question_type: QuestionType;
  ques: string;
  answer: string;
  date: string;
  status: number;
}

// {
//   "id": 1,
//   "title": "Angular",
//   "question_type": {
//   "id": 1,
//     "name": "Học Tập"
// },
//   "ques": "Angular là gì",
//   "answer": "Là một framework",
//   "date": "2021-12-20",
//   "status": "1"
// },
