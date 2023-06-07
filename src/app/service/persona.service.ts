import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../model/persona.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class PersonaService {
  URL = environment.URL + 'personas/';
  //URL = 'http://localhost:8080/personas/';
    /* Se crea esta variable para poder llamar los diferentes métodos de PersonaController.java:
        - @GetMapping("personas/traer")
        - @PostMapping("/personas/crear")
        - @DeleteMapping("/personas/borrar/{id}/")
        - @PutMapping("/personas/editar/{id}")
        - @GetMapping("/personas/traer/perfil") */

  constructor(private http: HttpClient) { }

  public getPersona(): Observable<persona>{
                      /*Angular usa el "Observable" para hacer las peticiones asíncronas */
    return this.http.get<persona>(this.URL + 'traer/perfil') 
                                           /* del Persona Controller.java: @GetMapping("/personas/traer/perfil") */
  }
}
