import { Component, OnInit } from '@angular/core';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacion.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})

export class EducacionComponent implements OnInit {
  educacion: Educacion[] = [];

  constructor(private educacionS: EducacionService, private tokenService: TokenService) { }
    
  isLogged = false;

  ngOnInit(): void {    
    this.cargarEducacion();
    //Validación del TOKEN
    if(this.tokenService.getToken()){
      this.isLogged= true; // Si estoy logueado se va a poder EDITAR.
    } else {
      this.isLogged= false;// Si NO estoy logueado no va a mostrar nada.
    }
  }

  cargarEducacion(): void {
    this.educacionS.lista().subscribe(
      data => {
        this.educacion = data;
          /* Este cargarEducacion() se tiene que cargar en cuanto inicie el componente: para ello llamamos este método en ngOnInit() mediante el  this.cargarEducacion() */
      }
    )
  }

  delete(id?: number) {
    if(id != undefined){
      this.educacionS.delete(id).subscribe(
        data =>{
          this.cargarEducacion(); 
        }, err => {
          alert ("No se pudo eliminar");
        }
      )
    }
  }

}
