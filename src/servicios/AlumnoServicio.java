/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Alumno;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
promedio final, devuelto por el método y mostrado en el main.
 *
 *
 */
public class AlumnoServicio {
    Scanner leer =new Scanner (System.in).useDelimiter("\n");
   public void cargarAlumno(ArrayList<Alumno> alumnos){
         Alumno alumno=new Alumno();
         String respuesta;
       do{
         
           System.out.println("Ingrese el nombre del alumno ");
           alumno.setNombre(leer.next());
           System.out.println("Ingrese las notas 3 notas del alumno");
           ArrayList<Integer>notas=new ArrayList();
           for (int i = 0; i < 3; i++) {
               notas.add(leer.nextInt());
               
           }
           alumno.setNotas(notas);
           alumnos.add(alumno);
           System.out.println("Desea cargar otro alumno?S/N");
          respuesta =leer.next();
       }while(!respuesta.equalsIgnoreCase("N"));
       
   }
   public  Double notaFinal(ArrayList<Alumno> alumnos){
       System.out.println("Ingrese el nombre del alumno que desea calcular su nota");
  String nombreAlumno=leer.next();
  double sumaNotas=0;
  
  Iterator<Alumno>iterator=alumnos.iterator();
  while(iterator.hasNext()){
      //hasnext lo que hace es recorrer la lista y buiscar la concidencia 
      Alumno alumnoAuxiliar=iterator.next();
      if(alumnoAuxiliar.getNombre().equalsIgnoreCase(nombreAlumno)){
         for(Integer notas: alumnoAuxiliar.getNotas())
             sumaNotas +=notas;
      }
     return sumaNotas/alumnoAuxiliar.getNotas().size(); 
  }
 return null;
   } 

}