package dao.impl;

import dao.ProductDAO;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class ProductFileDAO implements ProductDAO {


    @Override
    public void saveToFileDAO(String data, String address) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(address);
        byte[] array = data .getBytes();
        for (byte b : array){
            fileOutputStream.write(b);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    @Override
    public String readFromFileRepository(String address) {
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(address))) {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }
}
