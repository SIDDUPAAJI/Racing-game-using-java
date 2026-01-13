package sagar;

import javax.swing.*;
import java.awt.*;

public class SagarApp extends JFrame {
    public SagarApp() {
        setTitle("Sagar's Dice Race");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        DiceRace gamePanel = new DiceRace();
        add(gamePanel, BorderLayout.CENTER);

        JPanel controls = new JPanel();
        JButton p1Btn = new JButton("Player 1 Roll");
        JButton p2Btn = new JButton("Player 2 Roll");
        JButton resetBtn = new JButton("Reset");

        p1Btn.addActionListener(e -> gamePanel.rollPlayer1());
        p2Btn.addActionListener(e -> gamePanel.rollPlayer2());
        resetBtn.addActionListener(e -> gamePanel.resetGame());

        controls.add(p1Btn);
        controls.add(p2Btn);
        controls.add(resetBtn);
        add(controls, BorderLayout.SOUTH);

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SagarApp::new);
    }
}

class DiceRace extends JPanel {
    private int p1Pos = 0, p2Pos = 0;
    private int p1Roll = 0, p2Roll = 0;
    private final int FINISH_LINE = 30;
    private boolean gameOver = false;

    public DiceRace() { setBackground(Color.BLACK); }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int trackWidth = getWidth() - 200;
        int startX = 100;

        // Draw Finish Line
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(startX + trackWidth, 50, startX + trackWidth, 400);
        g2.setColor(Color.WHITE);
        g2.drawString("FINISH", startX + trackWidth - 20, 45);

        // Draw Tracks
        g2.setColor(Color.DARK_GRAY);
        g2.drawLine(startX, 150, startX + trackWidth, 150);
        g2.drawLine(startX, 300, startX + trackWidth, 300);

        // Draw Player Tokens (Moving based on score/position)
        // We map the score (0-30) to the pixel width of the track
        int p1VisualX = startX + (p1Pos * trackWidth / FINISH_LINE);
        int p2VisualX = startX + (p2Pos * trackWidth / FINISH_LINE);

        g2.setColor(Color.CYAN);
        g2.fillOval(p1VisualX - 15, 120, 30, 30);
        g2.drawString("P1", p1VisualX - 10, 110);

        g2.setColor(Color.MAGENTA);
        g2.fillOval(p2VisualX - 15, 270, 30, 30);
        g2.drawString("P2", p2VisualX - 10, 260);

        // Draw Dice
        drawDie(g2, p1Roll, 100, 420, Color.CYAN);
        drawDie(g2, p2Roll, 250, 420, Color.MAGENTA);

        // Victory Message
        if (gameOver) {
            g2.setFont(new Font("Arial", Font.BOLD, 40));
            g2.setColor(Color.YELLOW);
            String winner = p1Pos >= FINISH_LINE ? "PLAYER 1 WINS!" : "PLAYER 2 WINS!";
            g2.drawString(winner, getWidth()/2 - 150, getHeight()/2);
        }
    }

    private void drawDie(Graphics g, int val, int x, int y, Color c) {
        if (val == 0) return;
        g.setColor(Color.WHITE);
        g.fillRoundRect(x, y, 60, 60, 10, 10);
        g.setColor(c);
        g.drawRoundRect(x, y, 60, 60, 10, 10);
        g.setColor(Color.BLACK);
        if (val % 2 == 1) g.fillOval(x + 25, y + 25, 10, 10); // Center dot
        if (val > 1) { g.fillOval(x + 5, y + 5, 10, 10); g.fillOval(x + 45, y + 45, 10, 10); }
        if (val > 3) { g.fillOval(x + 45, y + 5, 10, 10); g.fillOval(x + 5, y + 45, 10, 10); }
        if (val == 6) { g.fillOval(x + 5, y + 25, 10, 10); g.fillOval(x + 45, y + 25, 10, 10); }
    }

    public void rollPlayer1() {
        if (!gameOver) {
            p1Roll = (int)(Math.random() * 6) + 1;
            p1Pos = Math.min(FINISH_LINE, p1Pos + p1Roll);
            if (p1Pos >= FINISH_LINE) gameOver = true;
            repaint();
        }
    }

    public void rollPlayer2() {
        if (!gameOver) {
            p2Roll = (int)(Math.random() * 6) + 1;
            p2Pos = Math.min(FINISH_LINE, p2Pos + p2Roll);
            if (p2Pos >= FINISH_LINE) gameOver = true;
            repaint();
        }
    }

    public void resetGame() {
        p1Pos = 0; p2Pos = 0; p1Roll = 0; p2Roll = 0;
        gameOver = false;
        repaint();
    }
}
