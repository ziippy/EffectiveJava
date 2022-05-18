package chapter6.item41;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

class Sample {
    private final int a;
    private final int b;
    public Sample(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class SampleWithSerializable implements Serializable {
    private final int a;
    private final int b;
    public SampleWithSerializable(int a, int b) {
        this.a = a;
        this.b = b;
    }
}


public class Item41 {

    public static void main(String[] args) throws Exception {
        File f = new File("a.txt");
        FileOutputStream fo = new FileOutputStream(f);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fo);
        try {
            objectOutputStream.writeObject(new Sample(1, 2));
            System.out.println("write 성공");
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            objectOutputStream.close();
            fo.close();
            f.delete();
        }
        /** 출력
         * java.io.NotSerializableException: chapter6.item41.Sample
         */

        File f2 = new File("a2.txt");
        FileOutputStream fo2 = new FileOutputStream(f2);
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fo2);
        try {
            objectOutputStream2.writeObject(new SampleWithSerializable(1, 2));
            System.out.println("write 성공");
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            objectOutputStream2.close();
            fo2.close();
            f2.delete();
        }
        /** 출력
         * write 성공
         */
    }
}
