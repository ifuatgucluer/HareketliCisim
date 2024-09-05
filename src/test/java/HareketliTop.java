import javax.swing.*;
import java.awt.*;

public class HareketliTop extends JPanel {

    // Topun başlangıç konumu
    int x = 0;
    int y = 0;

    // Topun hareket yönü (her güncellemede artacak)
    int deltaX = 5;  // X ekseninde hareket hızı
    int deltaY = 3;  // Y ekseninde hareket hızı

    // Topun boyutu
    int topBoyutu = 50;

    // Topun hareketini güncelleyen metot
    public void hareketEttir() {
        x += deltaX;
        y += deltaY;

        // Eğer top pencerenin kenarlarına çarparsa, yön değiştirir
        if (x + topBoyutu > getWidth() || x < 0) {
            deltaX *= -1;  // X ekseninde yön değişimi
        }
        if (y + topBoyutu > getHeight() || y < 0) {
            deltaY *= -1;  // Y ekseninde yön değişimi
        }

        // Ekranı tekrar çizer
        repaint();
    }

    // Grafik çizim metodu (topu çizmek için)
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, topBoyutu, topBoyutu);
    }

    public static void main(String[] args) {
        JFrame pencere = new JFrame("Hareket Eden Top");
        HareketliTop top = new HareketliTop();

        pencere.add(top);
    }
}