import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        new Launch();
    }
}

class Launch implements ActionListener{

    JFrame frame1;
    JLabel label;
    JPanel panel1;
    JButton Start;

    Launch(){
        frame1= new JFrame();
        frame1.setTitle("Prisha's TicTacToe Game");
        frame1.setSize(420, 420);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setLocationRelativeTo(null);

        panel1= new JPanel();
        panel1.setBackground(new Color(250,255,150));
        panel1.setLayout(null);
        label= new JLabel("TicTacToe Game");
        label.setFont(new Font("Courier new",Font.BOLD,40));
        label.setForeground(Color.RED);
        label.setBounds(30,50,400,90);
        Start= new JButton();
        Start.setText("Start!");
        Start.setBounds(150,200,100,50);
        Start.addActionListener(this);

        panel1.add(label);
        panel1.add(Start);
        frame1.add(panel1);
        frame1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== Start){
            new MyFrame();
            frame1.dispose();
        }
    }
}

class MyFrame implements ActionListener {
    JFrame winner;
    JFrame frame;
    JPanel panel;
    JButton button[]= new JButton[9];
    boolean playerX= true;  //first turn is assigned to player X
    boolean draw=true;
    MyFrame() {
        frame = new JFrame();
        frame.setTitle("Prisha's TicTacToe Game");
        frame.setSize(420, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setBackground(Color.pink);
        panel.setLayout(new GridLayout(3, 3));

        for(int i=0;i<=8;i++){
            button[i]= new JButton();
            button[i].setBackground(Color.BLACK);
            button[i].setFont(new Font("Georgia",Font.PLAIN,40));
            button[i].addActionListener(this);
            panel.add(button[i]);
        }

        frame.add(panel);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<=8;i++){
            if(e.getSource()==button[i]){
                if(playerX){
                    button[i].setText("X");
                    button[i].setBackground(new Color(250,50,100));
                    playerX=false;
                    check();
                }
                else {
                    button[i].setText("O");
                    button[i].setBackground(new Color(10,100,100));
                    playerX=true;
                    check();
                }
            }
        }
    }
    public void check(){

        // checking win horizontally
        for(int i=0;i<7;i=i+3){
            if(button[i].getText()=="X"){
                if(button[i+1].getText()=="X" && button[i+2].getText()=="X"){
                    new X_wins();
                    frame.dispose();
                    draw=false;
                }
            }
            if(button[i].getText()=="O"){
                if(button[i+1].getText()=="O" && button[i+2].getText()=="O"){
                    new O_wins();
                    frame.dispose();
                    draw=false;
                }
            }
        }

        // checking win vertically
        for(int i=0;i<3;i++){
            if(button[i].getText()=="X"){
                if(button[i+3].getText()=="X" && button[i+6].getText()=="X"){
                    new X_wins();
                    frame.dispose();
                    draw=false;
                }
            }
            if(button[i].getText()=="O"){
                if(button[i+3].getText()=="O" && button[i+6].getText()=="O"){
                    new O_wins();
                    frame.dispose();
                    draw=false;
                }
            }
        }

        //checking win diagonally 1
        if(button[0].getText()=="X"){
            if(button[4].getText()=="X" && button[8].getText()=="X"){
                new X_wins();
                frame.dispose();
                draw=false;
            }
        }
        if(button[0].getText()=="O"){
            if(button[4].getText()=="O" && button[8].getText()=="O"){
                new O_wins();
                frame.dispose();
                draw=false;

            }
        }

        //checking win diagonally 2
        if(button[2].getText()=="X"){
            if(button[4].getText()=="X" && button[6].getText()=="X"){
                new X_wins();
                frame.dispose();
                draw=false;
            }
        }
        if(button[2].getText()=="O"){
            if(button[4].getText()=="O" && button[6].getText()=="O"){
                new O_wins();
                frame.dispose();
                draw=false;
            }
        }
        // checking condition for draw
        int sum=0;
        for(int i=0;i<9;i++){
            if( button[i].getText()=="X" || button[i].getText()=="O"){
            sum++;
            if(sum==9 && draw) {
                new no_wins();
                frame.dispose();
            }
            }
        }
    }

}
class X_wins implements ActionListener{
    JFrame winner;
    JPanel Panel;
    JLabel label;
    JButton quit;
    JButton play_again;
    X_wins(){
        winner= new JFrame();
        winner.setTitle("Result");
        winner.setSize(300, 300);
        winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winner.setResizable(false);
        winner.setLocationRelativeTo(null);

        Panel= new JPanel();
        Panel.setBackground(new Color(10,100,100));
        Panel.setLayout(null);

        label= new JLabel("X WINS!!");
        label.setFont(new Font("Georgia",Font.BOLD,40));
        label.setForeground(Color.RED);
        label.setBounds(50,30,200,90);

        quit= new JButton();
        quit.setText("Quit");
        quit.setBounds(100,130,100,50);
        quit.addActionListener(this);

        play_again= new JButton();
        play_again.setText("Play Again");
        play_again.setBounds(100,200,100,50);
        play_again.addActionListener(this);

        Panel.add(label);
        Panel.add(quit);
        Panel.add(play_again);
        winner.add(Panel);
        winner.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==quit){
            winner.dispose();
        }
        if(e.getSource()==play_again){
            winner.dispose();
            new MyFrame();
        }
    }
}
class O_wins implements ActionListener{
    JFrame winner;
    JPanel Panel;
    JLabel label;
    JButton quit;
    JButton play_again;
    O_wins(){
        winner= new JFrame();
        winner.setTitle("Result");
        winner.setSize(300, 300);
        winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winner.setResizable(false);
        winner.setLocationRelativeTo(null);

        Panel= new JPanel();
        Panel.setBackground(Color.PINK);
        Panel.setLayout(null);

        label= new JLabel("O WINS!!");
        label.setFont(new Font("Georgia",Font.BOLD,40));
        label.setForeground(Color.RED);
        label.setBounds(50,30,200,90);

        quit= new JButton();
        quit.setText("Quit");
        quit.setBounds(100,130,100,50);
        quit.addActionListener(this);

        play_again= new JButton();
        play_again.setText("Play Again");
        play_again.setBounds(100,200,100,50);
        play_again.addActionListener(this);

        Panel.add(label);
        Panel.add(quit);
        Panel.add(play_again);
        winner.add(Panel);
        winner.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==quit){
            winner.dispose();
        }
        if(e.getSource()==play_again){
            winner.dispose();
            new MyFrame();
        }
    }
}
class no_wins implements ActionListener{
    JFrame winner;
    JPanel Panel;
    JLabel label;
    JButton quit;
    JButton play_again;
    no_wins(){
        winner= new JFrame();
        winner.setTitle("Result");
        winner.setSize(300, 300);
        winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winner.setResizable(false);
        winner.setLocationRelativeTo(null);

        Panel= new JPanel();
        Panel.setBackground(new Color(250,255,150));
        Panel.setLayout(null);

        label= new JLabel("It's a draw..");
        label.setFont(new Font("Georgia",Font.BOLD,30));
        label.setForeground(Color.RED);
        label.setBounds(50,30,200,90);

        quit= new JButton();
        quit.setText("Quit");
        quit.setBounds(100,130,100,50);
        quit.addActionListener(this);

        play_again= new JButton();
        play_again.setText("Play Again");
        play_again.setBounds(100,200,100,50);
        play_again.addActionListener(this);

        Panel.add(label);
        Panel.add(quit);
        Panel.add(play_again);
        winner.add(Panel);
        winner.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==quit){
            winner.dispose();
        }
        if(e.getSource()==play_again){
            winner.dispose();
            new MyFrame();
        }
    }
}

