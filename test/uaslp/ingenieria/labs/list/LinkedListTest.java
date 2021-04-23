package uaslp.ingenieria.labs.list;

import com.sun.jdi.connect.spi.TransportService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {
    @Test
    public void givenANewListIsCreated_ThenListIsEmpty(){
        //Given:

        //When:
        ArrayList<Integer> lista =new ArrayList<>();
        LinkedList<String> listaS=new LinkedList<>();

        //Then:
        assertEquals(0,lista.getSize());
        assertEquals(0,listaS.getSize());
    }
}
