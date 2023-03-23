public class MazePrintingAllPaths {

    public static void main(String[] args) {
        MazePrint("", 3, 3);
        System.out.println();
    }

    public static void MazePrint(String proc, int row, int column) {
        if(row==1 && column==1) {
            System.out.print(proc+",");
            return;
        }
        if(row>1)
            MazePrint(proc+"D",row-1,column);

        if(column>1)
            MazePrint(proc+"R",row,column-1);




    }
}
