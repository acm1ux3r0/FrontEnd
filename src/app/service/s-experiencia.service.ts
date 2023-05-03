import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Experiencia } from '../model/experiencia';

@Injectable({
  providedIn: 'root'
})
export class SExperienciaService {
  expURL: 'http://localhost:8080/explab/' | undefined

  constructor(private httpClient:  HttpClient) {}

    public lista(): Observable<Experiencia[]>{
      return this.httpClient.get<Experiencia[]>(this.expURL + 'lista');
    }

    public detail(id: number): Observable<Experiencia>{
      return this.httpClient.get<Experiencia>(this.expURL + `detail/${id}`); /* Van comillas de tipo  `` porque le vamos a pasar un valor por el @PathVariable */
    }

    //Método para guardar.

    public save(experiencia: Experiencia): Observable<any>{
      return this.httpClient.post<any>(this.expURL + `create`, experiencia); 
    }

    public update(id: number, experiencia: Experiencia): Observable<any>{
      return this.httpClient.put<any>(this.expURL + `update/${id}`, experiencia);
    }

    public delete(id: number): Observable<any>{
      return this.httpClient.delete<any>(this.expURL + `delete/${id}`)
    }

}