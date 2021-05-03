package uaslp.ingenieria.labs.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListTest {

    //biblioteca -> código ya hecho que podamos utilizar
    //framework -> JUnit es como otra biblioteca que se añade en el proyecto, pero como hace cosas por si misma,
    // algo corre, y así deja de ser una biblioteca
    //jar -> empaquetado de código java
    //Aserciones -> permiten validar que la ejecución fue correcta
    //expresivo -> que al leer el lenguage se entienda
    //TDD -> test driven development -> desarrollo basado en pruebas
    @Test
    public void whenLinkedListIsCreated_thenSizeIsZero() {
        //inicialización
        LinkedList<String> list = new LinkedList<>();

        //ejecución
        int size=list.getSize();

        //Validación
        assertEquals(0,size,"Size no es cero");
    }

    @Test
    public void givenANewLinkedList_when_AddElement_thenSizeIsOne(){
        //inicialización
        LinkedList<String> list = new LinkedList<>();

        //ejecución
        list.add("Hola");

        //Validación
        assertEquals(1,list.getSize());
        assertEquals("Hola",list.get(0),"Se esperaba 'Hola'");
    }

    @Test
    public void givenAnExistenLinkedListWith1Element_whenAddElement_thenSizeIsOne(){
        LinkedList<String> list = new LinkedList<>();

        //ejecución
        list.add("Hola");
        list.add("Test");

        //Validación
        assertEquals(2,list.getSize());
        assertEquals("Hola",list.get(0),"Se esperaba 'Hola'");
        assertEquals("Test",list.get(1),"Se esperaba 'Test'");
    }

    @Test
    public void givenAnExistenLinkedListWith2Elements_whenAddElement_thenSizeIncrements(){
        LinkedList<String> list = new LinkedList<>();

        //ejecución
        list.add("Hola");
        list.add("Test");
        list.add("Para");

        //Validación
        assertEquals(3,list.getSize());
        assertEquals("Hola",list.get(0),"Se esperaba 'Hola'");
        assertEquals("Test",list.get(1),"Se esperaba 'Test'");
        assertEquals("Para",list.get(2),"Se esperaba 'Para'");
    }

    @Test
    public void givenAnExistenLinkedListWith3Elements_whenAddElement_thenSizeIncrements(){
        LinkedList<String> list = new LinkedList<>();

        //ejecución
        list.add("Hola");
        list.add("Test");
        list.add("Para");
        list.add("LinkedList");

        //Validación
        assertEquals(4,list.getSize());
        assertEquals("Hola",list.get(0),"Se esperaba 'Hola'");
        assertEquals("Test",list.get(1),"Se esperaba 'Test'");
        assertEquals("Para",list.get(2),"Se esperaba 'Para'");
        assertEquals("LinkedList",list.get(3),"Se esperaba 'LinkedList");
    }

    @Test
    public void givenALinkedListWith4Elements_whenIterator_thenElementIsAccesible(){
        LinkedList<String> list = new LinkedList<>();

        list.add("Hola");
        list.add("Test");
        list.add("Para");
        list.add("LinkedList");

        Iterator<String> it= list.getIterator();;

        assertTrue(it.hasNext());
        assertEquals("Hola",it.next());
        assertTrue(it.hasNext());
        assertEquals("Test",it.next());
        assertTrue(it.hasNext());
        assertEquals("Para",it.next());
        assertTrue(it.hasNext());
        assertEquals("LinkedList",it.next());
    }

    @Test
    public void givenALinkedListWith4Elements_whenReverseIterator_thenElementIsAccesible(){
        LinkedList<String> list = new LinkedList<>();

        list.add("Hola");
        list.add("Test");
        list.add("Para");
        list.add("LinkedList");

        Iterator<String> it= list.getReverseIterator();

        assertTrue(it.hasNext());
        assertEquals("LinkedList",it.next());
        assertTrue(it.hasNext());
        assertEquals("Para",it.next());
        assertTrue(it.hasNext());
        assertEquals("Test",it.next());
        assertTrue(it.hasNext());
        assertEquals("Hola",it.next());
    }

    @Test
    public void givenAnExistenLinkedListWith4Elements_thenDeleteHeadElement_theSizeeDecremens() throws MyIndexOutOfBoundException {
        LinkedList<String> list=new LinkedList<>();

        list.add("Hola");
        list.add("Test");
        list.add("Para");
        list.add("LinkedList");

        list.delete(0);

        assertEquals(3,list.getSize(),"Debería ser size = 3");
        assertEquals("Test",list.get(0));
        assertEquals("Para",list.get(1));
        assertEquals("LinkedList",list.get(2));
    }

    @Test
    public void givenAnExistenLinkedListWith4Eelementes_DeleteLastElement_thenSizeDecrement() throws MyIndexOutOfBoundException {
        LinkedList<String> list=new LinkedList<>();

        list.add("Hola");
        list.add("Test");
        list.add("Para");
        list.add("LinkedList");

        list.delete(3);

        assertEquals(3,list.getSize(),"Debería ser size = 3");
        assertEquals("Hola",list.get(0));
        assertEquals("Test",list.get(1));
        assertEquals("Para",list.get(2));
    }

    @Test
    public void givenAnExistenLinkedListWith4Eelementes_DeleteMiddleElement_thenSizeDecrement() throws MyIndexOutOfBoundException {
        LinkedList<String> list=new LinkedList<>();

        list.add("Hola");
        list.add("Test");
        list.add("Para");
        list.add("LinkedList");

        list.delete(2);

        assertEquals(3,list.getSize(),"Debería ser size = 3");
        assertEquals("Hola",list.get(0));
        assertEquals("Test",list.get(1));
        assertEquals("LinkedList",list.get(2));
    }

    @Test
    public void givenAnExistenLinkedListWith4Elementes_WhenDeleteAll_theSizeIsZero() {
        LinkedList<String> list=new LinkedList<>();

        list.add("Hola");
        list.add("Test");
        list.add("Para");
        list.add("LinkedList");

        Assertions.assertThrows(MyIndexOutOfBoundException.class, ()->{
            list.delete(5);
        });
    }
}
