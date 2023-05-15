export class Educacion {
    //Ponemos o seguimos el modelo que tenemos en el Entity de JAVA.
    id: number; //En caso de que no tome el ID y lo marque con rojo, se debe colocar el signo ? al final.
    nombreE: string;
    descripcionE: string;

    constructor(nombreE: string, descripcionE: string){
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
}
