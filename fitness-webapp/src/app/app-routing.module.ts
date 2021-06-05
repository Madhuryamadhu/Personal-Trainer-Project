import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MeetMeComponent } from './meet-me/meet-me.component';
import { SignupComponent } from './signup/signup.component';
import { WhatWeDoComponent } from './what-we-do/what-we-do.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'about', component: AboutComponent },
  { path: 'meetMe', component: MeetMeComponent },
  { path: 'contactUs', component: ContactComponent },
  { path: 'whatWeDo', component: WhatWeDoComponent },
  { path: 'forgotPassword', component: ForgotPasswordComponent },
  {path: '', redirectTo: '/home', pathMatch: 'full'},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }