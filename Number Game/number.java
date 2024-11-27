import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
public class number {
    public static void main(String args[]){
        JFrame frame=new JFrame();
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setTitle("Number Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.gray);
        JLabel label=new JLabel();
        label.setText("NUMBER GAME!");
        frame.add(label);
    }
}
