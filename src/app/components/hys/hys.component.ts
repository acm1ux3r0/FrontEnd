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
    new Skill('HTML', 70, '#FB8C00', "../assets/html.png"),
    new Skill('CSS', 60, '#03A9F4', "../assets/CSS.png"),
    new Skill('JS', 70, '#D4AC0D', "../assets/js.png"),
    new Skill('GIT', 80, '#424242', "../assets/git.png"),
    new Skill('Ingles', 70, '#21618C', "../assets/ingles.png"),
    new Skill('Grupo', 100, '#EF5350', "../assets/grupo3.png")
  ];

  constructor(private skillS: SkillService, private tokenService: TokenService) { }
  isLogged = false;
  
  ngOnInit(): void {
    this.cargarSkills();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarSkills(): void{
    this.skillS.lista().subscribe(
      data => {
        this.skill = data;
      }
    )
  }

  delete(id: number){
    if(id != undefined){
      this.skillS.delete(id).subscribe(
        data => {
          this.cargarSkills();
        }, err => {
          alert("No se pudo borrar la skill");
        }
      )
    }
  }
}
