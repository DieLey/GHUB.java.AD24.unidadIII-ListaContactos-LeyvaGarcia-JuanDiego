package miPrincipal;
import lista.Lista;
import lista.PosicionIlegalException;

public class ListaDeContactos {
    private Lista<Contacto> contactos;

    public ListaDeContactos() {
        contactos = new Lista<Contacto>();
    }

    /*
     * Agrega un nuevo contacto a la lista, si todavia noy hay ningun
     * contacto con los nombre y apellidos dados y retorno true
     * si ya existe un contacto con el nombre y apellido dado retorna
     * un false
     * @trows PosicionIlegalException
     */

    public boolean agregarContactos(String nombres, String apellidos, 
                                    String direccion, String correo, 
                                     String telefono, String celular) throws PosicionIlegalException{
                Contacto con = buscarContactos(nombres, apellidos);
                if (con==null){
                    Contacto nuevo = new Contacto(nombres, apellidos, direccion, correo, telefono, celular);
                    contactos.agregar(nuevo);
                    return true;
                }else{
                    return false;
                }

    }

    /**
     * Elimina un contacto dados sus nombres y apellidos
     * si el contacto existe en la lista se elimina y
     * @return true, en caso contrario retorna false
     * @throws PosicionIlegalException
     * 
     */
    public boolean eliminarContactos(String nombres, String apellidos) throws PosicionIlegalException{
        Contacto con = buscarContactos(nombres, apellidos);
        if (con !=null){
            for(int i=0;i<contactos.getTamanio();i++){
                Contacto conAux = contactos.getValor(i);
                if (nombres.equals(conAux.getNombres()) && apellidos.equals(conAux.getApellidos())){
                    contactos.remover(i);
                }

            }
            return true;
        }
        return false;

    }
    /**
     * busca un contacto dado su nombre y apellido
     * @return el contacto si se encuentra y null en caso contratrrio
     * @throws PosicionIlegalException
     */
    public Contacto buscarContactos(String nombres, String apellidos) throws PosicionIlegalException{
        for(int i=0;i<contactos.getTamanio();i++){
            Contacto con = contactos.getValor(i);
            if (nombres.equals(con.getNombres()) && apellidos.equals(con.getApellidos())){
                return con;
            }

        }
        return null;


    }
    /**
     * 
     * @return una lista de todos los contactos
     */
    public Lista<Contacto> mostrarTodosLosContactos(){
        return contactos;

    }

    /**
     * Modifica los datos de un contacto dado sus nombre y apellidps
     * Su el contacto existe se modifican sus datos y retorna un true
     * si no existe no se modifican sus datos y retorna un false
     * @return
     * @throws PosicionIlegalException
     */

    public boolean modificarContactos(String nombres, String apellidos,
                                     String direccion, String correo, 
                                     String telefono, String celular) throws PosicionIlegalException{
        Contacto con = buscarContactos(nombres, apellidos);
        if (con !=null){
            //modifica el contacto con los datos nuevos
            con.setNombres(nombres);
            con.setApellidos(apellidos);
            con.setDireccion(direccion);
            con.setTelefono(telefono);
            con.setCelular(celular);
            return true;
        }else{
            return false;
        }

    }
    
    

    
}
