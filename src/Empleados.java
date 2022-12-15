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
    public static Scanner inputValue2 = new Scanner(System.in);
    public static File miFichero;

    public static String respuesta = "";


    public static void leerEmpleados() throws IOException {
        miFichero = new File("./Reto1-Grupo2-master/src/Empleados.csv");
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

        miFichero = new File("./Reto1-Grupo2-master/src/Departamentos.csv");
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

        System.out.println("Introduce el NIF del empleado");
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

        Empleados empleados1 = new Empleados(NIF, nombreEmpleado, apellido1Empleado, apellido2Empleado, cuentaEmpleado, antiguedad, nSS, catProf, GCot, email, idDep);
        empleados.add(empleados1);

        miFichero = new File("./Reto1-Grupo2-master/src/Empleados.csv");
        if (!miFichero.exists()) {
            System.out.println("El fichero no existe");
        }
        BufferedWriter flujoSalida = new BufferedWriter(new FileWriter(miFichero));
        for (int i = 0; i < empleados.size(); i++) {
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


    public static void guardar() throws IOException {
        //Funcion para guardar los datos en el archivo csv

        miFichero = new File("./Reto1-Grupo2-master/src/Empleados.csv");
        if (!miFichero.exists()) {
            System.out.println("El fichero no existe");
        }
        BufferedWriter flujoSalida = new BufferedWriter(new FileWriter(miFichero));
        for (int i = 0; i < empleados.size(); i++) {
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
            flujoSalida.write(empleados.get(i).getGCotizacion());
            flujoSalida.write(";");
            flujoSalida.write(empleados.get(i).getEmail());
            flujoSalida.write(";");
            flujoSalida.write(empleados.get(i).getIdDep());
            flujoSalida.write("\n");
        }
        flujoSalida.close();
    }

    //Consular coste salarial de un departamento
    public static void consultarCosteSalDep() {

        System.out.println("Introduce el id del departamento: ");
        int idDep = inputValue.nextInt();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getIdDep() == idDep) {
                System.out.println("El coste salarial del departamento " + idDep + " es de " + empleados.get(i).getGCotizacion());
            }
        }
    }

    //Consular coste salarial por categoría profesional
    public static void consultarCosteSalCat() {

        System.out.println("Introduce la categoría profesional: ");
        String catProf = inputValue.next();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getCatGProfesional() == catProf) {
                System.out.println("El coste salarial de la categoría " + catProf + " es de " + empleados.get(i).getGCotizacion());
            }
        }
    }

    public static void modificarDatos() {
        System.out.println("Introduce el NIF del empleado a modificar");
        id = inputValue.next();

        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-10s%-28s%-15s%-25s%-15s\n",
                "NIF",
                "Nombre",
                "Apellido1",
                "Apellido2",
                "Cuenta",
                "Antigüedad",
                "N. SS",
                "Categoria G.Profesional",
                "G.Cotización",
                "Email",
                "Id Departamento");
        System.out.println();
        int i = -1;
        for (Empleados empleados1 : empleados) {
            i++;
            if (empleados1.getNIF().equals(id)) {

                System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-19s%-24s%-17s%-25s%-15s\n",
                        empleados1.getNIF(),
                        empleados1.getNombre(),
                        empleados1.getApellido1(),
                        empleados1.getApellido2(),
                        empleados1.getCuenta(),
                        empleados1.getAntiguedad(),
                        empleados1.getNASeguridadSocial(),
                        empleados1.getCatGProfesional(),
                        empleados1.getGCotizacion(),
                        empleados1.getEmail(),
                        empleados1.getIdDep());

                System.out.println("Que datos deseas modificar?");
                System.out.println("1.- NIF");
                System.out.println("2.- Nombre");
                System.out.println("3.- Apellido1");
                System.out.println("4.- Apellido2");
                System.out.println("5.- Cuenta");
                System.out.println("6.- Antigüedad");
                System.out.println("7.- N. SS");
                System.out.println("8.- Categoría profesional");
                System.out.println("9.- Grupo Cotización");
                System.out.println("10.- Email");
                System.out.println("11.- Id del departamento");
                identificador = inputValue.nextInt();

                switch (identificador) {
                    case 1:
                        System.out.println("Introduce el nuevo NIF del empleado: ");
                        String NIF = inputValue.next();
                        empleados1 = new Empleados(NIF, empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                                empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(),
                                empleados1.getIdDep());
                        empleados.set(i, empleados1);
                        break;
                    case 2:
                        System.out.println("Introduce el nuevo nombre del empleado: ");
                        String nombre = inputValue.next();
                        empleados1 = new Empleados(empleados1.getNIF(), nombre, empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                                empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(),
                                empleados1.getIdDep());
                        empleados.set(i, empleados1);
                        break;
                    case 3:
                        System.out.println("Introduce el nuevo apellido1 del empleado: ");
                        String apellido1 = inputValue.next();
                        empleados1 = new Empleados(empleados1.getApellido1(), empleados1.getNombre(), apellido1, empleados1.getApellido2(), empleados1.getCuenta(),
                                empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(),
                                empleados1.getIdDep());
                        empleados.set(i, empleados1);
                        break;
                    case 4:
                        System.out.println("Introduce el nuevo apellido2 del empleado: ");
                        String apellido2 = inputValue.next();
                        empleados1 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), apellido2, empleados1.getCuenta(),
                                empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(),
                                empleados1.getIdDep());
                        empleados.set(i, empleados1);
                        break;
                    case 5:
                        System.out.println("Introduce la nueva cuenta del empleado: ");
                        String cuenta = inputValue.next();
                        empleados1 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(), cuenta,
                                empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(),
                                empleados1.getIdDep());
                        empleados.set(i, empleados1);
                        break;
                    case 6:
                        System.out.println("Introduce la anitgüedad del empleado: ");
                        String antiguedad = inputValue.next();
                        empleados1 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                                antiguedad, empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(),
                                empleados1.getIdDep());
                        empleados.set(i, empleados1);
                        break;
                    case 7:
                        System.out.println("Introduce el nuevo n. SS del empleado: ");
                        String nSS = inputValue.next();
                        empleados1 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                                empleados1.getAntiguedad(), nSS, empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(),
                                empleados1.getIdDep());
                        empleados.set(i, empleados1);
                        break;
                    case 8:
                        System.out.println("Introduce la nueva categoría progesional del empleado: ");
                        String catPro = inputValue.next();
                        empleados1 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                                empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), catPro, empleados1.getGCotizacion(), empleados1.getEmail(),
                                empleados1.getIdDep());
                        empleados.set(i, empleados1);
                        break;
                    case 9:
                        System.out.println("Introduce el nuevo grupo de cotización del empleado: ");
                        int gCot = inputValue.nextInt();
                        empleados1 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                                empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), gCot, empleados1.getEmail(),
                                empleados1.getIdDep());
                        empleados.set(i, empleados1);
                        break;
                    case 10:
                        System.out.println("Introduce el nuevo email del empleado: ");
                        String email = inputValue.next();
                        empleados1 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                                empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), email,
                                empleados1.getIdDep());
                        empleados.set(i, empleados1);
                        break;
                    case 11:
                        System.out.println("Introduce el nuevo id del departamento del empleado: ");
                        int idDep = inputValue.nextInt();
                        empleados1 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                                empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(),
                                idDep);
                        empleados.set(i, empleados1);
                        break;
                }
            }
        }
    }



     public  static  void eliminarDatosPersona() {

        System.out.println("Introduce el NIF del empleado del cual quieres borrar datos: ");
        String NIF = inputValue.next();

        System.out.println("Que datos deseas borrar?");
        System.out.println("1.- NIF");
        System.out.println("2.- Nombre");
        System.out.println("3.- Primer Apellido");
        System.out.println("4.- Segundo Apellido");
        System.out.println("5.- Cuenta");
        System.out.println("6.- Antigüedad");
        System.out.println("7.- N. SS");
        System.out.println("8.- Grupo Cotización");
        System.out.println("9.- Email");
        System.out.println("10.- Id del departamento");
        System.out.println("11.- Categoría profesional");
        identificador = inputValue.nextInt();

        int i =-1;

        for (Empleados empleados1 : empleados) {
            i++;
            if (empleados1.getNIF().equals(NIF)) {
        switch (identificador) {
            case 1:
                System.out.println("El nif actual del empleado es : " + empleados.get(i).getNIF());
                System.out.println("¿ Seguro que quieres eliminarlo ? : ");
                respuesta = inputValue2.next();
                if (respuesta.equals("si")) {
                    empleados1 = new Empleados("", empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                            empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(),
                            empleados1.getIdDep());
                    empleados.set(i, empleados1);
                } else {
                    System.out.println("No se ha eliminado el NIF");
                }
                break;

            case 2:
                System.out.println("El nombre actual del empleado es : " + empleados.get(i).getNombre());
                System.out.println("¿ Seguro que quieres eliminarlo ? : ");

                respuesta = inputValue2.next();
                if (respuesta.equals("si")) {
                    empleados1 = new Empleados(empleados1.getNIF(), "", empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                            empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(),
                            empleados1.getIdDep());
                    empleados.set(i, empleados1);
                } else {
                    System.out.println("No se ha eliminado el nombre");
                }
                break;

            case 3:
                System.out.println("El apellido1 actual del empleado es : " + empleados.get(i).getApellido1());
                System.out.println("¿ Seguro que quieres eliminarlo ? : ");

                respuesta = inputValue2.next();
                if (respuesta.equals("si")) {
                    empleados1 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), "", empleados1.getApellido2(), empleados1.getCuenta(),
                            empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(),
                            empleados1.getIdDep());
                    empleados.set(i, empleados1);
                } else {
                    System.out.println("No se ha eliminado el apellido1");
                }
                break;

            case 4:
                System.out.println("El apellido2 actual del empleado es : " + empleados.get(i).getApellido2());
                System.out.println("¿ Seguro que quieres eliminarlo ? : ");

                respuesta = inputValue2.next();
                if (respuesta.equals("si")) {
                    empleados1 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), "",empleados1.getCuenta(),
                            empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(),
                            empleados1.getIdDep());
                    empleados.set(i, empleados1);
                } else {
                    System.out.println("No se ha eliminado el apellido2");
                }
                break;

            case 5:
                System.out.println("La cuenta actual del empleado es : " + empleados.get(i).getCuenta());
                System.out.println("¿ Seguro que quieres eliminarlo ? : ");

                respuesta = inputValue2.next();
                if (respuesta.equals("si")) {
                    empleados1 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(),"",
                            empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(),
                            empleados1.getIdDep());
                    empleados.set(i, empleados1);
                } else {
                    System.out.println("No se ha eliminado la cuenta");
                }
                break;

            case 6:
                System.out.println("La antigüedad actual del empleado es : " + empleados.get(i).getAntiguedad());
                System.out.println("¿ Seguro que quieres eliminarlo ? : ");

                respuesta = inputValue2.next();
                if (respuesta.equals("si")) {
                    empleados1 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                            "", empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(),
                            empleados1.getIdDep());
                    empleados.set(i, empleados1);
                } else {
                    System.out.println("No se ha eliminado la antigüedad");
                }
                break;
            case 7:
                System.out.println("El n. SS actual del empleado es : " + empleados.get(i).getNASeguridadSocial());
                System.out.println("¿ Seguro que quieres eliminarlo ? : ");

                respuesta = inputValue2.next();
                if (respuesta.equals("si")) {
                    empleados1 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                            empleados1.getAntiguedad(), "", empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(),
                            empleados1.getIdDep());
                    empleados.set(i, empleados1);
                } else {
                    System.out.println("No se ha eliminado el n. SS");
                }
                break;
            case 8:
                System.out.println("El grupo de cotización actual del empleado es : " + empleados.get(i).getGCotizacion());
                System.out.println("¿ Seguro que quieres eliminarlo ? : ");

                respuesta = inputValue2.next();
                if (respuesta.equals("si")) {
                    empleados1 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                            empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), 0, empleados1.getEmail(),
                            empleados1.getIdDep());
                    empleados.set(i, empleados1);;
                } else {
                    System.out.println("No se ha eliminado el grupo de cotización");
                }
                break;
            case 9:
                System.out.println("El email actual del empleado es : " + empleados.get(i).getEmail());
                System.out.println("¿ Seguro que quieres eliminarlo ? : ");

                respuesta = inputValue2.next();
                if (respuesta.equals("si")) {
                        empleados1 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                                empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), "",
                                empleados1.getIdDep());
                        empleados.set(i, empleados1);
                } else {
                    System.out.println("No se ha eliminado el email");
                }
                break;
            case 10:
                System.out.println("El id del departamento actual del empleado es : " + empleados.get(i).getIdDep());
                System.out.println("¿ Seguro que quieres eliminarlo ? : ");

                respuesta = inputValue2.next();
                if (respuesta.equals("si")) {
                        empleados1 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                                empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(),
                                0);
                        empleados.set(i, empleados1);

                } else {
                    System.out.println("No se ha eliminado el id del departamento");
                }
                break;
              case 11:
                System.out.println("La categoria profesional actual del empleado es : " + empleados.get(i).getCatGProfesional());
                System.out.println("¿ Seguro que quieres eliminarlo ? : ");

                respuesta = inputValue2.next();
                if (respuesta.equals("si")) {
                        empleados1 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                                empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), "", empleados1.getGCotizacion(), empleados1.getEmail(),
                                empleados1.getIdDep());
                        empleados.set(i, empleados1);

                } else {
                    System.out.println("No se ha eliminado el id del departamento");
                }
                break;
        }

    }

        }
    }

    public static void eliminarEmpleado() throws IOException {

        System.out.println("Introduce el NIF del empleado a eliminar: ");
        String NIF = inputValue.next();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNIF() == NIF) {
                empleados.remove(i);
            }
        }
        guardar();
    }

    public  static  void modificarEmpleado() throws IOException {

        System.out.println("Introduce el NIF del empleado a modificar: ");
        String NIF = inputValue.next();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNIF() == NIF) {
                System.out.println("El nombre actual del empleado es : " + empleados.get(i).getNombre());
                System.out.println("Introduce el nuevo nombre del empleado: ");
                String nombreEmpleado = inputValue.next();
                System.out.println("El primer apellido actual del empleado es : " + empleados.get(i).getApellido1());
                System.out.println("Introduce el nuevo primer apellido del empleado: ");
                String apellido1Empleado = inputValue.next();
                System.out.println("El segundo apellido actual del empleado es : " + empleados.get(i).getApellido2());
                System.out.println("Introduce el segundo apellido del empleado: ");
                String apellido2Empleado = inputValue.next();
                System.out.println("La cuenta actual del empleado es : " + empleados.get(i).getCuenta());
                System.out.println("Introduce el número de cuenta del empleado: ");
                String cuentaEmpleado = inputValue.next();
                System.out.println("La antigüedad actual del empleado es : " + empleados.get(i).getAntiguedad());
                System.out.println("Introduce la antigüedad del empleado: ");
                String antiguedad = inputValue.next();
                System.out.println("El número de la seguridad social actual del empleado es : " + empleados.get(i).getNASeguridadSocial());
                System.out.println("Introduce el número de la seguridad social del empleado: ");
                String nSS = inputValue.next();
                System.out.println("La categoría profesional actual del empleado es : " + empleados.get(i).getCatGProfesional());
                System.out.println("Introduce la categoría profesional del empleado: ");
                String catProf = inputValue.next();
                System.out.println("El coste salarial actual del empleado es : " + empleados.get(i).getGCotizacion());
                System.out.println("Introduce el grupo de cotización del empleado: ");
                int GCot = inputValue.nextInt();
                System.out.println("El email actual del empleado es : " + empleados.get(i).getEmail());
                System.out.println("Introduce el email del empleado: ");
                String email = inputValue.next();
                System.out.println("El id del departamento actual del empleado es : " + empleados.get(i).getIdDep());
                System.out.println("Introduce el id del departamento del empleado: ");
                int idDep = inputValue.nextInt();
                empleados.remove(i);

                Empleados empleado1 = new Empleados(NIF, nombreEmpleado, apellido1Empleado, apellido2Empleado, cuentaEmpleado, antiguedad, nSS, catProf, GCot, email, idDep);
            }


        }
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
                    leerEmpleados();
                    consultarEmpleadosCotizacion();
                    break;
                case 5:
                    leerEmpleados();
                    consultarEmpleadosDepartamentos();
                    break;
                case 6:
                    leerEmpleados();
                    leerDepartamentos();
                    consultarCosteSalDep();
                    break;

                case 7:

                case 8:

                case 9:

                case 10:
                    leerEmpleados();
                    incorporarEmpleados();
                case 11:

                case 12:
                    leerEmpleados();
                    modificarDatos();
                    guardar();
                case 13:
                    leerEmpleados();
                    eliminarDatosPersona();
                    guardar();

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
