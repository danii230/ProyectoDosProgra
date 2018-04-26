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
public class Image {

    private String name;
    private int height;
    private int width;
    private String url;

    public Image() {
    }

    public Image(String name, int height, int width, String url) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.url = url;
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

    @Override
    public String toString() {
        return "Images{" + "name=" + name + ", height=" + height + ", width=" + width + ", url=" + url + '}';
    }
    
    
}
