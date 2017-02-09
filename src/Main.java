
import com.db4o.Db4o;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.sun.org.apache.xpath.internal.operations.String;

/**
 * Created by x3727349s on 09/02/17.
 */
public class Main {

    public static void main(String[] args)
            throws Exception
    {
        ObjectContainer db = null;

        try
        {
            db =    Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "persons.data");
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

            // Find all the Brians
            ObjectSet brians = db.get(new Person("Brian", null, 0));
            while (brians.hasNext())
                System.out.println(brians.next());
        }
        finally
        {
            if (db != null)
                db.close();
        }
    }


}
