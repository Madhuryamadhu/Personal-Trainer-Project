import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { contact } from "./contact.model";
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import { ApiResponse } from "../shared/api.response.model";

@Injectable({
    providedIn: 'root',
  })
export class ContactService{

  constructor(
    private readonly http: HttpClient,
  ) {}

  createContact(createContact: contact): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(
      `${environment.physicalTrainerDatastoreUrl}/contact`,
      createContact,
    );
  }
}
