import { CityPatch } from './../../model/city-patch';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { City } from 'src/app/model/city';
import { ConfigService } from './config.service';

@Injectable({
  providedIn: 'root',
})
export class CityService {
  private baseUrl: string = this.configService.getApiUrl();
  constructor(private configService: ConfigService, private http: HttpClient) {}

  getCityList(page: number, size: number): Observable<City[]> {
    return this.http.get<City[]>(
      `${this.baseUrl}/v1/cities/all/${page}/${size}`
    );
  }

  searchByName(name: string): Observable<City[]> {
    return this.http.get<City[]>(`${this.baseUrl}/v1/cities/search/${name}`);
  }

  update(id:number, updated: CityPatch): Observable<City> {
    const url = `${this.baseUrl}/v1/cities/${id}`;
    return this.http.patch<City>(url, updated);
  }
}
