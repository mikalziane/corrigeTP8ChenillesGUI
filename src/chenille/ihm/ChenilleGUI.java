package chenille.ihm;

import chenille.Anneau;
import chenille.Chenille;
import chenille.Tete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChenilleGUI extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private Chenille chenille;
    private ChenillePanel panel;
    private Timer timer;
    private JLabel positionLabel; // Label pour afficher la position

    public ChenilleGUI() {
        chenille = new Chenille(5, 10, 10);

        setTitle("Chenille Simulation");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panel = new ChenillePanel();
        add(panel, BorderLayout.CENTER);

        JButton startButton = new JButton("Start");
        positionLabel = new JLabel("Position: (10, 10)"); // Initialisation du label

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer == null || !timer.isRunning()) {
                    timer = new Timer(100, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            chenille.deplacer(panel.getWidth() / 20, panel.getHeight() / 20);
                            panel.repaint();
                            // Mise à jour de la position de la tête
                            Tete tete = chenille.tete();
                            positionLabel.setText("Position: (" + tete.x() + ", " + tete.y() + ")");
                        }
                    });
                    timer.start();
                    startButton.setText("Stop");
                } else {
                    timer.stop();
                    startButton.setText("Start");
                }
            }
        });

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(startButton, BorderLayout.EAST);
        buttonPanel.add(positionLabel, BorderLayout.WEST); // Ajout du label à gauche
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private class ChenillePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int scale = 20;
            int ringSize = scale;         // Size for body rings
            int headSize = (int)(scale * 1.3);  // Head 30% larger than rings

            // Draw body rings first (green with black border)
            g.setColor(Color.GREEN);
            for (Anneau anneau : anneaux()) {
                int x = anneau.x() * scale;
                int y = anneau.y() * scale;
                g.fillOval(x, y, ringSize, ringSize);
                g.setColor(Color.BLACK);
                g.drawOval(x, y, ringSize, ringSize);
                g.setColor(Color.GREEN);  // Reset for next ring
            }

            // Draw head last (red with black border) so it appears on top
            g.setColor(Color.RED);
            int headX = tete().x() * scale;
            int headY = tete().y() * scale;
            // Center the larger head
            headX -= (headSize - ringSize) / 2;
            headY -= (headSize - ringSize) / 2;
            g.fillOval(headX, headY, headSize, headSize);
            g.setColor(Color.BLACK);
            g.drawOval(headX, headY, headSize, headSize);
        }

        private Tete tete() { return chenille.tete(); }
        private Anneau[] anneaux() { return chenille.anneaux(); }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChenilleGUI gui = new ChenilleGUI();
            gui.setVisible(true);
        });
    }
}