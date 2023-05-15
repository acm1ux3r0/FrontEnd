import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Educacion } from '../model/educacion';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EducacionService {
  URL = 'http://localhost:8080/educacion/'; 
                                              /*Tomamos esta URL comprobando el @RequestMapping("/  educacion") del CONTROLLER CEducacion.java */
  //URL = '/educacion/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Educacion[]> {
    return this.httpClient.get<Educacion[]>(this.URL + 'lista');
                                                                //Para traer una lista de toda la educación que tengamos.
  }

  public detail(id: number): Observable<Educacion>{
    return this.httpClient.get<Educacion>(this.URL + `detail/${id}`);
                                                                    //Se usan las comillas `` porque vamos a mandar por parámetro un ID.
  }

  public save(educacion: Educacion): Observable<any>{
    return this.httpClient.post<any>(this.URL + 'create', educacion);
  }

  public update(id: number, educacion: Educacion): Observable<any>{
    return this.httpClient.put<any>(this.URL + `update/${id}`, educacion);
                                                                      //Se usan las comillas `` porque vamos a mandar por parámetro un ID.
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.URL + `delete/${id}`);
                                                                    //Se usan las comillas `` porque vamos a mandar por parámetro un ID.
  }
}
