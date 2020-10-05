import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MenDataService {

  constructor(private http: HttpClient) { }

  executeHomeFashionMen() {
    return this.http.get<any[]>('http://localhost:8080/E-Commerce/catalog/fashion/men');
  }

  executeAddToCart(userCart) {
    return this.http.put(`http://localhost:8080/E-Commerce/saveToCart`, userCart);
  }

}
