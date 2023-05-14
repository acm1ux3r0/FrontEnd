import { Component, OnInit } from '@angular/core';
import { Experiencia } from 'src/app/model/experiencia';
import { SExperienciaService } from 'src/app/service/s-experiencia.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})

export class ExperienciaComponent implements OnInit {
  expe: Experiencia[] = [];

  constructor(private sExperiencia: SExperienciaService, private tokenService: TokenService) {
    /* Se empieza a validar lo que se pueda hacer según esté o no logueado.*/
  }
  
  isLogged = false;

  ngOnInit(): void {
    this.cargarExperiencia();
    if (this.tokenService.getToken()){ //Con esto verificamos si estamos o no logueados.
      this.isLogged = true;
    }  else {
      this.isLogged = false;
    }
  }

  cargarExperiencia(): void {
    this.sExperiencia.lista().subscribe(
      data => {
        this.expe = data;
      })
  }
  
  delete(id?: number): void {
    if(id != undefined){
      this.sExperiencia.delete(id).subscribe(
        data => {
          this.cargarExperiencia();/* Para que refresque la página después de eliminar */
        }, err => {
          alert("No se pudo eliminar la experiencia");
        }
      )
    }
  }
}
