public interface lamb {

    public int add(int i, int j);

}

    class i {
        public static void main(String[] args) {
            lamb l=new lamb() {
                @Override
                public int add(int i, int j) {
                    return 0;
                }
            };

            lamb add=(i,j)-> {

              return i+j;
            };
        }

    }

