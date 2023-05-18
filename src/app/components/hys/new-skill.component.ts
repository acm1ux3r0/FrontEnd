import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { SkillService } from 'src/app/service/skill.service';

@Component({
  selector: 'app-new-skill',
  templateUrl: './new-skill.component.html',
  styleUrls: ['./new-skill.component.css']
})

export class NewSkillComponent implements OnInit {
  nombre: string;
  porcentaje: number;

  constructor(private skillS: SkillService, private router: Router) { }
                      /* "skillS" lleva la S mayúscula al final para indicar el Service. */

  ngOnInit(): void {
  }

  onCreate(): void{
    const skill = new Skill(this.nombre, this.porcentaje);
    this.skillS.save(skill).subscribe( //Lo guardado en la constante lo llevamos como parámetro(skill)
      data => {
        alert("La Skill fue creada correctamente");
        this.router.navigate(['']); //Para que nos lleve nuevamente a la página principal.
      }, err =>{
        alert("Falló al agregar la skill");
        this.router.navigate(['']);//Para que nos lleve nuevamente a la página principal.
      }
    )
  }
}