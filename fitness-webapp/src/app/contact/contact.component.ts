import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { ApiResponse } from '../shared/api.response.model';
import { contact } from './contact.model';
import { ContactService } from './contact.service';
import {ToastrService} from 'ngx-toastr';
import {
  ErrorCode,
  getMessage as getErrorMessage,
} from 'src/app/shared/error.codes.enum';
import { getMessage } from '../shared/success.codes.enum';
import { SubSink } from '../sub-sink';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit, OnDestroy {
  contact ={} as contact;
  subs = new SubSink();

  constructor(private contactService : ContactService,
    private toastr: ToastrService,
    private router: Router) { 
    }

  ngOnInit(): void {
    
  }

  addContact():void{
    this.subs.add(this.contactService.createContact(this.contact).
    subscribe((successResponse: ApiResponse) => {
      this.router.navigate(['/home'])
      this.toastr.success(getMessage(successResponse.code));
    }),
    );
  }

  ngOnDestroy(): void {
    this.subs.unsubscribe();
  }
}
