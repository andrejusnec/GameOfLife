package gameoflife;

public class GameOfLife {

    public static void main(String[] args) {
        char[][] field = new char[10][10];
        char[][] field2 = new char[10][10];
        /**
         * ***********************Fill the array**************************
         */
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (Math.random() < 0.22) {
                    field[i][j] = 'X';
                } else {
                    field[i][j] = '.';
                }
            }
        }
        int count = 0;
        int[] iV = new int[3];
        int[] jV = new int[3];
        boolean flagA, flagB; // flagA tai a lenteles ribos, flagB stulpeliu ribos
        for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field.length; j++) {
                    System.out.print(field[i][j] + " ");
                }
                System.out.println();
            }
        for (int abc = 0; abc < 50; abc++) {
            System.out.println("");
            for (int a = 0; a < field.length; a++) {
                for (int b = 0; b < field.length; b++) {
                    //Uzpildau masiva ir tikrinu ar jis nera matricos ribuose
                    if (a == 0) {
                        flagA = true;
                        iV[0] = a + 1;
                        iV[1] = a;
                    } else if (a == field.length - 1) {
                        flagA = true;
                        iV[0] = a - 1;
                        iV[1] = a;
                    } else {
                        flagA = false;
                        iV[0] = a - 1;
                        iV[1] = a;
                        iV[2] = a + 1;
                    }
                    if (b == 0) {
                        flagB = true;
                        jV[0] = b + 1;
                        jV[1] = b;
                    } else if (b == field.length - 1) {
                        flagB = true;
                        jV[0] = b - 1;
                        jV[1] = b;
                    } else {
                        flagB = false;
                        jV[0] = b - 1;
                        jV[1] = b;
                        jV[2] = b + 1;
                    }
                    count = 0;
                    for (int i = 0; i <= (flagA ? 1 : 2); i++) {
                        for (int j = 0; j <= (flagB ? 1 : 2); j++) {
                            if (field[iV[i]][jV[j]] == 'X' && ((i != 1) || (j != 1))) {
                                count += 1;
                            }
                        }
                    }
                    //KAMPU TIKRINIMAS
                    if (field[a][b] == '.' && count == 3) {
                        field2[a][b] = 'X';
                    } else if (field[a][b] == 'X' && (count == 3 || count == 2)) {
                        field2[a][b] = 'X';
                    } else if (field[a][b] == 'X' && (count > 3 || count < 2)) {
                        field2[a][b] = '.';
                    } else {
                        field2[a][b] = '.';
                    }
                }
            }
            /*if(field[i][j] == 'X'){
    } */
            /**
             * *************************print****************************
             */
            System.out.println("******************************");
            for (int i = 0; i < field2.length; i++) {
                for (int j = 0; j < field2.length; j++) {
                    System.out.print(field2[i][j] + " ");
                    field[i][j] = field2[i][j];
                }
                System.out.println();
            }
        }

    }
}
