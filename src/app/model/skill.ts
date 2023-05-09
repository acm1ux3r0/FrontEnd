export class Skill {
    id: number;
    nombre: string;
    porcentaje: number;
    color: string;
    img: string;

    constructor(nombre:string, porcentaje: number, color: string, img: string){
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.color = color;
        this.img = img;
    }
}
