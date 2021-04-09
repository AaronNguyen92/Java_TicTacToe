import java.util.ArrayList;
import java.util.List;


public class Board {
    public static final int NO_PLAYER = 0;//quy ước là ô còn trống
    public static final int PLAYER_X = 1;
    public static final int PLAYER_O = 2;
    private int[][] board = new int[3][3];
    public Point computerMove;//Tọa độ nước đi của máy tính
    
    public boolean isGameOver(){
        return hasPlayerWon(PLAYER_X) || hasPlayerWon(PLAYER_O) || getAvailableCells().isEmpty();
    }
    
    //kiểm tra người chơi có thắng hay không
    public boolean hasPlayerWon(int player) {
        if((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == player) ||
            (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == player)){
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == player) ||
                (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == player)){
                return true;
            }
        }
        return false;
    }
    
    //Trả về những ô còn trống, người chơi có thể đi được.
    public List<Point> getAvailableCells() {
        List<Point> availableCells = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == NO_PLAYER) {
                    availableCells.add(new Point(i, j));
                }
            }
        }
        
        return availableCells;
    }
    
    //Kiểm tra ô này có thể đi hay không, nếu không có nghĩa là ô này đã được đánh dấu trước đó
    public boolean placeAMove(Point point, int player){
        if(board[point.x][point.y] != NO_PLAYER){
            return false;
        }
        
        board[point.x][point.y] = player;
        return true;
    }
    
    
    public void displayBoard(){
        System.out.println();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String value = "?";
                if(board[i][j] == PLAYER_X){
                    value = "X";
                } 
                else if(board[i][j] == PLAYER_O){
                    value = "O";
                }
               System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    
    public int minimax(int depth, int turn){
        //Các điều kiện dừng
        if(hasPlayerWon(PLAYER_X)){
            return 1;
        }
        if(hasPlayerWon(PLAYER_O)){
            return -1;
        }
        
        List<Point> availableCells = getAvailableCells();
        
        if(availableCells.isEmpty()) 
            return 0;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        //Chạy qua hết 1 lần những ô còn trống để tính toán nước đi 
        for (int i = 0; i < availableCells.size(); i++) {
            Point point = availableCells.get(i);
            
            if (turn == PLAYER_X) {
                placeAMove(point, PLAYER_X);//Đánh dấu X trên bàn cờ
                int currentScore = minimax( depth + 1, PLAYER_O);
                max = Math.max(currentScore, max);
                
                if(depth == 0){
                    //System.out.println("Computer score for position " + point + " = " + currentScore);
                }
                
                //Lấy tọa độ của nước đi tốt nhất khi tìm được nó
                if(currentScore >= 0){
                    if(depth == 0)
                        computerMove = point;
                }
                
                //Đánh dấu nước đi tốt nhất đó trở lại thành trạng thái chưa được đánh dấu và thoát khỏi vòng lặp
                if(currentScore == 1){
                    board[point.x][point.y] = NO_PLAYER;
                    break;
                }
                
                //Duyệt qua hết các ô trống mà không tìm được nước đi tốt nhất
                if(i == availableCells.size()-1 && max<0){
                    if(depth == 0)
                        computerMove = point;
                }
            }
            else if(turn == PLAYER_O){
                placeAMove(point, PLAYER_O);
                int currentScore = minimax( depth + 1, PLAYER_X);
                min = Math.min(currentScore, min);
                
                if(min == -1){
                    board[point.x][point.y] = NO_PLAYER;
                    break;
                }
            }
            board[point.x][point.y] = NO_PLAYER;
        }
        return turn == PLAYER_X ? max : min;
    }
    
}
