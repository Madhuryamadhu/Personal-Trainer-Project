import { Component, OnInit } from '@angular/core';
import { contact } from './contact.model';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  contact ={} as contact;
  constructor() { }

  ngOnInit(): void {
  }

  addContact():void{
    alert("Contact sent successfullly");
  }
}
