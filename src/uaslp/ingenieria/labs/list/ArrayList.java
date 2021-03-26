package uaslp.ingenieria.labs.list;

public class ArrayList <H> implements List<H>{

    private Object array[];
    private int size;

    public ArrayList() {
        this.array = new Object[2];
    }

    @Override
    public void add(H data) {
        if(size==array.length){
            Object aux[]=new Object[array.length+2];

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
            this.position=0;
        }

        public ForwardIterator(int position){
            this.position=position;
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

        public ReverseIterator(int position){
            this.position = position;
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