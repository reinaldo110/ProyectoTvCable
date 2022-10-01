package proyectotvcable;

import java.io.*;

public class ProyectoTvCable
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        PlanEmpresa a = new PlanTelefonia((byte) 1, "a", 1, 1, false, 1);
        System.out.println(a.getClass().getSimpleName().toString());
        MapaEmpresas mapa = new MapaEmpresas();
        mapa.lecturaArchivo();
        menuInicial(mapa);
        mapa.exportarArchivo();
    }

    public static void menuInicial(MapaEmpresas mapa) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println("1.Empresas");
            System.out.println("2.Salir");
            opcion = Integer.parseInt(lector.readLine());
            switch (opcion) {
                case 1 -> {
                    mapa.listarEmpresas();
                    System.out.println("Ingrese el nombre de la empresa a la que quiere acceder");
                    String nombre = lector.readLine();
                    Empresa emp = mapa.getMapa().get(nombre);
                    try{
                        emp.menuEmpresa(lector);
                    }catch (NullPointerException e){
                        System.out.println("Nombre no encontrado.");
                    }
                }
                case 2 -> salir = true;
                default -> System.out.println("Numero fuera de rango, intente de nuevo.");
            }
        }
    }
}