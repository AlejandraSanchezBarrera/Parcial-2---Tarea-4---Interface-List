package uaslp.ingenieria.labs.list;

public class ArrayList <H> implements List<H>{

    private Object array[];
    private int size;

    public ArrayList() {
        this.array = new Object[5];
    }

    @Override
    public void add(H data) {
        this.array[size++] = data;
    }

    @Override
    public H get(int index) {
        return (H)this.array[index];
    }

    @Override
    public void delete(int index) {

        int position=0;
        int currentIndex=0;

        if(index<0 || index>=size || size==0){
            return;
        }

        if(index>0 && index<size){
            while(position<index){
                position=position+1;
                array[currentIndex]=array[currentIndex+1];
                currentIndex++;
            }
            if (index<0 || index>=size){
                return;
            }
        }
        size--;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<H> getIterator() {
        return new ForwardIterator();
    }

    @Override
    public void insert(H data, Position position, Iterator<H> it) {

    }

    @Override
    public Iterator<H> getReverseIterator() {
        return new ReverseIterator();
    }

    public class ForwardIterator implements Iterator<H>{
        private int position;

        public ForwardIterator(){
            position=0;
        }

        @Override
        public boolean hasNext() {
            boolean result = false;
            if (position < size) {
                result=true;
            }
            return result;
        }

        @Override
        public H next() {
            position++;
            return (H) array[position-1];
        }
    }

    public class ReverseIterator implements Iterator<H>{
        private int position;

        public ReverseIterator(){
            position=size;
        }

        @Override
        public boolean hasNext() {
            boolean result = false;
            if (position < size) {
                result=true;
            }
            return result;
        }

        @Override
        public H next() {
            position--;
            return (H) array[position-1];
        }
    }
}
