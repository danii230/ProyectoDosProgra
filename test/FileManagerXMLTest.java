/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
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
       
       fileManagerXml = new FileManagerXml("src\\proyectodosprogramacion\\Imagenes.xml");
    }
    
//    @After
//    public void after() {
//    }

 
     @Test
     public void getImageByNumberTest() {
         Images resultado = fileManagerXml.getImageByNumber(2);
         Images esperado = new Images("002-vegetables", 2, 30, 30, "Icon/002-vegetables.png");
          System.out.println(resultado);
         System.out.println(esperado);
         assertEquals(resultado, esperado);
     }
}

