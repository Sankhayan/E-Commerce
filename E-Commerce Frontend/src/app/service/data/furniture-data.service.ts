import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FurnitureDataService {

  constructor(private http: HttpClient) { }

  executeHomeHomeAppliancesFurniture() {
    return this.http.get<any[]>(`http://localhost:8080/E-Commerce/catalog/homeAppliances/furniture`);
  }
  
  executeAddToCart(userCart) {
    return this.http.put(`http://localhost:8080/E-Commerce/saveToCart`, userCart);
  }
}
