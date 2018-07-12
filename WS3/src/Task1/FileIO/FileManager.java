package Task1.FileIO;

import Task1.DataManagement.Contact;
import Task1.UI.UI;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.UnsupportedCharsetException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;


public class FileManager {

    static int pos = 0;
    static Path path = Paths.get("Address.dat");
    static int length = 0;

    public static void updateRecord(String str){

        ByteBuffer out = null;
        try{
            byte data[] = str.getBytes("UTF-8");
            out = ByteBuffer.wrap(data);
        }catch(UnsupportedCharsetException e) {
            System.out.println("Charset Stupidity!");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Encoding Stupidity!");
        }

        try (FileChannel fc = (FileChannel.open(path, WRITE))) {
            fc.position(pos * 96); //Record will be the last one read, kept track of by pos;
            while (out.hasRemaining()) {
                fc.write(out);
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }

        UI.ChangeContact(new Contact());
    }

    public static void createRecord(String str)
    {
        ByteBuffer out = null;
        try{
            byte data[] = str.getBytes("UTF-8");
            out = ByteBuffer.wrap(data);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Encoding Stupidity!");
        }


        try (FileChannel fc = (FileChannel.open(path, CREATE, APPEND))){
            while (out.hasRemaining()) {
                fc.write(out);
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }

        UI.ChangeContact(new Contact());
    }

    public static Contact readRecord()
    {
        ByteBuffer in = ByteBuffer.allocate(96);
        try (FileChannel fc = (FileChannel.open(path, READ))){
            int nread;
            length = (int) fc.size();
            int maxPos = length / 96;

            if(pos < 0)
            {
                pos = 0;
            }
            if(pos > maxPos)
            {
                pos = maxPos;
            }

            fc.position(pos * 96);
            do {
                nread = fc.read(in);
            } while (nread != -1 && in.hasRemaining());
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        in.flip();

        try {
            return new Contact(new String(in.array(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
           System.out.println("Stupid Encoding");
            return null;
        }
    }

    public static Contact readLastRecord()
    {
        ByteBuffer in = ByteBuffer.allocate(96);
        try (FileChannel fc = (FileChannel.open(path, READ))){
            length = (int) fc.size();
            pos = length / 96;
            int nread;
            fc.position(length - 96);
            do {
                nread = fc.read(in);
            } while (nread != -1 && in.hasRemaining());
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        in.flip();

        try {
            return new Contact(new String(in.array(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("Stupid Encoding");
            return null;
        }
    }

    public static void setPos(int pos) {
        FileManager.pos = pos;
    }

    public static int getPos() {
        return pos;
    }

}
