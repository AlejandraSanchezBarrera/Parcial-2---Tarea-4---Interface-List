package uaslp.ingenieria.labs.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    public void whenArrayIsCreated_thenSizeZero(){
        //inicialiación
        ArrayList<Integer> list =new ArrayList<>();

        //ejecuación
        int size=list.getSize();

        //validación
        assertEquals(0,size,"Size no es cero");
    }

    @Test
    public void givenANewArray_whenAddElement_theSizeIsOne(){
        ArrayList<Integer> list=new ArrayList<>();

        list.add(500);

        assertEquals(1, list.getSize());
        assertEquals(500,list.get(0));
    }

    @Test
    public void givenAnExistentArrayWithElement_whenAddElement_thenSizeIsTwo(){
        ArrayList<Integer> list=new ArrayList<>();

        list.add(500);
        list.add(100);

        assertEquals(2, list.getSize(),"Debería tener 2 elementos");
        assertEquals(500,list.get(0));
        assertEquals(100,list.get(1));
    }
    @Test
    public void givenAnExistentArrayWithNoCapacity_whenAddElement_thenSizeAndCapactyIncremets(){
        ArrayList<Integer> list=new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        list.add(100);

        assertEquals(5,list.getSize(),"Debería tener 5 elementos");
        assertEquals(500,list.get(0));
        assertEquals(600,list.get(1));
        assertEquals(700,list.get(2));
        assertEquals(800,list.get(3));
        assertEquals(100,list.get(4));
    }

    @Test
    public void givenAListWith5Element_whenInterator_thenElementsAccesible(){
        ArrayList<Integer> list=new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);
        list.add(100);

        //ejecución
        Iterator<Integer> it= list.getIterator();

        assertTrue(it.hasNext());
        assertEquals(500,it.next());
        assertTrue(it.hasNext());
        assertEquals(600,it.next());
        assertTrue(it.hasNext());
        assertEquals(700,it.next());
        assertTrue(it.hasNext());
        assertEquals(800,it.next());
        assertTrue(it.hasNext());
        assertEquals(100,it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void givenAListWith5Element_whenReverseInterator_thenElementsAccesible(){
        ArrayList<Integer> list=new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);
        list.add(100);

        //ejecución
        Iterator<Integer> it= list.getReverseIterator();

        assertTrue(it.hasNext());
        assertEquals(100,it.next());
        assertTrue(it.hasNext());
        assertEquals(800,it.next());
        assertTrue(it.hasNext());
        assertEquals(700,it.next());
        assertTrue(it.hasNext());
        assertEquals(600,it.next());
        assertTrue(it.hasNext());
        assertEquals(500,it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void givenAnExistenArrayWith4Elements_thenDeleteElementHead_thenSizeDecrements() throws MyIndexOutOfBoundException {
        //TDD-> Test Driven Development

        ArrayList<Integer> list=new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        list.delete(0);

        assertEquals(3,list.getSize(),"Debería tener 3 elementos");
        assertEquals(600,list.get(0));
        assertEquals(700,list.get(1));
        assertEquals(800,list.get(2));
    }

    @Test
    public void givenAnExistenArrayWith4Elements_thenDeleteElementInTheMiddle_thenSizeDecrements() throws MyIndexOutOfBoundException {
        //TDD-> Test Driven Development

        ArrayList<Integer> list=new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        list.delete(1);

        assertEquals(3,list.getSize(),"Debería tener 3 elementos");
        assertEquals(500,list.get(0));
        assertEquals(700,list.get(1));
        assertEquals(800,list.get(2));
    }

    @Test
    public void givenAnExistenArrayWith4Elements_thenDeleteTailElement_thenSizeDecrements() throws MyIndexOutOfBoundException {
        //TDD-> Test Driven Development

        ArrayList<Integer> list=new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        list.delete(3);

        assertEquals(3,list.getSize(),"Debería tener 3 elementos");
        assertEquals(500,list.get(0));
        assertEquals(600,list.get(1));
        assertEquals(700,list.get(2));
    }

    @Test
    public void givenAnExistenArrayWith4Elements_whenDeleteElementWhenIndex5_thenIndexOutOfBoundExceptionIsThrown(){
        //TDD-> Test Driven Development
        ArrayList<Integer> list=new ArrayList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        Assertions.assertThrows(MyIndexOutOfBoundException.class, ()->{
            list.delete(5);
        }); //lambdas
        //interface personales -> solo tiene un método -> interfaces funcionales
    }
}
