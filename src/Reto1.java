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

            if (empleados1.getNIF().equals(id)) {

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

    public static void consultarEmpleadosCotizacion() throws IOException {

        System.out.println("Introduce grupo de cotización");
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

            if (empleados1.getGCotizacion() == identificador) {

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
        System.out.println("1.Exportar archivo editado ");
        System.out.println("2.Consultar datos empleado por ID");
        System.out.println("3.Consultar trabajadores por grupo cotizacion ");
        System.out.println("4.Consultar trabajadores por nombre departamento");
        System.out.println("5.Consultar trabajadores por ID departamento ");
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

    public static void incorporarEmpleados() throws IOException {
        String antiguedad = "";
        System.out.println("Introduce el NIF del nuevo empleado: ");
        String NIF = inputValue.next();
        System.out.println("Introduce el Nombre del nuevo empleado: ");
        String nombreEmpleado = inputValue.next();
        System.out.println("Introduce el Apellido1 del nuevo empleado: ");
        String apellido1Empleado = inputValue.next();
        System.out.println("Introduce el Apellido2 del nuevo empleado: ");
        String apellido2Empleado = inputValue.next();
        System.out.println("Introduce la cuenta de usuario del nuevo empleado: ");
        String cuentaEmpleado = inputValue.next();
        System.out.println("Introduce el número de seguridad social del nuevo empleado: ");
        String nSS = inputValue.next();
        System.out.println("Introduce la categoría profesional del nuevo empleado: ");
        String catProf = inputValue.next();
        System.out.println("Introduce el grupo de cotización del nuevo empleado: ");
        int GCot = inputValue.nextInt();
        System.out.println("Introduce el email del nuevo empleado: ");
        String email = inputValue.next();
        System.out.println("Introduce el id del departamento del nuevo empleado: ");
        int idDep = inputValue.nextInt();

        Empleados empleados1 = new Empleados(NIF, nombreEmpleado, apellido1Empleado, apellido2Empleado, cuentaEmpleado, antiguedad , nSS, catProf, GCot, email, idDep);
        empleados.add(empleados1);

        miFichero = new File("./src/Empleados.csv");
        if (!miFichero.exists()) {
            System.out.println("El fichero no existe");
        }
        BufferedWriter flujoSalida = new BufferedWriter(new FileWriter(miFichero));
        for (int i = 0; i < empleados.size(); i++){
            flujoSalida.write(empleados.get(i).getNIF());
            flujoSalida.write(";");
            flujoSalida.write(empleados.get(i).getNombre());
            flujoSalida.write(";");
            flujoSalida.write(empleados.get(i).getApellido1());
            flujoSalida.write(";");
            flujoSalida.write(empleados.get(i).getApellido2());
            flujoSalida.write(";");
            flujoSalida.write(empleados.get(i).getCuenta());
            flujoSalida.write(";");
            flujoSalida.write(empleados.get(i).getAntiguedad());
            flujoSalida.write(";");
            flujoSalida.write(empleados.get(i).getNASeguridadSocial());
            flujoSalida.write(";");
            flujoSalida.write(empleados.get(i).getCatGProfesional());
            flujoSalida.write(";");
            flujoSalida.write(empleados.get(i).getGCotizacion()); //Fallan los integer
            flujoSalida.write(";");
            flujoSalida.write(empleados.get(i).getEmail());
            flujoSalida.write(";");
            flujoSalida.write(empleados.get(i).getIdDep()); //Fallan los integer
            flujoSalida.write("\n");
        }
        flujoSalida.close();
    }





    public static void main(String[] args)  throws IOException {

        boolean programa=false;

        do{
            Menu();
            switch (opcion){
                case 1:
                    break;
                case 2:
                    leerEmpleados();
                    consultarEmpleado();
                    break;

                case 3:
                    leerEmpleados();
                    consultarEmpleadosCotizacion();
                    break;
                case 4:
                    leerDepartamentos();
                    leerEmpleados();
                    break;
                case 5:
                    leerEmpleados();
                    consultarEmpleadosDepartamentos();
                    break;
                case 6:

                case 7:

                case 8:

                case 9:

                case 10:
                    leerEmpleados();
                    incorporarEmpleados();
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
