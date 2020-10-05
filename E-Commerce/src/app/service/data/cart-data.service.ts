import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cart } from 'src/app/cart/cart.component';

@Injectable({
  providedIn: 'root'
})
export class CartDataService {

  constructor(private http: HttpClient) { }

  executeViewCart(viewCart) {
    return this.http.post<Cart[]>(`http://localhost:8080/E-Commerce/viewCart`, viewCart);
  }
}
