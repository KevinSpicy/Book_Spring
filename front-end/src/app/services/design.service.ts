import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class DesignService {

  constructor(private httpClient: HttpClient) {}

  getIngredients() {
    return this.httpClient.get<Array<string>>('http://localhost:8080/ingredients');
  }

  postTaco(taco: any) {
    this.httpClient.post('http://localhost:8080/design', taco, {
      headers: new HttpHeaders().set('Content-type', 'application/json'),
    }).subscribe();
  }
}
