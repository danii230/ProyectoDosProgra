/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodosprogramacion;

/**
 *
 * @author ValeriaLeivaQuirós
 */
public class Images {

    private String name;
    private int imageNumber;
    private int height;
    private int width;
    private String url;
    private int columnPosition;
    private int rowPosition;

    public Images() {
    }

    public Images(String name, int imageNumber, int height, int width, String url) {
        this.name = name;
        this.imageNumber = imageNumber;
        this.height = height;
        this.width = width;
        this.url = url;
    }

    public Images(String name, int imageNumber, int height, int width, String url, int columnPosition, int rowPosition) {
        this.name = name;
        this.imageNumber = imageNumber;
        this.height = height;
        this.width = width;
        this.url = url;
        this.columnPosition = columnPosition;
        this.rowPosition = rowPosition;
    }

    public int getImageNumber() {
        return imageNumber;
    }

    public void setImageNumber(int imageNumber) {
        this.imageNumber = imageNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public void setRowPosition(int rowPosition) {
        this.rowPosition = rowPosition;
    }

    public int getColumnPosition() {
        return columnPosition;
    }

    public void setColumnPosition(int columnPosition) {
        this.columnPosition = columnPosition;
    }

    @Override
    public String toString() {
        return "Images{" + "name=" + name + ", imageNumber=" + imageNumber + ", height=" + height + ", width=" + width + ", url=" + url + '}';
    }

    public String toString1() {
        return "Images{" + "name=" + name + ", imageNumber=" + imageNumber + ", height=" + height + ", width=" + width + ", url=" + url + ", colunm=" + columnPosition + ",row=" + rowPosition + '}';
    }
}
