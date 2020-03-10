
package Modelo;

import java.util.List;


public interface CRUD {
    public String insertar(Object obj);
    public String eliminar(Object obj);
    public String actualizar(Object obj);
    public List<?> consultar();
    public List<?> filtrar(String campo, String criterio);
}
