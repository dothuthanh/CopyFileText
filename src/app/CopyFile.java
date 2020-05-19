package app;

import com.sun.deploy.net.socket.UnixDomainSocket;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        InputStream inStream   = null;
        OutputStream outStream = null;
        try{
            inStream = new FileInputStream(new File("file.txt"));
            outStream = new FileOutputStream(new File("file2.txt"));
            int length;
            byte[] buffer = new byte[1024];
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }
            System.out.println("File is copied successful!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inStream.close();
                outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
