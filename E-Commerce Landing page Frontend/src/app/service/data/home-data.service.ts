import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HomeDataService {

  constructor(private http: HttpClient) { }

  executeHome() {
    return this.http.get<any[]>('http://localhost:8080/E-Commerce/catalog');
  }

  executeHomeElectronics() {
    return this.http.get<any[]>('http://localhost:8080/E-Commerce/catalog/electronics');
  }

  executeHomeFashion() {
    return this.http.get<any[]>('http://localhost:8080/E-Commerce/catalog/fashion');
  }

  executeHomeHomeAppliances() {
    return this.http.get<any[]>('http://localhost:8080/E-Commerce/catalog/homeAppliances');
  }
}
