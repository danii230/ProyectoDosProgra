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
import proyectodosprogramacion.FileArmacabeza;
import proyectodosprogramacion.Images;

/**
 *
 * @author daniela
 */
public class FileArmacabezaTest {
    
    public static FileArmacabeza fileArmacabeza;
    
    public FileArmacabezaTest() {
       
    }
    
    @Before
    public void before() {
        System.out.println("before");
        fileArmacabeza = new FileArmacabeza();
    }
    
//    @After
//    public void after() {
//        System.out.println("after");
//      
//    }

 
     @Test
     public void objetReturnByNumber() throws JDOMException, IOException {
         
      Object result = fileArmacabeza.objetAReturnByNumber("xml", 2);
      Object esperado = new Images("002-vegetables", 2, 30, 30, "Icon/002-vegetables.png");
         System.out.println(result);
         System.out.println(esperado);
         assertEquals(result, esperado);
         
     }
}

