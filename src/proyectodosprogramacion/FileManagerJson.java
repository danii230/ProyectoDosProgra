/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodosprogramacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author ValeriaLeivaQuirós
 */
public class FileManagerJson {

    private String pathFile;

    public FileManagerJson(String pathFile) {
        this.pathFile = pathFile;
    }

    public void insertMatrixInFile(int row, int column, ArrayList imaArrayList) throws IOException {
        JSONObject matrix = new JSONObject();
        matrix.put("row", row);
        matrix.put("column", column);
        try (FileWriter fileWriter = new FileWriter(pathFile, true)) {

            fileWriter.write(matrix.toJSONString() + "\r\n");

        }

        for (int i = 0; i < imaArrayList.size(); i++) {
            JSONObject imagesObject = new JSONObject();
            Images images = (Images) imaArrayList.get(i);
            imagesObject.put("name", images.getName());
            imagesObject.put("imageNumber", images.getImageNumber());
            imagesObject.put("height", images.getHeight());
            imagesObject.put("width", images.getWidth());
            imagesObject.put("url", images.getUrl());
            imagesObject.put("columnPosition", images.getColumnPosition());
            imagesObject.put("rowPosition", images.getRowPosition());

            try (FileWriter fileWriter = new FileWriter(pathFile, true)) {

                fileWriter.write(imagesObject.toJSONString() + "\r\n");

            }
        }

    }

    public ArrayList<Images> getAllImages() throws ParseException {
        ArrayList<Images> objects = new ArrayList<>();
        JSONObject jsonObject;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(pathFile);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int cont = 0;
            while ((line = bufferedReader.readLine()) != null) {
                jsonObject = (JSONObject) new JSONParser().parse(line);
                if (cont != 0) {

                    Images image = new Images();
                    image.setName(jsonObject.get("name").toString());
                    image.setImageNumber(Integer.parseInt(jsonObject.get("imageNumber").toString()));
                    image.setHeight(Integer.parseInt(jsonObject.get("height").toString()));
                    image.setWidth(Integer.parseInt(jsonObject.get("width").toString()));
                    image.setUrl(jsonObject.get("url").toString());
                    image.setColumnPosition(Integer.parseInt(jsonObject.get("columnPosition").toString()));
                    image.setRowPosition(Integer.parseInt(jsonObject.get("rowPosition").toString()));

                    System.out.println(image.toString1());
                    objects.add(image);
                }
                cont++;
            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + pathFile + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + pathFile + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return objects;
    }

    public Object getAllAtributes() throws ParseException {

        JSONObject jsonObject;
        String position = null;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(pathFile);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int cont = 0;
            while (((line = bufferedReader.readLine()) != null) && cont == 0) {
                jsonObject = (JSONObject) new JSONParser().parse(line);

                int row = Integer.parseInt(jsonObject.get("row").toString());
                int column = Integer.parseInt(jsonObject.get("column").toString());
                position = row + "x" + column;

                cont++;
            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + pathFile + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + pathFile + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return position;
    }

    public void deleteJson(String pathDelete) {

        File fileDelete = new File(pathDelete);

        fileDelete.delete();

    }

}
