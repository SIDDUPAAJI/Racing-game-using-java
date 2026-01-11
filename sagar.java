package sagar;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class SagarApplet extends Applet implements ActionListener {

    private DiceGame game;
    private Button player1Btn;
    private Button player2Btn;

    @Override
    public void init() {
        setBackground(Color.black);
        setLayout(new BorderLayout());

        game = new DiceGame();
        add(game, BorderLayout.CENTER);

        Panel controls = new Panel(new FlowLayout());

        player1Btn = new Button("Player 1");
        player1Btn.addActionListener(this);

        player2Btn = new Button("Player 2");
        player2Btn.addActionListener(this);

        controls.add(player1Btn);
        controls.add(player2Btn);

        add(controls, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == player1Btn) {
            game.rollPlayer1();
        } else if (e.getSource() == player2Btn) {
            game.rollPlayer2();
        }
    }
}

/* ------------------------------------------------ */

class DiceGame extends Canvas {

    private int p1Score = 0;
    private int p2Score = 0;
    private int p1LastRoll = 0;
    private int p2LastRoll = 0;

    DiceGame() {
        setBackground(Color.black);
    }

    @Override
    public void paint(Graphics g) {
        drawBoard(g);
        drawDie(g, p1LastRoll, 80, 300);
        drawDie(g, p2LastRoll, 1020, 300);
        drawScores(g);
        checkWinner(g);
    }

    private void drawBoard(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 5, 1500, 10);

        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.BOLD, 15));
        g.drawString("FINISH LINE", 600, 20);
    }

    private void drawDie(Graphics g, int value, int x, int y) {
        g.setColor(Color.white);
        g.fillRoundRect(x, y, 100, 100, 20, 20);
        g.setColor(Color.red);
        g.drawRoundRect(x, y, 100, 100, 20, 20);

        g.setColor(Color.black);

        if (value > 1) g.fillOval(x + 10, y + 10, 20, 20);
        if (value > 3) g.fillOval(x + 60, y + 10, 20, 20);
        if (value == 6) g.fillOval(x + 10, y + 40, 20, 20);
        if (value % 2 == 1) g.fillOval(x + 35, y + 40, 20, 20);
        if (value == 6) g.fillOval(x + 60, y + 40, 20, 20);
        if (value > 3) g.fillOval(x + 10, y + 70, 20, 20);
        if (value > 1) g.fillOval(x + 60, y + 70, 20, 20);
    }

    private void drawScores(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.BOLD, 18));
        g.drawString("Player 1 Score: " + p1Score, 50, 50);
        g.drawString("Player 2 Score: " + p2Score, 1000, 50);
    }

    private void checkWinner(Graphics g) {
        if (p1Score >= 30 || p2Score >= 30) {
            g.setColor(Color.cyan);
            g.fillRoundRect(400, 250, 600, 120, 20, 20);

            g.setColor(Color.black);
            g.setFont(new Font("Serif", Font.BOLD, 30));

            String winner = (p1Score >= 30) ? "PLAYER 1 WINS!" : "PLAYER 2 WINS!";
            g.drawString(winner, 520, 320);
        }
    }

    void rollPlayer1() {
        if (p1Score < 30) {
            p1LastRoll = (int) (Math.random() * 6) + 1;
            p1Score += p1LastRoll;
            repaint();
        }
    }

    void rollPlayer2() {
        if (p2Score < 30) {
            p2LastRoll = (int) (Math.random() * 6) + 1;
            p2Score += p2LastRoll;
            repaint();
        }
    }
}
