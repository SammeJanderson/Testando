package joguinhos;

import java.lang.reflect.Array;
import java.util.*;

public class JogoDaVelha {

    public static String posi ="";
    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();


    public static void main(String[] args) {
        char[][] tabuleiro = {{' ','|',' ','|',' '},
                                {'-','+','-','+','-'},
                                {' ','|',' ','|',' '},
                                {'-','+','-','+','-'},
                                {' ','|',' ','|',' '}};

        desenharTabueleiro(tabuleiro);



        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite uma casa (1-9");
            int playerPos = scanner.nextInt();
            while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)){
                System.out.println("Posição invalida, encolha outra posição.");
                playerPos = scanner.nextInt();
            }


            placement(tabuleiro, playerPos, "player");
            String result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){
                System.out.println("Posição invalida, encolha outra posição.");
                playerPos = scanner.nextInt();
                cpuPos = rand.nextInt(9) + 1;
            }

            placement(tabuleiro, cpuPos, "CPU");


            desenharTabueleiro(tabuleiro);
             result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }

        }


    }

    public static void desenharTabueleiro(char[][] tabuleiro){

        for (char[] row :tabuleiro){
            for (char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placement(char[][] tabuleiro, int pos, String user){

        char symbol =' ';
        if (user.equals("player")){
            symbol = 'X';
            playerPositions.add(pos);
        }else if(user.equals("CPU")){
            symbol ='O';
            cpuPositions.add(pos);
        }


        switch (pos){
            case 1:
                tabuleiro[0][0] = symbol;
                break;
            case 2:
                tabuleiro[0][2] = symbol;

                break;
            case 3:
                tabuleiro[0][4] = symbol;

                break;
            case 4:
                tabuleiro[2][0] = symbol;

                break;
            case 5:
                tabuleiro[2][2] = symbol;

                break;
            case 6:
                tabuleiro[2][4] = symbol;

                break;
            case 7:
                tabuleiro[4][0] = symbol;

                break;
            case 8:
                tabuleiro[4][2] = symbol;

                break;
            case 9:
                tabuleiro[4][4] = symbol;

                break;
            default:
                break;
        }
    }

    public static String  checkWinner(){

        List topRow = Arrays.asList(1 ,2, 3);
        List middleRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);
        List leftCollum = Arrays.asList(1,4,7);
        List middleCollum = Arrays.asList(3,6,9);
        List rightCollum = Arrays.asList(3,6,9);
        List crossOne = Arrays.asList(1,5,9);
        List crossTwo = Arrays.asList(3,5,7);

        List<List> winConditions = new ArrayList<>();
        winConditions.add(topRow);
        winConditions.add(middleRow);
        winConditions.add(bottomRow);
        winConditions.add(leftCollum);
        winConditions.add(middleCollum);
        winConditions.add(rightCollum);
        winConditions.add(crossOne);
        winConditions.add(crossTwo);

        for(List l : winConditions){
            if(playerPositions.containsAll(l)){
                return "You Win";
            }else if(cpuPositions.containsAll(l)){
                return "You lose";
            }else if(playerPositions.size()+ cpuPositions.size() == 9){
                return "Drawn";

            }
        }
                return "";
    }
}
