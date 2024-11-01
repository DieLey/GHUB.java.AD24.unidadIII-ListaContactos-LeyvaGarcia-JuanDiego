package miPrincipal;

import lista.PosicionIlegalException;
import lista.Lista;

public class ClienteMain {
    public static void main(String[] args) {
        ListaDeContactos ldc = new ListaDeContactos();
        try{
            //agregar algunos contactos
            ldc.agregarContactos("Fernando", "Castro", "calle las rosas 200 pte Guasave, Sinaloa", "fernandoc@gmail.com","6687121212" ,"6687511511" );
            ldc.agregarContactos("Lucia", "Mendez", "los abetos 254 col la condesa, mexico df", "luciam@hotmail.com", "015512111231","015523322");
            System.out.println("Mostrar todos los contacto");
            Lista<Contacto> listado = ldc.mostrarTodosLosContactos();
            for(int i=0;i<listado.getTamanio();i++){
                System.out.println(listado.getValor(i));
            }

        }catch(PosicionIlegalException e){
            e.printStackTrace();
        }

        
    }
    
}
