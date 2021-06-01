import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import { MeetMeComponent } from './meet-me/meet-me.component';
import { WhatWeDoComponent } from './what-we-do/what-we-do.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'meetMe', component: MeetMeComponent },
  { path: 'contactUs', component: ContactComponent },
  { path: 'whatWeDo', component: WhatWeDoComponent },
  {path: '', redirectTo: '/home', pathMatch: 'full'},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }