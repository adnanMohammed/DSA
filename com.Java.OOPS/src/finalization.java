public class finalization {
   //this is a method called by Garbage collector when unused/destroyed objects should be cleanedup
    //this method can be used to perform some action when Objects to be destroyed.
    @Override
    protected void finalize() throws Throwable {
      //  super.finalize();
        System.out.println("Objects being destroyed");
    }

    public static void main(String[] args) {
        finalization fin=new finalization();
        //fin.finalize();
        for (int i = 0; i <10000000; i++) {
            fin=new finalization();
        }

    }


}
