import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class UpdateUserImageService {

  private http = inject(HttpClient)

  uploadImage(imageData: FormData, userId: number) {
    const url = `${ environment.apiUrl }/usuario/upload/image/${ userId }`
    return this.http.post(url, imageData)
  }
  
}
