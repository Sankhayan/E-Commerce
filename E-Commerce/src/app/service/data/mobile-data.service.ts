import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MobileDataService {

  constructor(private http: HttpClient) { }

  executeHomeElectronicsMobile() {
    return this.http.get<any[]>('http://localhost:8080/E-Commerce/catalog/electronics/mobile');
  }

  executeAddToCart(userCart) {
    return this.http.put(`http://localhost:8080/E-Commerce/saveToCart`, userCart);
  }
  
}
