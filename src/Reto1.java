import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Reto1 {

    public static int identificador;
    public static String id;
    public static int opcion;
    public static ArrayList<Empleados> empleados = new ArrayList<>();
    public static ArrayList<Departamentos> departamentos = new ArrayList<>();

    public static Scanner inputValue = new Scanner(System.in);
    public static File miFichero;


    public static void leerEmpleados() throws IOException {
        miFichero = new File("./src/Empleados.csv");
        if (!miFichero.exists()) {
            System.out.println("El fichero no existe");
        }
        BufferedReader flujoEntrada = new BufferedReader(new FileReader(miFichero));
        String linea = flujoEntrada.readLine();
        while (linea != null) { // Va leyendo lineas y mientras no llegue al final nos va mostrando su contenido
            System.out.println(linea);
            String[] empleadoArray = linea.split(";");
            empleados.add(new Empleados(empleadoArray[0], empleadoArray[1], empleadoArray[2], empleadoArray[3], empleadoArray[4], empleadoArray[5], empleadoArray[6], empleadoArray[7], Integer.parseInt(empleadoArray[8]), empleadoArray[9], Integer.parseInt(empleadoArray[10])));
            linea = flujoEntrada.readLine();
        }
    }

    public static void leerDepartamentos() throws IOException {

        miFichero = new File("./src/Departamentos.csv");
        if (!miFichero.exists()) {
            System.out.println("El fichero no existe");
        }
        BufferedReader flujoEntrada = new BufferedReader(new FileReader(miFichero));
        String linea = flujoEntrada.readLine();
        while (linea != null) { // Va leyendo lineas y mientras no llegue al final nos va mostrando su contenido
            System.out.println(linea);
            String[] departamentoArray = linea.split(";");
            departamentos.add(new Departamentos(departamentoArray[0], departamentoArray[1]));
            linea = flujoEntrada.readLine();
        }
    }




    public static void consultarEmpleado() throws IOException {

        System.out.println("Introduce el ID del empleado");
        id = inputValue.next();

        for (Empleados empleados1 : empleados) {

            if (empleados1.getNIF().equals(id)) {

                System.out.println(empleados1.getNombre() + empleados1.getApellido1());

            }
        }

    }

    public static void consultarEmpleadosDepartamentos() throws IOException {

        System.out.println("Introduce el ID del departamento");
        identificador = inputValue.nextInt();
        System.out.println();

        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-10s%-28s%-15s%-15s\n",
                "NIF",
                "Nombre",
                "Apellido1",
                "Apellido2",
                "Cuenta",
                "Antigüedad",
                "N. SS",
                "Categoria G.Profesional",
                "G.Cotización",
                "Id Departamento");
        System.out.println();
        for (Empleados empleados1 : empleados) {

            if (empleados1.getIdDep() == identificador) {

                System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-19s%-24s%-17s%-15s\n",
                        empleados1.getNIF(),
                        empleados1.getNombre(),
                        empleados1.getApellido1(),
                        empleados1.getApellido2(),
                        empleados1.getCuenta(),
                        empleados1.getAntiguedad(),
                        empleados1.getNASeguridadSocial(),
                        empleados1.getCatGProfesional(),
                        empleados1.getGCotizacion(),
                        empleados1.getIdDep());

            }
        }
        System.out.println();
    }

    public static void Menu() {

        System.out.println("Bienvenido al menu para la gestion de empleados");
        System.out.println("Opciones: ");
        System.out.println("1.Introducir el archivo csv a editar ");
        System.out.println("2.Exportar archivo editado ");
        System.out.println("3.Consultar datos empleado");
        System.out.println("4.Consultar trabajadores por grupo cotizacion ");
        System.out.println("5.Consultar trabajadores por departamento ");
        System.out.println("6.Consultar coste salarial de la empresa");
        System.out.println("7.Consultar coste salarial por categoria trabajador ");
        System.out.println("8.Consultar cantidad de horas extras por departamento ");
        System.out.println("9.Consultar coste salarial de un departamento");
        System.out.println("10.Incorporar nuevo trabajador ");
        System.out.println("11.Incorporar nueva categoria ");
        System.out.println("12.Modificar datos personales ");
        System.out.println("13.Modificar datos de la empresa de trabajadores exsitentes ");
        System.out.println("14.Eliminar datos personales ");
        System.out.println("15.Eliminar datos categoria ");
        System.out.println("16.Salir");
        System.out.println();
        System.out.println("Introduce una opcion");
        opcion = inputValue.nextInt();
        System.out.println();


    }


    public static void main(String[] args)  throws IOException {

        boolean programa=false;

        do{
            Menu();
            switch (opcion){
                case 1:
                    leerEmpleados();
                    break;
                case 2:
                    leerDepartamentos();
                    break;

                case 3:
                    leerEmpleados();
                    consultarEmpleado();
                    break;
                case 4:

                case 5:
                    leerEmpleados();
                    consultarEmpleadosDepartamentos();
                case 6:

                case 7:

                case 8:

                case 9:

                case 10:

                case 11:

                case 12:

                case 13:

                case 14:

                case 15:

                case 16:
                    System.out.println("Gracias por utilizar nuestro programa siuuuuu");
                    programa=false;
                    break;

            }
        }while(programa);



    }
}
