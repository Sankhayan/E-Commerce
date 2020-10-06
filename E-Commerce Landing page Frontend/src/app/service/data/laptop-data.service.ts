import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LaptopDataService {

  constructor(private http: HttpClient) { }

  executeHomeElectronicsLaptop() {
    return this.http.get<any[]>('http://localhost:8080/E-Commerce/catalog/electronics/laptop');
  }

  executeAddToCart(userCart) {
    return this.http.put(`http://localhost:8080/E-Commerce/saveToCart`, userCart);
  }
}
