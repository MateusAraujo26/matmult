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
    public void leMatriz(Scanner sc) {
        for(int i=0;i<num_linhas;i++) {
            for(int j=0;j<num_cols;j++){
                double valor = sc.nextDouble();
                valores[i][j] = valor;
            }
        }
    }

    /* Printa uma matriz M no termial */
    public void exibeMatriz(){
        for(int i=0;i<num_linhas;i++) {
            for(int j=0;j<num_cols;j++){
                System.out.print(valores[i][j] + " ");
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
        Matriz A = new Matriz(num_linhas_A, num_cols_A);
        A.leMatriz(sc);
        Matriz B = new Matriz(num_linhas_B, num_cols_B);
        B.leMatriz(sc);
        A.exibeMatriz();
        B.exibeMatriz();
        Matriz C = matmult(A, B);
        System.out.println("C =");
        C.exibeMatriz();
    }
}