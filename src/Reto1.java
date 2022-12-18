import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Reto1 {

    /**
     * @author: Grupo 2
     * @collaborator: Carlos Hernandez Garcia
     * @collaborator: Iker Rodrigez Montava
     * @collaborator: Denis Andres Ion Badea
     * Este programa es utilizado para la gestion de usuarios de los departamentos correspondientes a una empresa
     * El programa nos permite :
     * Consultar cualquier dato de un trabajador o departamento.
     * Incorporar nuevos trabajadores y categorias.
     * Eliminar departamento y datos de categorias
     * Modificar Datos Personales
     * Mostrando los resultados a traves de la terminal
     */
    public static final int CERRAR_PROGRAMA = 0;
    public static final int EXPORTAR_CSV = 1;
    public static final int CONSULTAR = 2;
    public static final int INCORPORAR = 3;
    public static final int MODIFICAR_DATOSPERSONALES = 4;
    public static final int ELIMINAR = 5;
    public static String ENTER = "";
    public static final int CONSULTAR_DATOS_EMPLEADO = 1;
    public static final int CONSULTAR_EMPLEADOS_GCOTIZACION = 2;
    public static final int CONSULTAR_EMPLEADOS_DEPARTAMENTO = 3;
    public static final int CONSULTAR_CANTIDADEMPLEADOS_DEPARTAMENTO = 4;
    public static final int CONSULTAR_SALARIO_EMPRESA = 5;
    public static final int CONSULTAR_SALARIO_GCOT = 6;
    public static final int CONSULTAR_HORASEXTRAS_DEPARTAMENTO = 7;
    public static final int CONSULTAR_SALARIO_DEPARTAMENTO = 8;
    public static final int INCORPORAR_NUEVOTRABAJDOR = 1;
    public static final int INCORPORAR_NUEVACATEGORIA = 2;
    public static final int ELIMINAR_DEPARTAMENTOS = 1;
    public static final int ELIMINAR_DATOSCATEGORIA = 2;
    public static int identificador;
    public static String id;
    public static int opcion;
    public static ArrayList<Empleados> empleados = new ArrayList<>();
    public static ArrayList<Empleados> auxE = new ArrayList<>();
    public static ArrayList<Horas> horas = new ArrayList<>();
    public static ArrayList<Salario> salarios = new ArrayList<>();
    public static ArrayList<Categorias> categorias = new ArrayList<>();
    public static int[] cantECod = new int[7];
    public static int[] cantE = new int[29];
    public static int[] cantG = new int[7];
    public static ArrayList<Departamentos> departamentos = new ArrayList<>();
    public static Scanner inputValue = new Scanner(System.in);
    public static File miFichero;
    /**
     * @throws IOException
     * @author: Carlos Hernandez Garcia
     * @collaborator: Denis Andres Ion Badea
     * @collaborator: Iker Rodrigez Montava
     * La funcion llama a las distintas funciones que se encargan de leer los ficheros
     * y de cargar los datos en memoria
     */
    public static void leerArchivos() throws IOException {

        leerEmpleados();
        leerDepartamentos();
        leerCotizacion();
        leerHoras();
        leerCategorias();
    }

    /**
     * @throws IOException
     * @author: Denis Andres Ion Badea
     * La funcion lee el fichero que contiene los datos de los empleados y los carga en memoria
     */
    public static void leerEmpleados() throws IOException {
        miFichero = new File("./src/Empleados.csv");
        if (!miFichero.exists()) {
            System.out.println("El fichero no existe");
        }
        BufferedReader flujoEntrada = new BufferedReader(new FileReader(miFichero));
        String linea = flujoEntrada.readLine();
        while (linea != null) { // Va leyendo lineas y mientras no llegue al final nos va mostrando su contenido
            String[] empleadoArray = linea.split(";");
            empleados.add(new Empleados(empleadoArray[0], empleadoArray[1], empleadoArray[2], empleadoArray[3], empleadoArray[4], empleadoArray[5], empleadoArray[6], empleadoArray[7], Integer.parseInt(empleadoArray[8]), empleadoArray[9], Integer.parseInt(empleadoArray[10])));
            linea = flujoEntrada.readLine();
        }
    }

    /**
     * @throws IOException
     * @author: Carlos Hernandez Garcia
     * La funcion lee el fichero que contiene los datos de los departamentos y los carga en memoria
     */
    public static void leerDepartamentos() throws IOException {

        miFichero = new File("./src/Departamentos.csv");
        if (!miFichero.exists()) {
            System.out.println("El fichero no existe");
        }
        BufferedReader flujoEntrada = new BufferedReader(new FileReader(miFichero));
        String linea = flujoEntrada.readLine();
        while (linea != null) { // Va leyendo lineas y mientras no llegue al final nos va mostrando su contenido
            String[] departamentoArray = linea.split(";");
            departamentos.add(new Departamentos(Integer.parseInt(departamentoArray[0]), departamentoArray[1]));
            linea = flujoEntrada.readLine();
        }
    }

    /**
     * @throws IOException
     * @author: Carlos Hernandez Garcia
     * La funcion lee el fichero que contiene los datos de las categorias y los carga en memoria
     */

    public static void leerCategorias() throws IOException {

        miFichero = new File("./src/CategoriasProfesionales.csv");
        if (!miFichero.exists()) {
            System.out.println("El fichero no existe");
        }
        BufferedReader flujoEntrada = new BufferedReader(new FileReader(miFichero));
        String linea = flujoEntrada.readLine();
        while (linea != null) { // Va leyendo lineas y mientras no llegue al final nos va mostrando su contenido
            String[] categoriaArray = linea.split(";");
            categorias.add(new Categorias(categoriaArray[0]));
            linea = flujoEntrada.readLine();
        }
    }

    /**
     * @throws IOException
     * @author: Iker Rodrigez Montava
     * La Funcion consulta los datos de un empleado a partir del NIF
     */

    public static void consultarEmpleado() throws IOException {

        System.out.println("Introduce el NIF del empleado");
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

    /**
     * @throws IOException
     * @author: Carlos Hernandez Garcia
     * @collaborator: Denis Andres Ion Badea
     * La funcion consulta los empleados de un departamento a partir del id del departamento
     */

    public static void consultarEmpleadosDepartamentos() throws IOException {

        System.out.println("Introduce el ID del departamento");
        identificador = inputValue.nextInt();
        System.out.println();

        System.out.println("Nombre departamento");

        for (Departamentos departamentos1 : departamentos) {
            if (departamentos1.getIdDep() == identificador) {
                System.out.println(departamentos1.getNombreDep());
            }
        }
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

    /**
     * @author: Iker Rodrigez Montava
     * La funcion dice la cantidad de empleados que hay en un departamento
     */

    public static void consultarCantidadEmpleados() {

        System.out.printf("%-15s%-15s\n",
                "Departamento",
                "Cantidad");

        int contador = 0;

        for (Departamentos departamentos1 : departamentos) {

            for (Empleados empleados1 : empleados) {

                int idEmpleado = empleados1.getIdDep();
                int idDepartamento = departamentos1.getIdDep();

                if (idEmpleado == idDepartamento) {
                    contador++;

                }


            }

            System.out.printf("%-15s%-15s\n",
                    departamentos1.getNombreDep(),
                    contador);

            contador = 0;
        }
    }

    /**
     * @author: Iker Rodrigez Montava
     * La funcion cuenta la cantidad de empleados que hay en cada grupo de cotizacion y los guarda en un array
     * Esta funcion es utlizada por otras para completar su funcinamiento
     */

    public static void consultarEmpleadosGrupoCotizacion() {

        int contador = 0;
        int i = -1;

        for (Salario salario1 : salarios) {
            i++;
            for (Empleados empleados1 : empleados) {

                int Gcotizacion = empleados1.getGCotizacion();
                int NGCotizacion = salario1.getGCot();

                if (Gcotizacion == NGCotizacion) {
                    contador++;
                }
                cantECod[i] = contador;
            }
            contador = 0;
        }
    }

    /**
     * @throws IOException
     * @author: Denis Andres Ion Badea
     * La funcion consulta los trabajadores que hay en cada grupo de cotizacion y lo imprime por pantalla
     */

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

    /**
     * @throws IOException
     * @author: Denis Andres Ion Badea
     * @collaborator: Carlos Hernandez Garcia
     * La funcion permite añadir nuevos empleados
     */

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
    }

    /**
     * @throws IOException
     * @author: Carlos Hernandez Garcia
     * La funcion permite guardar los datos de los empleados en un fichero csv
     */

    public static void guardarEmpleados() throws IOException {
        //Funcion para guardar los datos en el archivo csv

        miFichero = new File("./src/Empleados.csv");
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
            flujoSalida.write(String.valueOf(empleados.get(i).getGCotizacion()));
            flujoSalida.write(";");
            flujoSalida.write(empleados.get(i).getEmail());
            flujoSalida.write(";");
            flujoSalida.write(String.valueOf(empleados.get(i).getIdDep()));
            flujoSalida.write("\n");
        }
        flujoSalida.close();
    }

    /**
     * @throws IOException
     * @author: Carlos Hernandez Garcia
     * La funcion permite guardar los datos de los departamentos en un fichero csv
     */

    public static void guardarDepartamentos() throws IOException {
        //Funcion para guardar los datos en el archivo csv

        miFichero = new File("./src/Departamentos.csv");
        if (!miFichero.exists()) {
            System.out.println("El fichero no existe");
        }
        BufferedWriter flujoSalida = new BufferedWriter(new FileWriter(miFichero));
        for (int i = 0; i < departamentos.size(); i++) {
            flujoSalida.write(String.valueOf(departamentos.get(i).getIdDep()));
            flujoSalida.write(";");
            flujoSalida.write(departamentos.get(i).getNombreDep());
            flujoSalida.write("\n");
        }
        flujoSalida.close();
    }

    /**
     * @throws IOException
     * @author: Denis Andres Ion Badea
     * @collaborator: Carlos Hernandez Garcia
     * @collaborator: Iker Rodriguez Montava
     * La funcion permite guardar los datos de los grupos de cotizacion en un fichero csv
     */

    public static void guardarCotizacion() throws IOException {
        //Funcion para guardar los datos en el archivo csv

        miFichero = new File("./src/Cotizacion.csv");
        if (!miFichero.exists()) {
            System.out.println("El fichero no existe");
        }
        BufferedWriter flujoSalida = new BufferedWriter(new FileWriter(miFichero));
        for (int i = 0; i < salarios.size(); i++) {
            flujoSalida.write(String.valueOf(salarios.get(i).getGCot()));
            flujoSalida.write(";");
            flujoSalida.write(String.valueOf(salarios.get(i).getDinero()));
            flujoSalida.write("\n");
        }
        flujoSalida.close();
    }

    /**
     * @throws IOException
     * @author: Denis Andres Ion Badea
     * @collaborator: Carlos Hernandez Garcia
     * @collaborator: Iker Rodriguez Montava
     * La funcion permite guardar las horas extra  en un fichero csv
     */

    public static void guardarHoras() throws IOException {
        //Funcion para guardar los datos en el archivo csv

        miFichero = new File("./src/Horas.csv");
        if (!miFichero.exists()) {
            System.out.println("El fichero no existe");
        }
        BufferedWriter flujoSalida = new BufferedWriter(new FileWriter(miFichero));
        for (int i = 0; i < horas.size(); i++) {
            flujoSalida.write(horas.get(i).getNIF());
            flujoSalida.write(";");
            flujoSalida.write(horas.get(i).getFecha());
            flujoSalida.write(";");
            flujoSalida.write(String.valueOf(horas.get(i).getHoras()));
            flujoSalida.write("\n");
        }
        flujoSalida.close();
    }

    /**
     * @throws IOException
     * @author: Carlos Hernandez Garcia
     * @collaborator: Denis Andres Ion Badea
     * @collaborator: Iker Rodriguez Montava
     * La funcion junta las diferentes funciones que guardan archivos
     */

    public static void guardarTodo() throws IOException {
        guardarEmpleados();
        guardarDepartamentos();
        guardarCotizacion();
        guardarHoras();
        guardarCategorias();
    }

    /**
     * @throws IOException
     * @author: Ikerr Rodriguez Montava
     * @collaborator: Denis Andres Ion Badea
     * La funcion permite consultar el coste salarial que tiene  cada departamento
     */
    public static void consultarCosteSalDep() {

        System.out.println("Introduce el id del departamento: ");
        int idDep = inputValue.nextInt();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getIdDep() == idDep) {
                System.out.println("El coste salarial del departamento " + idDep + " es de " + empleados.get(i).getGCotizacion());
            }
        }
    }

    /**
     * @throws IOException
     * @author: Denis Andres Ion Badea
     * La funcion permite modificar los datos de un empleado atraves del NIF
     */

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

    /**
     * @throws IOException
     * @author: Carlos Hernandez Garcia
     * La funcion permite borrar un empleado a partir de su NIF
     */

    public static void eliminarEmpleado() throws IOException {

        System.out.println("Introduce el NIF del empleado a eliminar: ");
        String NIF = inputValue.next();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNIF() == NIF) {
                empleados.remove(i);
            }
        }
        guardarEmpleados();
    }

    /**
     * @throws IOException
     * @author: Denis Andres Ion Badea
     * La funcion permite leer los grupos de cotizacion de y cargarlos en memoria
     */
    public static void leerCotizacion() throws IOException {
        miFichero = new File("./src/Cotizacion.csv");
        if (!miFichero.exists()) {
            System.out.println("El fichero no existe");
        }
        BufferedReader flujoEntrada = new BufferedReader(new FileReader(miFichero));
        String linea = flujoEntrada.readLine();
        while (linea != null) { // Va leyendo lineas y mientras no llegue al final nos va mostrando su contenido
            String[] salarioArray = linea.split(";");
            salarios.add(new Salario(Integer.parseInt(salarioArray[0]), Integer.parseInt(salarioArray[1])));
            linea = flujoEntrada.readLine();
        }
    }

    /**
     * @throws IOException
     * @author: Carlos Hernandez Garcia
     * @collaborator: Iker Rodriguez Montava
     * La funcion permite consultar el coste salarial de cada grupo de cotizacion
     */

    public static void consultarSalarioCatProfesional() throws IOException {

        int suma = 0;
        int salarioEmpleado = 0;

        System.out.print("Introduce la categoría progesional a consultar: ");
        String idCatPro = inputValue.next();
        for (Categorias categorias1 : categorias) {
            if (categorias1.getCategoria().equals(idCatPro)) {
                for (Empleados empleados1 : empleados) {
                    for (Salario salario : salarios) {
                        if (empleados1.getCatGProfesional().equals(idCatPro)) {
                            Empleados empleados2 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                                    empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(), empleados1.getIdDep());
                            auxE.add(empleados2);
                            salarioEmpleado = salario.getDinero();
                            suma += salarioEmpleado;
                        }
                        break;
                    }
                }
                System.out.println("La categoría profesional " + categorias1.getCategoria() + " tiene un salario de: " + suma);
            }
        }
    }

    /**
     * @throws IOException
     * @author: Denis Andres Ion Badea
     * @collaborator: Iker Rodriguez Montava
     * La funcion permite consultar el coste salarial total de la empresa
     */

    public static void consultarSalarioEmpresa() throws IOException {

        int suma = 0;
        int i = 0;
        for (Salario salario1 : salarios) {
            suma += salario1.getDinero() * cantECod[i];
            i++;
        }

        System.out.println("El coste salarial de la empresa es = " + suma);
    }


    /**
     * @throws IOException
     * @author: Denis Andres Ion Badea
     * @collaborator: Iker Rodriguez Montava
     * La funcion permite consultar el coste salarial de cada departamento
     */

    public static void consultarSalarioDepartamento() throws IOException {
        int suma = 0;
        int salarioEmpleado = 0;
        for (Departamentos departamentos1 : departamentos) {
            for (Empleados empleados1 : empleados) {
                for (Salario salario : salarios) {
                    if (empleados1.getIdDep() == departamentos1.getIdDep()) {
                        Empleados empleados2 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                                empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(), empleados1.getIdDep());
                        auxE.add(empleados2);
                        if (empleados1.getGCotizacion() == salario.getGCot()) {
                            salarioEmpleado = salario.getDinero();
                            suma += salarioEmpleado;
                        }
                    }
                }
            }
            System.out.println("EL departamento " + departamentos1.getNombreDep() + " tiene un salario de: " + suma);
            auxE.clear();
            suma = 0;
        }
    }

    /**
     * @throws IOException
     * @author: Iker Rodriguez Montava
     * @collaborator: Carlos Hernandez Garcia
     * La funcion permite leer las horas extra y cargarlos en memoria
     */

    public static void leerHoras() throws IOException {
        miFichero = new File("./src/Horas.csv");
        if (!miFichero.exists()) {
            System.out.println("El fichero no existe");
        }
        BufferedReader flujoEntrada = new BufferedReader(new FileReader(miFichero));
        String linea = flujoEntrada.readLine();
        while (linea != null) { // Va leyendo lineas y mientras no llegue al final nos va mostrando su contenido
            String[] horasArray = linea.split(";");
            horas.add(new Horas(horasArray[0], horasArray[1], Integer.parseInt(horasArray[2])));
            linea = flujoEntrada.readLine();
        }
    }

    /**
     * @throws IOException
     * @author: Denis Andres Ion Badea
     * La funcion permite consultar las horas extras que se han hecho en cada departamento
     */

    public static void consultarHorasExtrasDepartamento() {
        int horasE = 0;
        System.out.println("1.- Comercial");
        System.out.println("2.- Contabilidad");
        System.out.println("3.- Informatica");
        System.out.println("4.- Personal");
        System.out.println();
        System.out.println("Introduce el departamento a consultar las horas extras: ");
        int eleccion = inputValue.nextInt();

        for (Empleados empleados1 : empleados) {
            for (Horas horas1 : horas) {
                if (empleados1.getIdDep() == eleccion) {
                    Empleados empleados2 = new Empleados(empleados1.getNIF(), empleados1.getNombre(), empleados1.getApellido1(), empleados1.getApellido2(), empleados1.getCuenta(),
                            empleados1.getAntiguedad(), empleados1.getNASeguridadSocial(), empleados1.getCatGProfesional(), empleados1.getGCotizacion(), empleados1.getEmail(), empleados1.getIdDep());
                    auxE.add(empleados2);
                    if (empleados1.getNIF().equals(horas1.getNIF())) {
                        horasE += horas1.getHoras();
                    }
                }
            }
        }
        System.out.println();
        System.out.println("EL departamento " + eleccion + " tiene " + horasE + " horas extras realizadas en total.");
    }

    /**
     * @throws IOException
     * @author: Carlos Hernandez Garcia
     * La funcion nos permite incorporar nuevas categorias profesionales
     */
    public static void nuevaCategoriaProfesional() throws IOException {

        System.out.println("Introduce el id de la nueva categoria: ");
        String id = inputValue.next();

        Categorias categorias1 = new Categorias(id);
        categorias.add(categorias1);
        System.out.println("Categoria añadida correctamente");
        System.out.println();
        System.out.println("Las categorias actuales son las siguientes: ");
        for (Categorias catProfesionales1 : categorias) {
            System.out.println(catProfesionales1.getCategoria());
        }
        guardarCategorias();

    }

    /**
     * @throws IOException
     * @author: Carlos Hernandez Garcia
     * La funcion nos permite guardar nuevas categorias profesionales
     */
    public static void guardarCategorias() {

        try {
            miFichero = new File("./src/CategoriasProfesionales.csv");
            if (!miFichero.exists()) {
                System.out.println("El fichero no existe");
            }
            BufferedWriter flujoSalida = new BufferedWriter(new FileWriter(miFichero));
            for (int i = 0; i < categorias.size(); i++) {
                flujoSalida.write(String.valueOf(categorias.get(i).getCategoria()));
                flujoSalida.write("\n");
            }
            flujoSalida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws IOException
     * @author: Carlos Hernandez Garcia
     * @collaborator: Denis Andres Ion Badea
     * @collaborator: Iker Rodriguez Montava
     * La funcion nos permite borrar un departamento una vez que no tenga empleados
     */

    public static void borrarDepartamento() throws IOException {
        Departamentos departamentos2 = null;
        boolean tiene = true;
        boolean existe = false;
        System.out.print("Introduce el departamento a borrar: ");
        int eleccion = inputValue.nextInt();
        for (Departamentos departamentos1 : departamentos) {
            if (departamentos1.getIdDep() == eleccion) {
                existe = true;
                for (Empleados empleados1 : empleados) {
                    if (empleados1.getIdDep() == departamentos1.getIdDep()) {
                        tiene = true;
                        break;
                    } else {
                        tiene = false;
                        departamentos2 = departamentos1;
                    }
                }
                break;
            }
            existe = false;
        }

        if (existe) {
            if (tiene) {
                System.out.println("Este departamento contiene empleados, por lo que todos los empleados asociados se eliminarán.");
                System.out.println("¿Está seguro que desea continuar?");
                System.out.println("1.- Si");
                System.out.println("2.- No");
                int aceptar = inputValue.nextInt();
                for (int i = 0; i < departamentos.size(); i++) {
                    if (departamentos.get(i).getIdDep() == eleccion) {
                        if (aceptar == 1) {
                            for (int j = 0; j < empleados.size(); j++) {
                                if (empleados.get(j).getIdDep() == departamentos.get(i).getIdDep()) {
                                    empleados.remove(empleados.get(j));
                                    j--;
                                }
                            }
                            departamentos.remove(departamentos.get(i));
                            System.out.println("Departamento borrado correctamente");
                            break;
                        } else if (aceptar == 2) {
                            System.out.println("Borrado cancelado");
                        }
                    }
                }
            } else {
                departamentos.remove(departamentos2);
                System.out.println("Departamento borrado correctamente");
            }
            guardarDepartamentos();
            guardarEmpleados();
        }else {
            System.out.println("El departamento introducido no existe");
        }
    }

        /**
         * @author: Denis Andres Ion Badea
         * @collaborator: Carlos Hernandez Garcia
         * La funcion nos permite borrar una categoria profesional una vez que no tenga empleados
         * @throws IOException
         */

    public static void borrarCategoriaProfesional() throws IOException{
        Categorias categorias2 = null;
        boolean tiene = true;
        boolean existe = false;
        System.out.print("Introduce la categoría a borrar: ");
        String eleccion = inputValue.next();
        for (Categorias categorias1 : categorias) {
            if (categorias1.getCategoria().equals(eleccion)) {
                existe = true;
                for (Empleados empleados1 : empleados) {
                    if (empleados1.getCatGProfesional().equals(categorias1.getCategoria())) {
                        tiene = true;
                        break;
                    } else {
                        tiene = false;
                        categorias2 = categorias1;
                    }
                }
                break;
            }
            existe = false;
        }

        if (existe) {
            if (tiene) {
                System.out.println("Esta categoría contiene empleados, por lo que todos los empleados asocaidos a ella se eliminarán.");
                System.out.println("¿Está seguro que desea continuar?");
                System.out.println("1.- Si");
                System.out.println("2.- No");
                int aceptar = inputValue.nextInt();
                for (int i = 0; i < categorias.size(); i++) {
                    if (categorias.get(i).getCategoria().equals(eleccion)) {
                        if (aceptar == 1) {
                            for (int j = 0; j < empleados.size(); j++) {
                                if (empleados.get(j).getCatGProfesional().equals(categorias.get(i).getCategoria())) {
                                    empleados.remove(empleados.get(j));
                                    j--;
                                }
                            }
                            categorias.remove(categorias.get(i));
                            System.out.println("Categoría borrada correctamente");
                            break;
                        } else if (aceptar == 2) {
                            System.out.println("Borrado cancelado");
                        }
                    }
                }
            } else {
                categorias.remove(categorias2);
                System.out.println("Categoría borrada correctamente");
            }
            guardarCategorias();
            guardarEmpleados();
        }else {
            System.out.println("La categoría introducida no existe");
        }
    }

        /**
         * @author: Iker Rodriguez Montava
         * Interfaz para que el usuario pueda elegir que desea hacer
         */

        public static void Menu () {

            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Bienvenido al menu principal, elija una de las siguientes opciones:");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("0.- Salir");
            System.out.println("1.- Guardar archivos ");
            System.out.println("2.- Consultar datos ");
            System.out.println("3.- Incorporar datos ");
            System.out.println("4.- Modificar datos personales ");
            System.out.println("5.- Eliminar datos ");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.print("Introduce una opcion: ");
            opcion = inputValue.nextInt();
            System.out.println();
        }


        /**
         * @author: Iker Rodriguez Montava
         * @collaborator: Carlos Hernandez Garcia
         * Submenu para la consulta de datos
         */

        public static void consultar () {

            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Bienvenido al menu para la consulta de datos");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Opciones: ");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("1.- Consultar datos empleado");
            System.out.println("2.- Consultar trabajadores por grupo cotizacion ");
            System.out.println("3.- Consultar trabajadores por departamento ");
            System.out.println("4.- Consultar cantidad de empleados por departamento");
            System.out.println("5.- Consultar coste salarial de la empresa");
            System.out.println("6.- Consultar coste salarial por categoria profesional ");
            System.out.println("7.- Consultar cantidad de horas extras por departamento ");
            System.out.println("8.- Consultar coste salarial de un departamento");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.print("Introduce una opcion: ");
            opcion = inputValue.nextInt();
        }

        /**
         * @author: Iker Rodriguez Montava
         * @collaborator: Carlos Hernandez Garcia
         * Submenu para la incorporacion de datos
         */

        public static void incorporar () {

            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Bienvenido al menu para la incorporación de datos");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Opciones: ");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("1.- Incorporar nuevo trabajador ");
            System.out.println("2.- Incorporar nueva categoria ");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.print("Introduce una opcion: ");
            opcion = inputValue.nextInt();

        }
        /**
         * @author: Iker Rodriguez Montava
         * @collaborator: Carlos Hernandez Garcia
         * Submenu para la eliminacion de datos
         */

        public static void eliminar () {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Bienvenido al menu para la eliminacion de datos");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Opciones: ");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("1.- Eliminar departamentos ");
            System.out.println("2.- Eliminar datos categoria ");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.print("Introduce una opcion: ");
            opcion = inputValue.nextInt();
        }

        /**
         * @author: Iker Rodriguez Montava
         * Lugar donde se reunen todas las funciones para que el usuario pueda elegir que desea hacer.
         */


        public static void main (String[]args)  throws IOException {

            leerArchivos();
            boolean programa = true;

            do {
                Menu();
                switch (opcion) {

                    case CERRAR_PROGRAMA:
                        programa = false;
                        System.out.println("Gracias por usar nuestro sistema.");

                        break;
                    case EXPORTAR_CSV:
                        guardarTodo();
                        System.out.println("Todos los archivos se han guardado correctamente");
                    case CONSULTAR: //Error opcion no valida
                        consultar();
                        switch (opcion) {
                            case CONSULTAR_DATOS_EMPLEADO:
                                consultarEmpleado();
                                System.out.println();
                                break;
                            case CONSULTAR_EMPLEADOS_GCOTIZACION:
                                consultarEmpleadosCotizacion(); //Error no existe grupo cotización
                                System.out.println();
                                break;
                            case CONSULTAR_EMPLEADOS_DEPARTAMENTO:
                                consultarEmpleadosDepartamentos(); //Error no existe departamento
                                System.out.println();
                                break;
                            case CONSULTAR_CANTIDADEMPLEADOS_DEPARTAMENTO:
                                consultarCantidadEmpleados();
                                System.out.println();
                                break;
                            case CONSULTAR_SALARIO_EMPRESA:
                                consultarEmpleadosGrupoCotizacion();
                                consultarSalarioEmpresa();
                                System.out.println();
                                break;
                            case CONSULTAR_SALARIO_GCOT: //Error de "profgesional"
                                consultarEmpleadosGrupoCotizacion();
                                consultarSalarioCatProfesional();
                                System.out.println(); //Error de no existe GCOT
                                break;
                            case CONSULTAR_HORASEXTRAS_DEPARTAMENTO: //Error departamento no existe
                                consultarHorasExtrasDepartamento();
                                System.out.println();
                                break;
                            case CONSULTAR_SALARIO_DEPARTAMENTO:
                                consultarEmpleadosGrupoCotizacion();
                                consultarSalarioDepartamento();
                                System.out.println();
                                break;
                        }
                        break;

                    case INCORPORAR://Error opcion no valida
                        incorporar();
                        switch (opcion) {
                            case INCORPORAR_NUEVOTRABAJDOR:
                                incorporarEmpleados();//Error de integer
                                guardarEmpleados();
                                break;
                            case INCORPORAR_NUEVACATEGORIA:
                                nuevaCategoriaProfesional();
                                break;
                        }
                        break;
                    case MODIFICAR_DATOSPERSONALES://Error de integer
                        modificarDatos();//Error de NIF erroneo
                        guardarEmpleados();//Poner que se ha cambiado correctamente
                        break;

                    case ELIMINAR:
                        eliminar();
                        switch (opcion) {
                            case ELIMINAR_DEPARTAMENTOS://Error de elegir entre si o no y ponemos algo que no toca
                                borrarDepartamento();//Error introduce departamento a borrar y ponemos letras
                                break;
                            case ELIMINAR_DATOSCATEGORIA://Error de diferencias mayus minus
                                borrarCategoriaProfesional();
                                break;
                        }
                        break;
                    default://Hacer try catch por strings
                        System.out.println("Opción incorrecta, introdúcela de nuevo.");
                        System.out.println();
                }
            } while (programa);

        }
}
