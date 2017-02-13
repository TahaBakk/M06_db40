import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * Created by x3727349s on 13/02/17.
 */
public class Main {

    public static void main(String[] args) {


        int opcion = 0;
        do {


            Scanner sc = new Scanner(System.in);

            System.out.println("Introduce una opcion");
            System.out.println("-----------------------------------------------------");
            System.out.println("1 Introducir datos por defecto");
            System.out.println("2 Consultar datos de la DDBBD");
            System.out.println("3 Insertar un persona");
            System.out.println("0 Salir");
            System.out.println("-----------------------------------------------------");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    datosDefecto();
                    break;
                case 2:
                    consultar();
                    break;
                case 3:
                    introducirPersona();
                    break;
                default:
                    break;
            }


        } while (opcion != 0);

    }

    public static void datosDefecto(){
        ObjectContainer db = null;
        try{
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "persons.data");

            Person brian = new Person("Brian", "Goetz", 39);
            Person jason = new Person("Jason", "Hunter", 35);
            Person brians = new Person("Brian", "Sletten", 38);
            Person david = new Person("David", "Geary", 55);
            Person glenn = new Person("Glenn", "Vanderberg", 40);
            Person neal = new Person("Neal", "Ford", 39);

            db.store(brian);
            db.store(jason);
            db.store(brians);
            db.store(david);
            db.store(glenn);
            db.store(neal);

            db.commit();

        }finally {
            if (db != null)
                db.close();
        }
    }

    public static void consultar(){
        ObjectContainer db = null;
        try {
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "persons.data");
            ObjectSet<Person> set = db.queryByExample(new Person(null, null, 0));
            while (set.hasNext())
                System.out.println(set.next());

        }finally {
            if (db != null)
                db.close();
        }
    }

    public static void introducirPersona(){
        ObjectContainer db = null;
        try {
         db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "persons.data");

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre:");
        String nombre =sc.nextLine();
        System.out.println("Introduce el  apellido:");
        String apellido =sc.nextLine();
        System.out.println("Introduce la edad:");
        int edad =sc.nextInt();

        db.store(new Person(nombre, apellido, edad));
        }finally {
            if (db != null)
                db.close();
        }
    }



}
