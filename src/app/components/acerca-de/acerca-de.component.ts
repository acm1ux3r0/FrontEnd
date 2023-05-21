import { Component, OnInit } from '@angular/core';
import { persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';


@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})

export class AcercaDeComponent implements OnInit {
  persona: persona = new persona("","","");
  //persona: persona = new persona("Antonio", "Lucero", "../../../assets/perfilPhoto.jpg");

  constructor(public personaService: PersonaService){ }

  ngOnInit(): void{
    this.personaService.getPersona().subscribe(
                                    /* El método suscribe está pendiente de los 
                                    eventos del "observable" */
      data => {
        this.persona = data
      }
    );
  }
  
}
