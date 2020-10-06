import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class WomenDataService {

  constructor(private http: HttpClient) { }

  executeHomeFashionWomen() {
    return this.http.get<any[]>('http://localhost:8080/E-Commerce/catalog/fashion/women');
  }

  executeAddToCart(userCart) {
    return this.http.put(`http://localhost:8080/E-Commerce/saveToCart`, userCart);
  }
  
}
