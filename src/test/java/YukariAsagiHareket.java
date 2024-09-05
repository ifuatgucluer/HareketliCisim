import javax.swing.*;
import java.awt.*;

public class YukariAsagiHareket extends JPanel {

    // Dairenin başlangıç konumu
    int x = 100;
    int y = 0;

    // Dairenin hareket yönü (her güncellemede artacak)
    int deltaY = 5;  // Y ekseninde hareket hızı

    // Dairenin boyutu
    int daireBoyutu = 50;

    // Dairenin hareketini güncelleyen metot
    public void hareketEttir() {
        y += deltaY;

        // Eğer daire üst veya alt kenara ulaşırsa, yön değiştirir
        if (y + daireBoyutu > getHeight() || y < 0) {
            deltaY *= -1;  // Y ekseninde yön değişimi
        }

        // Ekranı tekrar çizer
        repaint();
    }

    // Grafik çizim metodu (daireyi çizmek için)
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillOval(x, y, daireBoyutu, daireBoyutu);
    }

    public static void main(String[] args) {
        JFrame pencere = new JFrame("Yukarı Aşağı Hareket Eden Daire");
        YukariAsagiHareket daire = new YukariAsagiHareket();

        pencere.add(daire);
        pencere.setSize(800, 600);
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pencere.setVisible(true);

        // Sonsuz döngüyle hareketi sürekli sağlar
        while (true) {
            daire.hareketEttir();
            try {
                Thread.sleep(20); // Hareket hızı (20 ms bekler)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
