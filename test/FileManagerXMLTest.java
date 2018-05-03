/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.List;
import java.io.IOException;
import java.util.LinkedList;
import org.jdom.JDOMException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proyectodosprogramacion.FileManagerXml;
import proyectodosprogramacion.Images;

/**
 *
 * @author daniela
 */
public class FileManagerXMLTest {
    
    public static FileManagerXml fileManagerXml;
    
    public FileManagerXMLTest() {
        
    }
    
    @Before
   public void before() throws JDOMException, IOException {
        System.out.println("before");
       fileManagerXml = new FileManagerXml("src\\proyectodosprogramacion\\Imagenes.xml");
    }
    
//    @After
//    public void after() {
//    }
   
     @Test
     public void getImageByNumberNameTest() {
         Images resultado = fileManagerXml.getImageByNumber(2);
         Images esperado = new Images("002-vegetables", 2, 30, 30, "Icon/002-vegetables.png");
         String resultado2 = resultado.getName();
         String esperado2 = esperado.getName();
         System.out.println(resultado2);
         System.out.println(esperado2);
         assertEquals(resultado2, esperado2);
     }
     
     @Test
     public void objetReturnByNumberUrlTest() throws JDOMException, IOException {
         
      Images resultado = (Images) fileManagerXml.getImageByNumber(3);
      Images esperado = new Images("003-turkey", 3, 30, 30, "Icon/003-turkey.png");
      String resultado2 = resultado.getUrl();
      String esperado2  = esperado.getUrl();
      
      System.out.println(resultado2);
      System.out.println(esperado2);
      assertEquals(resultado2, esperado2);
         
     }
     
     @Test
     public void objetReturnByNumberImageNumberTest() throws JDOMException, IOException {
         
      Images resultado = (Images) fileManagerXml.getImageByNumber(4);
      Images esperado = new Images("004-tuna", 4, 30, 30, "Icon/004-tuna.png");
      int resultado2 = resultado.getImageNumber();
      int esperado2  = esperado.getImageNumber();
      
      System.out.println(resultado2);
      System.out.println(esperado2);
      assertEquals(resultado2, esperado2);
         
     }
     
     @Test
     public void getAllImageToStringTest(){
         LinkedList<Images> resultado = fileManagerXml.getAllImage();
         LinkedList<Images> esperado =new LinkedList();
          esperado.add(new Images("001-wine", 1, 30, 30, "Icon/001-wine.png"));
          esperado.add(new Images("002-vegetables", 2, 30, 30, "Icon/002-vegetables.png"));
          esperado.add(new Images("003-turkey", 3, 30, 30, "Icon/003-turkey.png"));
          esperado.add(new Images("004-tuna", 4, 30, 30, "Icon/004-tuna.png"));
          esperado.add(new Images("005-tea", 5, 30, 30, "Icon/005-tea.png"));
          esperado.add(new Images("006-steak", 6, 30, 30, "Icon/006-steak.png"));
          esperado.add(new Images("007-spaghetti", 7, 30, 30, "Icon/007-spaghetti.png"));
          esperado.add(new Images("008-soup", 8, 30, 30, "Icon/008-soup.png"));
          esperado.add(new Images("009-shrimp", 9, 30, 30, "Icon/009-shrimp.png"));
          esperado.add(new Images("010-sheep", 10, 30, 30, "Icon/010-sheep.png"));
          esperado.add(new Images("011-seashell", 11, 30, 30, "Icon/011-seashell.png"));
          esperado.add(new Images("012-salmon", 12, 30, 30, "Icon/012-salmon.png"));
          esperado.add(new Images("013-salad", 13, 30, 30, "Icon/013-salad.png"));
          esperado.add(new Images("014-pizza", 14, 30, 30, "Icon/014-pizza.png"));
          esperado.add(new Images("015-pork", 15, 30, 30, "Icon/015-pork.png"));
          esperado.add(new Images("016-pancakes", 16, 30, 30, "Icon/016-pancakes.png"));
          esperado.add(new Images("017-sandwich", 17, 30, 30, "Icon/017-sandwich.png"));
          esperado.add(new Images("018-lobster", 18, 30, 30, "Icon/018-lobster.png"));
          esperado.add(new Images("019-lamb", 19, 30, 30, "Icon/019-lamb.png"));
          esperado.add(new Images("020-ice-cream", 20, 30, 30, "Icon/020-ice-cream.png"));
          esperado.add(new Images("021-hot-dog", 21, 30, 30, "Icon/021-hot-dog.png"));
          esperado.add(new Images("022-food", 22, 30, 30, "Icon/022-food.png"));
          esperado.add(new Images("023-fish", 23, 30, 30, "Icon/023-fish.png"));
          esperado.add(new Images("024-crab", 24, 30, 30, "Icon/024-crab.png"));
          esperado.add(new Images("025-coffee", 25, 30, 30, "Icon/025-coffee.png"));
          esperado.add(new Images("026-chicken-1", 26, 30, 30, "Icon/026-chicken-1.png"));
          esperado.add(new Images("027-chicken", 27, 30, 30, "Icon/027-chicken.png"));
          esperado.add(new Images("028-cheese", 28, 30, 30, "Icon/028-cheese.png"));
          esperado.add(new Images("029-beef-1", 29, 30, 30, "Icon/029-beef-1.png"));
          esperado.add(new Images("030-cake", 30, 30, 30, "Icon/030-cake.png"));
          esperado.add(new Images("031-burrito", 31, 30, 30, "Icon/031-burrito.png"));
          esperado.add(new Images("032-hamburger", 32, 30, 30, "Icon/032-hamburger.png"));
          esperado.add(new Images("033-beer", 33, 30, 30, "Icon/033-beer.png"));
          esperado.add(new Images("034-beef", 34, 30, 30, "Icon/034-beef.png"));
          esperado.add(new Images("035-bbq", 35, 30, 30, "Icon/035-bbq.png"));
          esperado.add(new Images("036-bacon", 36, 30, 30, "Icon/036-bacon.png"));
         String resultado2 = resultado.get(2).toString();
         String esperado2 = esperado.get(2).toString();
         System.out.println(resultado2);
         System.out.println(esperado2);
         assertEquals(resultado2, esperado2);
         
     }
     
      @Test
     public void getAllImageNameTest(){
         LinkedList<Images> resultado = fileManagerXml.getAllImage();
         LinkedList<Images> esperado =new LinkedList();
          esperado.add(new Images("001-wine", 1, 30, 30, "Icon/001-wine.png"));
          esperado.add(new Images("002-vegetables", 2, 30, 30, "Icon/002-vegetables.png"));
          esperado.add(new Images("003-turkey", 3, 30, 30, "Icon/003-turkey.png"));
          esperado.add(new Images("004-tuna", 4, 30, 30, "Icon/004-tuna.png"));
          esperado.add(new Images("005-tea", 5, 30, 30, "Icon/005-tea.png"));
          esperado.add(new Images("006-steak", 6, 30, 30, "Icon/006-steak.png"));
          esperado.add(new Images("007-spaghetti", 7, 30, 30, "Icon/007-spaghetti.png"));
          esperado.add(new Images("008-soup", 8, 30, 30, "Icon/008-soup.png"));
          esperado.add(new Images("009-shrimp", 9, 30, 30, "Icon/009-shrimp.png"));
          esperado.add(new Images("010-sheep", 10, 30, 30, "Icon/010-sheep.png"));
          esperado.add(new Images("011-seashell", 11, 30, 30, "Icon/011-seashell.png"));
          esperado.add(new Images("012-salmon", 12, 30, 30, "Icon/012-salmon.png"));
          esperado.add(new Images("013-salad", 13, 30, 30, "Icon/013-salad.png"));
          esperado.add(new Images("014-pizza", 14, 30, 30, "Icon/014-pizza.png"));
          esperado.add(new Images("015-pork", 15, 30, 30, "Icon/015-pork.png"));
          esperado.add(new Images("016-pancakes", 16, 30, 30, "Icon/016-pancakes.png"));
          esperado.add(new Images("017-sandwich", 17, 30, 30, "Icon/017-sandwich.png"));
          esperado.add(new Images("018-lobster", 18, 30, 30, "Icon/018-lobster.png"));
          esperado.add(new Images("019-lamb", 19, 30, 30, "Icon/019-lamb.png"));
          esperado.add(new Images("020-ice-cream", 20, 30, 30, "Icon/020-ice-cream.png"));
          esperado.add(new Images("021-hot-dog", 21, 30, 30, "Icon/021-hot-dog.png"));
          esperado.add(new Images("022-food", 22, 30, 30, "Icon/022-food.png"));
          esperado.add(new Images("023-fish", 23, 30, 30, "Icon/023-fish.png"));
          esperado.add(new Images("024-crab", 24, 30, 30, "Icon/024-crab.png"));
          esperado.add(new Images("025-coffee", 25, 30, 30, "Icon/025-coffee.png"));
          esperado.add(new Images("026-chicken-1", 26, 30, 30, "Icon/026-chicken-1.png"));
          esperado.add(new Images("027-chicken", 27, 30, 30, "Icon/027-chicken.png"));
          esperado.add(new Images("028-cheese", 28, 30, 30, "Icon/028-cheese.png"));
          esperado.add(new Images("029-beef-1", 29, 30, 30, "Icon/029-beef-1.png"));
          esperado.add(new Images("030-cake", 30, 30, 30, "Icon/030-cake.png"));
          esperado.add(new Images("031-burrito", 31, 30, 30, "Icon/031-burrito.png"));
          esperado.add(new Images("032-hamburger", 32, 30, 30, "Icon/032-hamburger.png"));
          esperado.add(new Images("033-beer", 33, 30, 30, "Icon/033-beer.png"));
          esperado.add(new Images("034-beef", 34, 30, 30, "Icon/034-beef.png"));
          esperado.add(new Images("035-bbq", 35, 30, 30, "Icon/035-bbq.png"));
          esperado.add(new Images("036-bacon", 36, 30, 30, "Icon/036-bacon.png"));
         String resultado2 = resultado.get(2).getName();
         String esperado2 = esperado.get(2).getName();
         System.out.println(resultado2);
         System.out.println(esperado2);
         assertEquals(resultado2, esperado2);
         
     }
}

