import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class GUI extends Frame implements ActionListener {
    private int width;
    private int height;
    private Label message;
    private TextField field;

    public GUI(String title, int h, int w) {
        super(title);

        this.width = w;
        this.height = h;

        setSize(new Dimension(this.width, this.height));
        setLayout(new BorderLayout());

        Panel topPanel = new Panel();
        topPanel.setLayout(new FlowLayout());

        Label label = new Label("Enter your name");
        this.field = new TextField(20);
        this.message = new Label("", Label.CENTER);

        Button button = new Button("Submit");
        button.addActionListener(this);

        topPanel.add(label);
        topPanel.add(this.field);
        topPanel.add(button);

        add(topPanel, BorderLayout.NORTH);
        add(this.message, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = this.field.getText();
        this.message.setText(String.format("Hello, %s!", name));
    }

    public static void main(String[] args) {
        int h, w;
        String title;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the title : ");
            title = sc.nextLine();
            System.out.print("Enter the height : ");
            h = sc.nextInt();
            System.out.print("Enter the width : ");
            w = sc.nextInt();
        }

        new GUI(title, h, w);
    }
}
