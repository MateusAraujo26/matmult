import java.util.Scanner;

class Matriz {
    /* Lê e inicializa uma matriz de tamanho num_linhas * num_cols */
    public static double[][] leMatriz(int num_linhas, int num_cols, Scanner sc) {
        double[][] M = new double[num_linhas][num_cols];
        for(int i=0;i<num_linhas;i++) {
            for(int j=0;j<num_cols;j++){
                double valor = sc.nextDouble();
                M[i][j] = valor;
            }
        }
        return M;
    }

    public static void exibeMatriz(double[][] M){
        int num_linhas = M.length;
        int num_cols = M[0].length;
        for(int i=0;i<num_linhas;i++) {
            for(int j=0;j<num_cols;j++){
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static double[][] matmult (double[][] A, double[][] B) {
        int num_linhas = A.length;
        int num_cols = B[0].length;
        double[][] C = new double[num_linhas][num_cols];
        for(int i=0;i<num_linhas;i++) {
            for(int j=0;j<num_cols;j++){
                for(int k=0;k<B.length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Use: java Matriz.java num_linhas_A num_cols_A num_linhas_B num_cols_B");
            return;
        }
        int num_linhas_A = Integer.parseInt(args[0]);
        int num_cols_A = Integer.parseInt(args[1]);
        int num_linhas_B = Integer.parseInt(args[2]);
        int num_cols_B = Integer.parseInt(args[3]);

        Scanner sc = new Scanner(System.in);
        double[][] A = leMatriz(num_linhas_A, num_cols_A, sc);
        double[][] B = leMatriz(num_linhas_B, num_cols_B, sc);
        exibeMatriz(A);
        exibeMatriz(B);
        double [][] C = matmult(A, B);
        System.out.println("C =");
        exibeMatriz(C);
    }
}