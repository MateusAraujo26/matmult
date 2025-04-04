import java.util.Scanner;

class Matriz {
    int num_cols;
    int num_linhas;
    double[][] valores;

    public Matriz( int Nlinhas, int Ncols, double[][] Values) {
        num_linhas = Nlinhas;
        num_cols = Ncols;
        valores = Values;
    }

    public Matriz( int Nlinhas, int Ncols) {
        num_linhas = Nlinhas;
        num_cols = Ncols;
        valores = new double[Nlinhas][Ncols];
    }

    /* Lê e inicializa uma matriz de tamanho num_linhas * num_cols */
    public static Matriz leMatriz(int num_linhas, int num_cols, Scanner sc) {
        Matriz M = new Matriz(num_linhas, num_cols);
        for(int i=0;i<num_linhas;i++) {
            for(int j=0;j<num_cols;j++){
                double valor = sc.nextDouble();
                M.valores[i][j] = valor;
            }
        }
        return M;
    }

    /* Printa uma matriz M no termial */
    public static void exibeMatriz(Matriz M){
        for(int i=0;i<M.num_linhas;i++) {
            for(int j=0;j<M.num_cols;j++){
                System.out.print(M.valores[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* Multiplica duas matrizes A e B */
    public static Matriz matmult (Matriz A, Matriz B) {
        Matriz C = new Matriz(A.num_linhas, B.num_cols);
        for(int i=0;i<A.num_linhas;i++) {
            for(int j=0;j<B.num_cols;j++){
                for(int k=0;k<B.num_linhas; k++) {
                    C.valores[i][j] += A.valores[i][k] * B.valores[k][j];
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
        Matriz A = leMatriz(num_linhas_A, num_cols_A, sc);
        Matriz B = leMatriz(num_linhas_B, num_cols_B, sc);
        exibeMatriz(A);
        exibeMatriz(B);
        Matriz C = matmult(A, B);
        System.out.println("C =");
        exibeMatriz(C);
    }
}