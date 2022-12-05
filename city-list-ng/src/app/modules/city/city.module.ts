import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CityComponent } from './city.component';
import { CityItemComponent } from "./city-item/city-item.component";
import { RouterModule, Routes } from '@angular/router';
import { PageSizeComponent } from 'src/app/core/components/page-size/page-size.component';
import { PageNumberComponent } from 'src/app/core/components/page-number/page-number.component';
import { SearchBarComponent } from 'src/app/core/components/search-bar/search-bar.component';
import { ReactiveFormsModule } from '@angular/forms';


const routes : Routes = [
    {
      path:'',
      component: CityComponent
    }
  ]

@NgModule({
    declarations: [CityComponent, CityItemComponent, SearchBarComponent, PageSizeComponent, PageNumberComponent],
    imports: [
      CommonModule,
      ReactiveFormsModule,
      RouterModule.forChild(routes),
    ]
})
export class CityModule { }
