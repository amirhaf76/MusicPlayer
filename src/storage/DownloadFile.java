package storage;

import java.io.*;
import java.util.ArrayList;

public class DownloadFile {

    private final File file;
    private final ArrayList<byte[]> data = new ArrayList<>();
    private int partNumber = 0;
    private boolean end = false;
    private boolean ready = false;
    private final int MB = 1024 * 1024;

    public DownloadFile(File file) {
        this.file = file;
    }

    public void prepareForSending() throws IOException {
        BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(file));
        int bytesAccount;

        while ( true ) {
            byte[] temp = new byte[MB];
            if ( (bytesAccount = buffer.read(temp)) == -1 ) {
                break;
            }
            if (bytesAccount == MB) {

                data.add(temp);

            }
            else {
                byte[] bytes = new byte[bytesAccount];
                System.arraycopy(temp, 0, bytes, 0, bytesAccount);
                data.add(bytes);

            }
        }

        ready = true;
        buffer.close();
    }

    public ArrayList<byte[]> getData() {
        return data;
    }

    public byte[] getPartOfData() {
        byte[] temp = null; // TODO: 6/28/2019 null is here. be careful
        if ( partNumber >= 0 && partNumber < data.size() ) {

            if ( partNumber == data.size()-1 ) { // last part : data.size() - 1
                end = true;
            }

            temp = data.get(partNumber);
            partNumber++;
        }

        return temp;
    }

    public boolean isEnd() {
        return end;
    }

    public boolean isReady() {
        return ready;
    }

    public int getPartNumber() {
        return partNumber;
    }
}

