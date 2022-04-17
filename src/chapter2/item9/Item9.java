package chapter2.item9;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Item9 {

    private static String firstLineOfFile(String path) throws IOException {
        // try-finally 이용하여 자원 회수
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            System.out.println("firstLineOfFile - finally");
            br.close();
        }
    }

    private static void fileCopy(String from, String to) throws IOException {
        // 2개 이상 자원을 try-finally 이용하여 회수
        InputStream is = new FileInputStream(from);
        try {
            OutputStream os = new FileOutputStream(to);
            try {
                // something...
                byte[] buf = new byte[100];
                os.write(buf, 0, 500);
            } finally {
                os.close();
            }
        } finally {
            is.close();
        }
    }

    private static void fileCopy2(String from, String to) throws IOException {
        // 2개 이상 자원을 try-with-resources 이용하여 회수
        try (InputStream is = new FileInputStream(from);
            OutputStream os = new FileOutputStream(to)) {
            // something...
            byte[] buf = new byte[100];
            os.write(buf, 0, 500);
        }
    }

    public static void main(String[] args) {
        Path currentRelativePath = Paths.get("");
        final String path = currentRelativePath.toAbsolutePath().toString() + "/src/chapter2/item9/Item9.java";

        try {
            firstLineOfFile(path);
        } catch (Exception e) {
            System.out.println(e.toString());
            ;
        }
        /** 출력
         * firstLineOfFile - finally
         */

        final String path2 = path;
        final String path3 = "toFile";

        // 2개 이상 자원 사용하는 경우.. 두번째 예외가 첫번째 예외를 집어삼켜 버린다.
        try {
            fileCopy(path2, path3);
        } catch (Exception e) {
            System.out.println(e.toString());
            ;
        }
        /** 출력
         * java.lang.IndexOutOfBoundsException
         */

        // 2개 이상 자원 사용하는 경우.. try-with-resources 방식 이용
        try {
            fileCopy2(path2, path3);
        } catch (Exception e) {
            System.out.println(e.toString());
            ;
        }
        /** 출력
         * java.lang.IndexOutOfBoundsException
         */
    }
}
