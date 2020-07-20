import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


export interface IIngredient {
  id: string;
  name: string;
  type: string;
}

export interface ITaco {
  id: number;
  createdAt: Date;
  name: string;
  ingredients: Array<IIngredient>;
}

@Injectable()
export class RecentTacosService {

  recentTacos: Array<ITaco>;

  constructor(private httpClient: HttpClient) {  }
  
  getRecentTacos() {
    return this.httpClient.get<Array<ITaco>>('http://localhost:8080/design/recent');
  }
}
