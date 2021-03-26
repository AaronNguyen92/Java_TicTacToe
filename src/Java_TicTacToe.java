import java.awt.Color;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Java_TicTacToe extends javax.swing.JFrame {
    private String startGame = "X";//X bắt đầu trước
    private int xCount = 0;//biến đánh dấu số làn thắng của X
    private int oCount = 0;//biến đánh dấu số làn thắng của O
    private int choice = 2;//Choice = 1 là người chơi X, choice = 2 là người chơi O
    boolean checker, won = false, gameOver = false;
    public static final Random RANDOM = new Random();
    Board b = new Board();
    private String playMode = "", stringFirstPlay = "";

    public Java_TicTacToe() {
        initComponents();

        String mode[] = {"Normal", "AI"};
        JComboBox cb = new JComboBox(mode);

        int inp = JOptionPane.showConfirmDialog(this, cb, "Select mode", JOptionPane.DEFAULT_OPTION);
        if (inp == JOptionPane.OK_OPTION) {
            playMode = String.valueOf(cb.getSelectedItem());
        }

        if (playMode.equalsIgnoreCase("AI")) {
            JOptionPane.showMessageDialog(this, "Please choose which object to play firstly?\n"
                    + "1. Player\n2. Computer", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            String firstPlay[] = {"Player", "Computer"};
            JComboBox cb1 = new JComboBox(firstPlay);

            int inpIntFirstPlay = JOptionPane.showConfirmDialog(this, cb1, "Select player:", JOptionPane.DEFAULT_OPTION);

            if (inpIntFirstPlay == JOptionPane.OK_OPTION) {
                stringFirstPlay = String.valueOf(cb1.getSelectedItem());
            }

            //Nếu chọn chế độ chơi là AI thì X là quân cờ của Computer
            //X sẽ được chọn đi nước cờ đầu tiên 1 cách ngẫu nhiên
            int x = RANDOM.nextInt(3), y = RANDOM.nextInt(3);
            jlblPlayer1.setText("Computer:");
            jlblPlayer2.setText("Human:");

            if (stringFirstPlay.equalsIgnoreCase("Computer")) {
                choice = 1;
                startGame = "X";
            } else {
                choice = 2;
            }

            //Lấy vị trí nước cờ đầu tiên và hiển thị nó trên bàn cờ
            if (choice == Board.PLAYER_X) {
                Point p = new Point(x, y);
                b.placeAMove(p, Board.PLAYER_X);
                int z = 3 * x + y + 1;
                switch (z) {
                    case 1:
                        jbtnTic1.setText(startGame);
                        break;
                    case 2:
                        jbtnTic2.setText(startGame);
                        break;
                    case 3:
                        jbtnTic3.setText(startGame);
                        break;
                    case 4:
                        jbtnTic4.setText(startGame);
                        break;
                    case 5:
                        jbtnTic5.setText(startGame);
                        break;
                    case 6:
                        jbtnTic6.setText(startGame);
                        break;
                    case 7:
                        jbtnTic7.setText(startGame);
                        break;
                    case 8:
                        jbtnTic8.setText(startGame);
                        break;
                    case 9:
                        jbtnTic9.setText(startGame);
                        break;
                }
                startGame = "O";
            } else {
                startGame = "O";
            }

        } else {
            //Nếu người chơi chính chọn chế độ bình thường thì Combox chọn người hoặc máy chơi trước sẽ bị khóa
            jCBxSelect.setEnabled(false);
        }
    }

    private void gameScore() {
        jlblPlayerX.setText(String.valueOf(xCount));
        jlblPlayerO.setText(String.valueOf(oCount));
    }

    private void choose_a_Player() {
        if (startGame.equalsIgnoreCase("X")) {
            startGame = "O";
        } else {
            startGame = "X";
        }
    }

    //Phương thức xủ lý kết quả thắng cuộc của người chơi
    private void winningGame() {
        String b1 = jbtnTic1.getText();
        String b2 = jbtnTic2.getText();
        String b3 = jbtnTic3.getText();
        String b4 = jbtnTic4.getText();
        String b5 = jbtnTic5.getText();
        String b6 = jbtnTic6.getText();
        String b7 = jbtnTic7.getText();
        String b8 = jbtnTic8.getText();
        String b9 = jbtnTic9.getText();

        //Xét X (Màu xanh lá) thắng
        //Theo hàng ngang
        if ((b1 == "X") && (b2 == "X") && (b3 == "X")) {
            if (playMode.equalsIgnoreCase("Normal")) {
                JOptionPane.showMessageDialog(this, "Player X wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Computer wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            }
            jbtnTic1.setBackground(Color.GREEN);
            jbtnTic2.setBackground(Color.GREEN);
            jbtnTic3.setBackground(Color.GREEN);
            xCount++;
            gameScore();
            won = true;
            gameOver = true;
        } else if ((b4 == "X") && (b5 == "X") && (b6 == "X")) {
            if (playMode.equalsIgnoreCase("Normal")) {
                JOptionPane.showMessageDialog(this, "Player X wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Computer wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            }
            jbtnTic4.setBackground(Color.GREEN);
            jbtnTic5.setBackground(Color.GREEN);
            jbtnTic6.setBackground(Color.GREEN);
            xCount++;
            gameScore();
            won = true;
            gameOver = true;
        } else if ((b7 == "X") && (b8 == "X") && (b9 == "X")) {
            if (playMode.equalsIgnoreCase("Normal")) {
                JOptionPane.showMessageDialog(this, "Player X wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Computer wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            }
            jbtnTic7.setBackground(Color.GREEN);
            jbtnTic8.setBackground(Color.GREEN);
            jbtnTic9.setBackground(Color.GREEN);
            xCount++;
            gameScore();
            won = true;
            gameOver = true;
        } //Theo hàng dọc
        else if ((b1 == "X") && (b4 == "X") && (b7 == "X")) {
            if (playMode.equalsIgnoreCase("Normal")) {
                JOptionPane.showMessageDialog(this, "Player X wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Computer wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            }
            jbtnTic1.setBackground(Color.GREEN);
            jbtnTic4.setBackground(Color.GREEN);
            jbtnTic7.setBackground(Color.GREEN);
            xCount++;
            gameScore();
            won = true;
            gameOver = true;
        } else if ((b2 == "X") && (b5 == "X") && (b8 == "X")) {
            if (playMode.equalsIgnoreCase("Normal")) {
                JOptionPane.showMessageDialog(this, "Player X wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Computer wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            }
            jbtnTic2.setBackground(Color.GREEN);
            jbtnTic5.setBackground(Color.GREEN);
            jbtnTic8.setBackground(Color.GREEN);
            xCount++;
            gameScore();
            won = true;
            gameOver = true;
        } else if ((b3 == "X") && (b6 == "X") && (b9 == "X")) {
            if (playMode.equalsIgnoreCase("Normal")) {
                JOptionPane.showMessageDialog(this, "Player X wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Computer wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            }
            jbtnTic3.setBackground(Color.GREEN);
            jbtnTic6.setBackground(Color.GREEN);
            jbtnTic9.setBackground(Color.GREEN);
            xCount++;
            gameScore();
            won = true;
            gameOver = true;
        } //Theo đường chéo
        else if ((b1 == "X") && (b5 == "X") && (b9 == "X")) {
            if (playMode.equalsIgnoreCase("Normal")) {
                JOptionPane.showMessageDialog(this, "Player X wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Computer wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            }
            jbtnTic1.setBackground(Color.GREEN);
            jbtnTic5.setBackground(Color.GREEN);
            jbtnTic9.setBackground(Color.GREEN);
            xCount++;
            gameScore();
            won = true;
            gameOver = true;
        } else if ((b3 == "X") && (b5 == "X") && (b7 == "X")) {
            if (playMode.equalsIgnoreCase("Normal")) {
                JOptionPane.showMessageDialog(this, "Player X wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Computer wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            }
            jbtnTic3.setBackground(Color.GREEN);
            jbtnTic5.setBackground(Color.GREEN);
            jbtnTic7.setBackground(Color.GREEN);
            xCount++;
            gameScore();
            won = true;
            gameOver = true;
        }

        //Xét O(màu vàng) thắng
        //Theo hàng ngang
        if ((b1 == "O") && (b2 == "O") && (b3 == "O")) {
            if (playMode.equalsIgnoreCase("Normal")) {
                JOptionPane.showMessageDialog(this, "Player O wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Human wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            }
            jbtnTic1.setBackground(Color.YELLOW);
            jbtnTic2.setBackground(Color.YELLOW);
            jbtnTic3.setBackground(Color.YELLOW);
            oCount++;
            gameScore();
            won = true;
            gameOver = true;
        } else if ((b4 == "O") && (b5 == "O") && (b6 == "O")) {
            if (playMode.equalsIgnoreCase("Normal")) {
                JOptionPane.showMessageDialog(this, "Player O wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Human wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            }
            jbtnTic4.setBackground(Color.YELLOW);
            jbtnTic5.setBackground(Color.YELLOW);
            jbtnTic6.setBackground(Color.YELLOW);
            oCount++;
            gameScore();
            won = true;
            gameOver = true;
        } else if ((b7 == "O") && (b8 == "O") && (b9 == "O")) {
            if (playMode.equalsIgnoreCase("Normal")) {
                JOptionPane.showMessageDialog(this, "Player O wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Human wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            }
            jbtnTic7.setBackground(Color.YELLOW);
            jbtnTic8.setBackground(Color.YELLOW);
            jbtnTic9.setBackground(Color.YELLOW);
            oCount++;
            gameScore();
            won = true;
            gameOver = true;
        } //Theo hàng dọc
        else if ((b1 == "O") && (b4 == "O") && (b7 == "O")) {
            if (playMode.equalsIgnoreCase("Normal")) {
                JOptionPane.showMessageDialog(this, "Player O wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Human wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            }
            jbtnTic1.setBackground(Color.YELLOW);
            jbtnTic4.setBackground(Color.YELLOW);
            jbtnTic7.setBackground(Color.YELLOW);
            oCount++;
            gameScore();
            won = true;
            gameOver = true;
        } else if ((b2 == "O") && (b5 == "O") && (b8 == "O")) {
            if (playMode.equalsIgnoreCase("Normal")) {
                JOptionPane.showMessageDialog(this, "Player O wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Human wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            }
            jbtnTic2.setBackground(Color.YELLOW);
            jbtnTic5.setBackground(Color.YELLOW);
            jbtnTic8.setBackground(Color.YELLOW);
            oCount++;
            gameScore();
            won = true;
            gameOver = true;
        } else if ((b3 == "O") && (b6 == "O") && (b9 == "O")) {
            if (playMode.equalsIgnoreCase("Normal")) {
                JOptionPane.showMessageDialog(this, "Player O wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Human wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            }
            jbtnTic3.setBackground(Color.YELLOW);
            jbtnTic6.setBackground(Color.YELLOW);
            jbtnTic9.setBackground(Color.YELLOW);
            oCount++;
            gameScore();
            won = true;
            gameOver = true;
        } //Theo đường chéo
        else if ((b1 == "O") && (b5 == "O") && (b9 == "O")) {
            if (playMode.equalsIgnoreCase("Normal")) {
                JOptionPane.showMessageDialog(this, "Player O wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Human wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            }
            jbtnTic1.setBackground(Color.YELLOW);
            jbtnTic5.setBackground(Color.YELLOW);
            jbtnTic9.setBackground(Color.YELLOW);
            oCount++;
            gameScore();
            won = true;
            gameOver = true;
        } else if ((b3 == "O") && (b5 == "O") && (b7 == "O")) {
            if (playMode.equalsIgnoreCase("Normal")) {
                JOptionPane.showMessageDialog(this, "Player O wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Human wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            }
            jbtnTic3.setBackground(Color.YELLOW);
            jbtnTic5.setBackground(Color.YELLOW);
            jbtnTic7.setBackground(Color.YELLOW);
            oCount++;
            gameScore();
            won = true;
            gameOver = true;
        }

        //Xét trường hợp hòa
        if ((b1 != "") && (b2 != "") && (b3 != "") && (b4 != "") && (b5 != "") && (b6 != "")
                && (b7 != "") && (b8 != "") && (b9 != "") && (won == false)) {
            JOptionPane.showMessageDialog(this, "Draw!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            gameOver = true;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jbtnTic1 = new javax.swing.JButton();
        jbtnTic2 = new javax.swing.JButton();
        jbtnTic3 = new javax.swing.JButton();
        jbtnTic4 = new javax.swing.JButton();
        jbtnTic5 = new javax.swing.JButton();
        jbtnTic6 = new javax.swing.JButton();
        jbtnTic7 = new javax.swing.JButton();
        jbtnTic8 = new javax.swing.JButton();
        jbtnTic9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jlblPlayerO = new javax.swing.JLabel();
        jlblPlayer2 = new javax.swing.JLabel();
        jlblPlayerX = new javax.swing.JLabel();
        jlblPlayer1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jbtnNewGame = new javax.swing.JButton();
        jbtnReset = new javax.swing.JButton();
        jbtnExit = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jCBxSelect = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1030, 590));
        jPanel1.setPreferredSize(new java.awt.Dimension(1030, 590));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jbtnTic1.setBackground(java.awt.Color.white);
        jbtnTic1.setFont(new java.awt.Font("Tahoma", 1, 96)); // NOI18N
        jbtnTic1.setMaximumSize(new java.awt.Dimension(150, 150));
        jbtnTic1.setMinimumSize(new java.awt.Dimension(200, 158));
        jbtnTic1.setPreferredSize(new java.awt.Dimension(150, 150));
        jbtnTic1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic1ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnTic1);

        jbtnTic2.setBackground(java.awt.Color.white);
        jbtnTic2.setFont(new java.awt.Font("Tahoma", 1, 96)); // NOI18N
        jbtnTic2.setMaximumSize(new java.awt.Dimension(150, 150));
        jbtnTic2.setMinimumSize(new java.awt.Dimension(150, 150));
        jbtnTic2.setPreferredSize(new java.awt.Dimension(150, 150));
        jbtnTic2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic2ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnTic2);

        jbtnTic3.setBackground(java.awt.Color.white);
        jbtnTic3.setFont(new java.awt.Font("Tahoma", 1, 96)); // NOI18N
        jbtnTic3.setMaximumSize(new java.awt.Dimension(150, 150));
        jbtnTic3.setMinimumSize(new java.awt.Dimension(150, 150));
        jbtnTic3.setName(""); // NOI18N
        jbtnTic3.setPreferredSize(new java.awt.Dimension(150, 150));
        jbtnTic3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic3ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnTic3);

        jbtnTic4.setBackground(java.awt.Color.white);
        jbtnTic4.setFont(new java.awt.Font("Tahoma", 1, 96)); // NOI18N
        jbtnTic4.setMaximumSize(new java.awt.Dimension(150, 150));
        jbtnTic4.setMinimumSize(new java.awt.Dimension(150, 150));
        jbtnTic4.setPreferredSize(new java.awt.Dimension(150, 150));
        jbtnTic4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic4ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnTic4);

        jbtnTic5.setBackground(java.awt.Color.white);
        jbtnTic5.setFont(new java.awt.Font("Tahoma", 1, 96)); // NOI18N
        jbtnTic5.setMaximumSize(new java.awt.Dimension(150, 150));
        jbtnTic5.setMinimumSize(new java.awt.Dimension(150, 150));
        jbtnTic5.setPreferredSize(new java.awt.Dimension(150, 150));
        jbtnTic5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic5ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnTic5);

        jbtnTic6.setBackground(java.awt.Color.white);
        jbtnTic6.setFont(new java.awt.Font("Tahoma", 1, 96)); // NOI18N
        jbtnTic6.setMaximumSize(new java.awt.Dimension(150, 150));
        jbtnTic6.setMinimumSize(new java.awt.Dimension(150, 150));
        jbtnTic6.setPreferredSize(new java.awt.Dimension(150, 150));
        jbtnTic6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic6ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnTic6);

        jbtnTic7.setBackground(java.awt.Color.white);
        jbtnTic7.setFont(new java.awt.Font("Tahoma", 1, 96)); // NOI18N
        jbtnTic7.setMaximumSize(new java.awt.Dimension(150, 150));
        jbtnTic7.setMinimumSize(new java.awt.Dimension(150, 150));
        jbtnTic7.setPreferredSize(new java.awt.Dimension(150, 150));
        jbtnTic7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic7ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnTic7);

        jbtnTic8.setBackground(java.awt.Color.white);
        jbtnTic8.setFont(new java.awt.Font("Tahoma", 1, 96)); // NOI18N
        jbtnTic8.setMaximumSize(new java.awt.Dimension(150, 150));
        jbtnTic8.setMinimumSize(new java.awt.Dimension(150, 150));
        jbtnTic8.setPreferredSize(new java.awt.Dimension(150, 150));
        jbtnTic8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic8ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnTic8);

        jbtnTic9.setBackground(java.awt.Color.white);
        jbtnTic9.setFont(new java.awt.Font("Tahoma", 1, 96)); // NOI18N
        jbtnTic9.setMaximumSize(new java.awt.Dimension(150, 150));
        jbtnTic9.setMinimumSize(new java.awt.Dimension(150, 150));
        jbtnTic9.setPreferredSize(new java.awt.Dimension(150, 150));
        jbtnTic9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTic9ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnTic9);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 480, 480));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(153, 153, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblPlayerO.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jlblPlayerO.setForeground(new java.awt.Color(255, 0, 0));
        jlblPlayerO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblPlayerO.setText("0");
        jPanel7.add(jlblPlayerO, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 160, 70));

        jlblPlayer2.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jlblPlayer2.setText("Player O:");
        jPanel7.add(jlblPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 280, 70));

        jlblPlayerX.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jlblPlayerX.setForeground(new java.awt.Color(255, 0, 0));
        jlblPlayerX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblPlayerX.setText("0");
        jPanel7.add(jlblPlayerX, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 160, 70));

        jlblPlayer1.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jlblPlayer1.setText("Player X:");
        jPanel7.add(jlblPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 280, 70));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 500, 240));

        jPanel8.setBackground(new java.awt.Color(153, 153, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnNewGame.setBackground(new java.awt.Color(255, 255, 255));
        jbtnNewGame.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jbtnNewGame.setForeground(new java.awt.Color(0, 204, 0));
        jbtnNewGame.setText("New Game");
        jbtnNewGame.setMaximumSize(new java.awt.Dimension(200, 158));
        jbtnNewGame.setMinimumSize(new java.awt.Dimension(200, 158));
        jbtnNewGame.setPreferredSize(new java.awt.Dimension(200, 180));
        jbtnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNewGameActionPerformed(evt);
            }
        });
        jPanel8.add(jbtnNewGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 280, 70));

        jbtnReset.setBackground(new java.awt.Color(255, 255, 255));
        jbtnReset.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jbtnReset.setForeground(new java.awt.Color(0, 204, 0));
        jbtnReset.setText("Reset");
        jbtnReset.setMaximumSize(new java.awt.Dimension(200, 158));
        jbtnReset.setMinimumSize(new java.awt.Dimension(200, 158));
        jbtnReset.setPreferredSize(new java.awt.Dimension(200, 180));
        jbtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnResetActionPerformed(evt);
            }
        });
        jPanel8.add(jbtnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 150, 60));

        jbtnExit.setBackground(new java.awt.Color(255, 255, 255));
        jbtnExit.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jbtnExit.setForeground(new java.awt.Color(0, 204, 0));
        jbtnExit.setText("Exit");
        jbtnExit.setMaximumSize(new java.awt.Dimension(200, 158));
        jbtnExit.setMinimumSize(new java.awt.Dimension(200, 158));
        jbtnExit.setPreferredSize(new java.awt.Dimension(200, 180));
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
            }
        });
        jPanel8.add(jbtnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 110, 60));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 300, 210));

        jPanel10.setBackground(new java.awt.Color(153, 153, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCBxSelect.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jCBxSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Player", "Computer" }));
        jCBxSelect.setOpaque(false);
        jCBxSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBxSelectActionPerformed(evt);
            }
        });
        jPanel10.add(jCBxSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 170, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Choose:");
        jPanel10.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 190, 210));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 520, 480));

        jPanel9.setBackground(new java.awt.Color(153, 153, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 66)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tic Tac Toe Game");
        jPanel9.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 590, 70));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1010, 80));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private JFrame frame;

    //Xử lý nút New Game khởi tạo lại tất cả về trạng thái ban đầu
    private void jbtnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNewGameActionPerformed
        jbtnTic1.setEnabled(true);
        jbtnTic2.setEnabled(true);
        jbtnTic3.setEnabled(true);
        jbtnTic4.setEnabled(true);
        jbtnTic5.setEnabled(true);
        jbtnTic6.setEnabled(true);
        jbtnTic7.setEnabled(true);
        jbtnTic8.setEnabled(true);
        jbtnTic9.setEnabled(true);

        xCount = 0;
        oCount = 0;
        jlblPlayerX.setText("0");
        jlblPlayerO.setText("0");

        jbtnTic1.setText("");
        jbtnTic2.setText("");
        jbtnTic3.setText("");
        jbtnTic4.setText("");
        jbtnTic5.setText("");
        jbtnTic6.setText("");
        jbtnTic7.setText("");
        jbtnTic8.setText("");
        jbtnTic9.setText("");

        jbtnTic1.setBackground(Color.WHITE);
        jbtnTic2.setBackground(Color.WHITE);
        jbtnTic3.setBackground(Color.WHITE);
        jbtnTic4.setBackground(Color.WHITE);
        jbtnTic5.setBackground(Color.WHITE);
        jbtnTic6.setBackground(Color.WHITE);
        jbtnTic7.setBackground(Color.WHITE);
        jbtnTic8.setBackground(Color.WHITE);
        jbtnTic9.setBackground(Color.WHITE);

        won = false;
        gameOver = false;

        if (playMode.equalsIgnoreCase("AI")) {
            b = new Board();

            int x = RANDOM.nextInt(3), y = RANDOM.nextInt(3);

            if (String.valueOf(jCBxSelect.getSelectedItem()).equalsIgnoreCase("Computer")
                    || (stringFirstPlay.equalsIgnoreCase("Computer"))) {
                choice = 1;
                startGame = "X";
            } else {
                choice = 2;
            }

            if (choice == Board.PLAYER_X) {
                Point p = new Point(x, y);
                b.placeAMove(p, Board.PLAYER_X);
                int z = 3 * x + y + 1;
                switch (z) {
                    case 1:
                        jbtnTic1.setText(startGame);
                        break;
                    case 2:
                        jbtnTic2.setText(startGame);
                        break;
                    case 3:
                        jbtnTic3.setText(startGame);
                        break;
                    case 4:
                        jbtnTic4.setText(startGame);
                        break;
                    case 5:
                        jbtnTic5.setText(startGame);
                        break;
                    case 6:
                        jbtnTic6.setText(startGame);
                        break;
                    case 7:
                        jbtnTic7.setText(startGame);
                        break;
                    case 8:
                        jbtnTic8.setText(startGame);
                        break;
                    case 9:
                        jbtnTic9.setText(startGame);
                        break;
                }
                startGame = "O";
            } else {
                startGame = "O";
            }
        }


    }//GEN-LAST:event_jbtnNewGameActionPerformed

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit?", "Tic Tac Toe", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_NO_OPTION)
            System.exit(0);
    }//GEN-LAST:event_jbtnExitActionPerformed

    private void jbtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnResetActionPerformed
        jbtnTic1.setEnabled(true);
        jbtnTic2.setEnabled(true);
        jbtnTic3.setEnabled(true);
        jbtnTic4.setEnabled(true);
        jbtnTic5.setEnabled(true);
        jbtnTic6.setEnabled(true);
        jbtnTic7.setEnabled(true);
        jbtnTic8.setEnabled(true);
        jbtnTic9.setEnabled(true);

        jbtnTic1.setText("");
        jbtnTic2.setText("");
        jbtnTic3.setText("");
        jbtnTic4.setText("");
        jbtnTic5.setText("");
        jbtnTic6.setText("");
        jbtnTic7.setText("");
        jbtnTic8.setText("");
        jbtnTic9.setText("");

        jbtnTic1.setBackground(Color.WHITE);
        jbtnTic2.setBackground(Color.WHITE);
        jbtnTic3.setBackground(Color.WHITE);
        jbtnTic4.setBackground(Color.WHITE);
        jbtnTic5.setBackground(Color.WHITE);
        jbtnTic6.setBackground(Color.WHITE);
        jbtnTic7.setBackground(Color.WHITE);
        jbtnTic8.setBackground(Color.WHITE);
        jbtnTic9.setBackground(Color.WHITE);

        b = new Board();

        won = false;
        gameOver = false;

        if (playMode.equalsIgnoreCase("AI")) {
            int x = RANDOM.nextInt(3), y = RANDOM.nextInt(3);

            if (String.valueOf(jCBxSelect.getSelectedItem()).equalsIgnoreCase("Computer")
                    || (stringFirstPlay.equalsIgnoreCase("Computer"))) {
                choice = 1;
                startGame = "X";
            } else {
                choice = 2;
            }

            if (choice == Board.PLAYER_X) {
                Point p = new Point(x, y);
                b.placeAMove(p, Board.PLAYER_X);
                int z = 3 * x + y + 1;
                switch (z) {
                    case 1:
                        jbtnTic1.setText(startGame);
                        break;
                    case 2:
                        jbtnTic2.setText(startGame);
                        break;
                    case 3:
                        jbtnTic3.setText(startGame);
                        break;
                    case 4:
                        jbtnTic4.setText(startGame);
                        break;
                    case 5:
                        jbtnTic5.setText(startGame);
                        break;
                    case 6:
                        jbtnTic6.setText(startGame);
                        break;
                    case 7:
                        jbtnTic7.setText(startGame);
                        break;
                    case 8:
                        jbtnTic8.setText(startGame);
                        break;
                    case 9:
                        jbtnTic9.setText(startGame);
                        break;
                }
                startGame = "O";
            } else {
                startGame = "O";
            }
        }

    }//GEN-LAST:event_jbtnResetActionPerformed

    private void jbtnTic1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic1ActionPerformed
        jbtnTic1.setText(startGame);

        if (playMode.equalsIgnoreCase("AI")) {
            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
                startGame = "O";
            } else {
                checker = true;
                b.placeAMove(new Point(0, 0), Board.PLAYER_O);
                startGame = "X";
                b.minimax(0, Board.PLAYER_X);
                int d = b.computerMove.x; //Lấy giá trị chỉ số x của computer vừa tìm được 
                int e = b.computerMove.y;//Lấy giá trị chỉ số y của computer vừa tìm được 
                int f = d * 3 + e + 1;//Tính toán tọa độ của Computer trên bàn cờ vựa vào x và y
                switch (f) {
                    case 1:
                        jbtnTic1.setText(startGame);
                        break;
                    case 2:
                        jbtnTic2.setText(startGame);
                        break;
                    case 3:
                        jbtnTic3.setText(startGame);
                        break;
                    case 4:
                        jbtnTic4.setText(startGame);
                        break;
                    case 5:
                        jbtnTic5.setText(startGame);
                        break;
                    case 6:
                        jbtnTic6.setText(startGame);
                        break;
                    case 7:
                        jbtnTic7.setText(startGame);
                        break;
                    case 8:
                        jbtnTic8.setText(startGame);
                        break;
                    case 9:
                        jbtnTic9.setText(startGame);
                        break;
                }
                b.placeAMove(b.computerMove, Board.PLAYER_X);
                startGame = "O";
            }
            winningGame();
        } else {
            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
            } else {
                checker = true;
            }

            choose_a_Player();
            winningGame();

        }

    }//GEN-LAST:event_jbtnTic1ActionPerformed

    private void jbtnTic2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic2ActionPerformed
        jbtnTic2.setText(startGame);

        if (playMode.equalsIgnoreCase("AI")) {
            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
                startGame = "O";
            } else {
                checker = true;
                b.placeAMove(new Point(0, 1), Board.PLAYER_O);
                startGame = "X";
                b.minimax(0, Board.PLAYER_X);
                int d = b.computerMove.x;
                int e = b.computerMove.y;
                int f = d * 3 + e + 1;
                switch (f) {
                    case 1:
                        jbtnTic1.setText(startGame);
                        break;
                    case 2:
                        jbtnTic2.setText(startGame);
                        break;
                    case 3:
                        jbtnTic3.setText(startGame);
                        break;
                    case 4:
                        jbtnTic4.setText(startGame);
                        break;
                    case 5:
                        jbtnTic5.setText(startGame);
                        break;
                    case 6:
                        jbtnTic6.setText(startGame);
                        break;
                    case 7:
                        jbtnTic7.setText(startGame);
                        break;
                    case 8:
                        jbtnTic8.setText(startGame);
                        break;
                    case 9:
                        jbtnTic9.setText(startGame);
                        break;
                }
                b.placeAMove(b.computerMove, Board.PLAYER_X);
                startGame = "O";
            }
            //choose_a_Player();
            winningGame();
        } else {
            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
            } else {
                checker = true;
            }

            choose_a_Player();
            winningGame();
        }


    }//GEN-LAST:event_jbtnTic2ActionPerformed

    private void jbtnTic3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic3ActionPerformed
        jbtnTic3.setText(startGame);

        if (playMode.equalsIgnoreCase("AI")) {
            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
                startGame = "O";
            } else {
                checker = true;
                b.placeAMove(new Point(0, 2), Board.PLAYER_O);
                startGame = "X";
                b.minimax(0, Board.PLAYER_X);
                int d = b.computerMove.x;
                int e = b.computerMove.y;
                int f = d * 3 + e + 1;
                switch (f) {
                    case 1:
                        jbtnTic1.setText(startGame);
                        break;
                    case 2:
                        jbtnTic2.setText(startGame);
                        break;
                    case 3:
                        jbtnTic3.setText(startGame);
                        break;
                    case 4:
                        jbtnTic4.setText(startGame);
                        break;
                    case 5:
                        jbtnTic5.setText(startGame);
                        break;
                    case 6:
                        jbtnTic6.setText(startGame);
                        break;
                    case 7:
                        jbtnTic7.setText(startGame);
                        break;
                    case 8:
                        jbtnTic8.setText(startGame);
                        break;
                    case 9:
                        jbtnTic9.setText(startGame);
                        break;
                }
                b.placeAMove(b.computerMove, Board.PLAYER_X);
                startGame = "O";
            }
            //choose_a_Player();
            winningGame();
        } else {
            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
            } else {
                checker = true;
            }

            choose_a_Player();
            winningGame();
        }

    }//GEN-LAST:event_jbtnTic3ActionPerformed

    private void jbtnTic4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic4ActionPerformed
        jbtnTic4.setText(startGame);

        if (playMode.equalsIgnoreCase("AI")) {
            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
                startGame = "O";
            } else {

                checker = true;
                b.placeAMove(new Point(1, 0), Board.PLAYER_O);
                startGame = "X";
                b.minimax(0, Board.PLAYER_X);
                int d = b.computerMove.x;
                int e = b.computerMove.y;
                int f = d * 3 + e + 1;
                switch (f) {
                    case 1:
                        jbtnTic1.setText(startGame);
                        break;
                    case 2:
                        jbtnTic2.setText(startGame);
                        break;
                    case 3:
                        jbtnTic3.setText(startGame);
                        break;
                    case 4:
                        jbtnTic4.setText(startGame);
                        break;
                    case 5:
                        jbtnTic5.setText(startGame);
                        break;
                    case 6:
                        jbtnTic6.setText(startGame);
                        break;
                    case 7:
                        jbtnTic7.setText(startGame);
                        break;
                    case 8:
                        jbtnTic8.setText(startGame);
                        break;
                    case 9:
                        jbtnTic9.setText(startGame);
                        break;
                }
                b.placeAMove(b.computerMove, Board.PLAYER_X);
                startGame = "O";
            }
            //choose_a_Player();
            winningGame();
        } else {
            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
            } else {
                checker = true;
            }

            choose_a_Player();
            winningGame();
        }


    }//GEN-LAST:event_jbtnTic4ActionPerformed

    private void jbtnTic5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic5ActionPerformed
        jbtnTic5.setText(startGame);

        if (playMode.equalsIgnoreCase("AI")) {
            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
                startGame = "O";
            } else {
                checker = true;
                b.placeAMove(new Point(1, 1), Board.PLAYER_O);
                startGame = "X";
                b.minimax(0, Board.PLAYER_X);
                int d = b.computerMove.x;
                int e = b.computerMove.y;
                int f = d * 3 + e + 1;
                switch (f) {
                    case 1:
                        jbtnTic1.setText(startGame);
                        break;
                    case 2:
                        jbtnTic2.setText(startGame);
                        break;
                    case 3:
                        jbtnTic3.setText(startGame);
                        break;
                    case 4:
                        jbtnTic4.setText(startGame);
                        break;
                    case 5:
                        jbtnTic5.setText(startGame);
                        break;
                    case 6:
                        jbtnTic6.setText(startGame);
                        break;
                    case 7:
                        jbtnTic7.setText(startGame);
                        break;
                    case 8:
                        jbtnTic8.setText(startGame);
                        break;
                    case 9:
                        jbtnTic9.setText(startGame);
                        break;
                }
                b.placeAMove(b.computerMove, Board.PLAYER_X);
                startGame = "O";
            }
            //choose_a_Player();
            winningGame();
        } else {
            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
            } else {
                checker = true;
            }

            choose_a_Player();
            winningGame();
        }

    }//GEN-LAST:event_jbtnTic5ActionPerformed

    private void jbtnTic6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic6ActionPerformed
        jbtnTic6.setText(startGame);

        if (playMode.equalsIgnoreCase("AI")) {
            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
                startGame = "O";
            } else {
                checker = true;
                b.placeAMove(new Point(1, 2), Board.PLAYER_O);
                startGame = "X";
                b.minimax(0, Board.PLAYER_X);
                int d = b.computerMove.x;
                int e = b.computerMove.y;
                int f = d * 3 + e + 1;
                switch (f) {
                    case 1:
                        jbtnTic1.setText(startGame);
                        break;
                    case 2:
                        jbtnTic2.setText(startGame);
                        break;
                    case 3:
                        jbtnTic3.setText(startGame);
                        break;
                    case 4:
                        jbtnTic4.setText(startGame);
                        break;
                    case 5:
                        jbtnTic5.setText(startGame);
                        break;
                    case 6:
                        jbtnTic6.setText(startGame);
                        break;
                    case 7:
                        jbtnTic7.setText(startGame);
                        break;
                    case 8:
                        jbtnTic8.setText(startGame);
                        break;
                    case 9:
                        jbtnTic9.setText(startGame);
                        break;
                }
                b.placeAMove(b.computerMove, Board.PLAYER_X);
                startGame = "O";
            }
            //choose_a_Player();
            winningGame();
        } else {
            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
            } else {
                checker = true;
            }

            choose_a_Player();
            winningGame();
        }

    }//GEN-LAST:event_jbtnTic6ActionPerformed

    private void jbtnTic7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic7ActionPerformed
        jbtnTic7.setText(startGame);

        if (playMode.equalsIgnoreCase("AI")) {
            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
                startGame = "O";
            } else {
                checker = true;
                b.placeAMove(new Point(2, 0), Board.PLAYER_O);
                startGame = "X";
                b.minimax(0, Board.PLAYER_X);
                int d = b.computerMove.x;
                int e = b.computerMove.y;
                int f = d * 3 + e + 1;
                switch (f) {
                    case 1:
                        jbtnTic1.setText(startGame);
                        break;
                    case 2:
                        jbtnTic2.setText(startGame);
                        break;
                    case 3:
                        jbtnTic3.setText(startGame);
                        break;
                    case 4:
                        jbtnTic4.setText(startGame);
                        break;
                    case 5:
                        jbtnTic5.setText(startGame);
                        break;
                    case 6:
                        jbtnTic6.setText(startGame);
                        break;
                    case 7:
                        jbtnTic7.setText(startGame);
                        break;
                    case 8:
                        jbtnTic8.setText(startGame);
                        break;
                    case 9:
                        jbtnTic9.setText(startGame);
                        break;
                }
                b.placeAMove(b.computerMove, Board.PLAYER_X);
                startGame = "O";
            }
            // choose_a_Player();
            winningGame();
        } else {
            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
            } else {
                checker = true;
            }

            choose_a_Player();
            winningGame();
        }


    }//GEN-LAST:event_jbtnTic7ActionPerformed

    private void jbtnTic8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic8ActionPerformed
        jbtnTic8.setText(startGame);

        if (playMode.equalsIgnoreCase("AI")) {
            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
                startGame = "O";
            } else {
                checker = true;
                b.placeAMove(new Point(2, 1), Board.PLAYER_O);
                startGame = "X";
                b.minimax(0, Board.PLAYER_X);
                int d = b.computerMove.x;
                int e = b.computerMove.y;
                int f = d * 3 + e + 1;
                switch (f) {
                    case 1:
                        jbtnTic1.setText(startGame);
                        break;
                    case 2:
                        jbtnTic2.setText(startGame);
                        break;
                    case 3:
                        jbtnTic3.setText(startGame);
                        break;
                    case 4:
                        jbtnTic4.setText(startGame);
                        break;
                    case 5:
                        jbtnTic5.setText(startGame);
                        break;
                    case 6:
                        jbtnTic6.setText(startGame);
                        break;
                    case 7:
                        jbtnTic7.setText(startGame);
                        break;
                    case 8:
                        jbtnTic8.setText(startGame);
                        break;
                    case 9:
                        jbtnTic9.setText(startGame);
                        break;
                }
                b.placeAMove(b.computerMove, Board.PLAYER_X);
                startGame = "O";
            }
            //choose_a_Player();
            winningGame();
        } else {
            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
            } else {
                checker = true;
            }

            choose_a_Player();
            winningGame();
        }

    }//GEN-LAST:event_jbtnTic8ActionPerformed

    private void jbtnTic9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTic9ActionPerformed
        jbtnTic9.setText(startGame);

        if (playMode.equalsIgnoreCase("AI")) {
            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
                startGame = "O";
            } else {
                checker = true;
                b.placeAMove(new Point(2, 2), Board.PLAYER_O);
                startGame = "X";
                b.minimax(0, Board.PLAYER_X);
                int d = b.computerMove.x;
                int e = b.computerMove.y;
                int f = d * 3 + e + 1;
                switch (f) {
                    case 1:
                        jbtnTic1.setText(startGame);
                        break;
                    case 2:
                        jbtnTic2.setText(startGame);
                        break;
                    case 3:
                        jbtnTic3.setText(startGame);
                        break;
                    case 4:
                        jbtnTic4.setText(startGame);
                        break;
                    case 5:
                        jbtnTic5.setText(startGame);
                        break;
                    case 6:
                        jbtnTic6.setText(startGame);
                        break;
                    case 7:
                        jbtnTic7.setText(startGame);
                        break;
                    case 8:
                        jbtnTic8.setText(startGame);
                        break;
                    case 9:
                        jbtnTic9.setText(startGame);
                        break;
                }
                b.placeAMove(b.computerMove, Board.PLAYER_X);
                startGame = "O";
            }
            //choose_a_Player();
            winningGame();
        } else {
            if (startGame.equalsIgnoreCase("X")) {
                checker = false;
            } else {
                checker = true;
            }

            choose_a_Player();
            winningGame();
        }

    }//GEN-LAST:event_jbtnTic9ActionPerformed

    private void jCBxSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBxSelectActionPerformed
        int x = RANDOM.nextInt(3), y = RANDOM.nextInt(3);
        jlblPlayer1.setText("Computer:");
        jlblPlayer2.setText("Human:");

        if (String.valueOf(jCBxSelect.getSelectedItem()).equalsIgnoreCase("Computer")
                && (!gameOver)) {
            choice = 1;
            startGame = "X";
            stringFirstPlay = "Computer";
        } else {
            choice = 2;
            stringFirstPlay = "Player";
        }

        if (choice == Board.PLAYER_X) {
            Point p = new Point(x, y);
            b.placeAMove(p, Board.PLAYER_X);
            int z = 3 * x + y + 1;
            switch (z) {
                case 1:
                    jbtnTic1.setText(startGame);
                    break;
                case 2:
                    jbtnTic2.setText(startGame);
                    break;
                case 3:
                    jbtnTic3.setText(startGame);
                    break;
                case 4:
                    jbtnTic4.setText(startGame);
                    break;
                case 5:
                    jbtnTic5.setText(startGame);
                    break;
                case 6:
                    jbtnTic6.setText(startGame);
                    break;
                case 7:
                    jbtnTic7.setText(startGame);
                    break;
                case 8:
                    jbtnTic8.setText(startGame);
                    break;
                case 9:
                    jbtnTic9.setText(startGame);
                    break;
            }
            startGame = "O";
        } else {
            startGame = "O";
        }

    }//GEN-LAST:event_jCBxSelectActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Java_TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Java_TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Java_TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Java_TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Java_TicTacToe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCBxSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbtnExit;
    private javax.swing.JButton jbtnNewGame;
    private javax.swing.JButton jbtnReset;
    private javax.swing.JButton jbtnTic1;
    private javax.swing.JButton jbtnTic2;
    private javax.swing.JButton jbtnTic3;
    private javax.swing.JButton jbtnTic4;
    private javax.swing.JButton jbtnTic5;
    private javax.swing.JButton jbtnTic6;
    private javax.swing.JButton jbtnTic7;
    private javax.swing.JButton jbtnTic8;
    private javax.swing.JButton jbtnTic9;
    private javax.swing.JLabel jlblPlayer1;
    private javax.swing.JLabel jlblPlayer2;
    private javax.swing.JLabel jlblPlayerO;
    private javax.swing.JLabel jlblPlayerX;
    // End of variables declaration//GEN-END:variables
}
