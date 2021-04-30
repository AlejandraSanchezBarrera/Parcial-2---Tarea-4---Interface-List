package uaslp.ingenieria.labs.list;

public class ArrayList <H> implements List<H>{

    private Object[] array;
    private int size;

    public ArrayList() {
        this.array = new Object[2];
    }

    @Override
    public void add(H data) {
        if(size==array.length){
            Object[] aux=new Object[array.length+2];

            for(int i=0;i<array.length;i++){
                aux[i]=array[i];
            }

            this.array=new Object[aux.length];

            for(int i=0;i<array.length;i++){
                array[i]=aux[i];
            }
        }
        this.array[size]=data;
        size++;
    }

    @Override
    public H get(int index) {
        return (H)array[index];
    }

    @Override
    public void delete(int index) throws MyIndexOutOfBoundException {
        if(index<0 || index>=size){
            throw new MyIndexOutOfBoundException();
        }

        for(int i=index+1;i<array.length;i++){
            this.array[i-1]=this.array[i];
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

    /*@Override
    public void insert(H data, Position position, Iterator<H> it) {

    }*/

    @Override
    public Iterator<H> getReverseIterator() {
        return new ReverseIterator();
    }

    public class ForwardIterator implements Iterator<H>{
        private int position;

        public ForwardIterator(){
            this.position=0;
        }

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public H next() {
            H data= (H) array[position];
            position++;
            return data;
        }
    }

    public class ReverseIterator implements Iterator<H>{
        private int position;

        public ReverseIterator(){
            this.position=size-1;
        }

        @Override
        public boolean hasNext() {
            return position>=0;
        }

        @Override
        public H next() {
            H data= (H) array[position];
            position--;
            return data;
        }
    }
}