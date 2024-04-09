package AWT_Intro;
import java.awt.*;
import java.util.Scanner;

public class MyFrame extends Frame {
    String title;
    String text;

    MyFrame(String title, String text, int width, int height) {
        this.text = text;
        this.title = title;

        super.setTitle(this.title);
        super.setSize(new Dimension(width, height));
        super.setVisible(true);
        this.addWindowListener(new MyWindowAdapter());
    }

    public void paint(Graphics g) {
        this.setBackground(new Color(0, 0, 0));
        Font f = new Font("Arial", Font.BOLD, 25);
        g.setFont(f);
        g.setColor(Color.WHITE);

        FontMetrics metrics = g.getFontMetrics(f);
        int textWidth = metrics.stringWidth(this.text);
        int x = (getWidth() - textWidth) / 2;
        int y = ((getHeight() + f.getSize()) / 2);
        g.drawString(this.text, x, y);
    }

    public static void main(String args[]) {
        int height, width;
        String title, text;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the title of window : ");
            title = sc.nextLine();
            System.out.print("Enter the text of window : ");
            text = sc.nextLine();
            System.out.print("Enter the height of window : ");
            height = sc.nextInt();
            System.out.print("Enter the width of window : ");
            width = sc.nextInt();
        }

        new MyFrame(title, text, width, height);
    }
}