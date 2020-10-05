import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DecorDataService {

  constructor(private http: HttpClient) { }

  executeHomeHomeAppliancesDecor() {
    return this.http.get<any[]>(`http://localhost:8080/E-Commerce/catalog/homeAppliances/decor`);
  }

  executeAddToCart(userCart) {
    return this.http.put(`http://localhost:8080/E-Commerce/saveToCart`, userCart);
  }

}
