import { CityPatch } from './../../model/city-patch';
import { Observable } from 'rxjs';
import { CityService } from './../../core/services/city.service';
import { Component, OnInit } from '@angular/core';
import { City } from 'src/app/model/city';

@Component({
  selector: 'city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css'],
})
export class CityComponent implements OnInit {
  cityList$: Observable<City[]> | undefined;
  pageNum: number = 0;
  pageSize: number = 8;
  sizeOptions: number[] = [8, 10, 25, 50];
  //searchKeyword: string = '';

  constructor(private cityService: CityService) { }

  ngOnInit() {
    this.getCityList();
  }

  getCityList() {
    //this.searchKeyword = '';
    this.cityList$ = this.cityService.getCityList(this.pageNum, this.pageSize);
  }

  search(keyword: string) {
    this.cityList$ = this.cityService.searchByName(keyword);
  }

  updateCity(updatedCity: City) {
    const id = Number(updatedCity.id);
    const cityPatch: CityPatch = { name: updatedCity.name, url : updatedCity.url};

    this.cityService.update(id, cityPatch).subscribe(res=> {
      alert("Updated Successfully");
      this.getCityList();
    },
    err=> {
      alert("Updated Failed")
    });
  }

  clearSearch() {
    this.getCityList();
  }
}
