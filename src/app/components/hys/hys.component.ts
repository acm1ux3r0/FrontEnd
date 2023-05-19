import { Component } from '@angular/core';

import { Skill } from 'src/app/model/skill';
import { SkillService } from 'src/app/service/skill.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-hys',
  templateUrl: './hys.component.html',
  styleUrls: ['./hys.component.css']
})

export class HysComponent {
  skill: Skill[] = [
    /*new Skill('HTML', 70, '#FB8C00', "../assets/html.png"),
    new Skill('CSS', 60, '#03A9F4', "../assets/CSS.png"),
    new Skill('JS', 70, '#D4AC0D', "../assets/js.png"),
    new Skill('GIT', 80, '#424242', "../assets/git.png"),
    new Skill('Ingles', 70, '#21618C', "../assets/ingles.png"),
    new Skill('Grupo', 100, '#EF5350', "../assets/grupo3.png")*/
  ];

  constructor(private skillS: SkillService, private tokenService: TokenService) { }
                                                    /*  TokenService es para validar si estoy o no       logueado */
  isLogged = false;
  
  /* ngOnInit es lo que se va a cargar en cuanto inicie este componente */
  ngOnInit(): void {
    this.cargarSkills(); // Lo primero que haga es que escanee y que cargue.
    //Validación del TOKEN
    if(this.tokenService.getToken()){
      this.isLogged = true;// Si estoy logueado se va a poder EDITAR.
    } else {
      this.isLogged = false;// Si NO estoy logueado no va a mostrar nada.
    }
  }

  cargarSkills(): void{
    this.skillS.lista().subscribe(
      data =>{
        this.skill = data;
            /* Este this.skill se tiene que cargar ni bien inicie el componente: para ello llamamos este método en ngOnInit() mediante el  this.cargarSkills() */
      }
    )
  }

  delete(id: number){
    if(id != undefined){
      this.skillS.delete(id).subscribe(
        data => {
          this.cargarSkills(); //Que vuelva a recargar la lista.
        }, err => {
          alert("No se pudo eliminar la skill");
        }
      )
    }
  }
}
