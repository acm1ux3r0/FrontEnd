import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Experiencia } from '../model/experiencia';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SExperienciaService {
  /* La siguiente expURL viene del CONTROLLER "CExperiencia.java" del BACKEND "4200":
        @RequestMapping("explab")
        //@CrossOrigin(origins = "http://localhost:4200")
        @CrossOrigin(origins = "*")*/
  //expURL: 'http://localhost:8080/explab/';
  URL = environment.URL + 'explab/'; 

  constructor(private httpClient:  HttpClient) {}

    public lista(): Observable<Experiencia[]>{
      return this.httpClient.get<Experiencia[]>(this.URL + 'lista');
    }

    public detail(id: number): Observable<Experiencia>{
      return this.httpClient.get<Experiencia>(this.URL + `detail/${id}`);   
                                                              /* Van comillas de tipo ( `` )  porque le vamos a pasar un valor por el @PathVariable */
    }

    //Método para guardar.

    public save(experiencia: Experiencia): Observable<any>{
      return this.httpClient.post<any>(this.URL + 'create', experiencia); 
    }

    public update(id: number, experiencia: Experiencia): Observable<any>{
      return this.httpClient.put<any>(this.URL + `update/${id}`, experiencia);
    }

    public delete(id: number): Observable<any>{ 
      return this.httpClient.delete<any>(this.URL + `delete/${id}`)
    }

}
