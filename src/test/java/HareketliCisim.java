    import javax.swing.*;

    import java.awt.*;

    public class HareketliCisim extends JPanel {

        // Dairenin başlangıç konumu
        int x = 10;
        int y = 50;

        // Dairenin hareket ettirileceği yön (her güncellemede artacak)
        int deltaX = 9;

        // Dairenin boyutu
        int daireBoyutu = 30;

        // Dairenin hareketi güncelleyen metot
        public void hareketEttir() {
            x += deltaX; // x ekseninde hareket

            // Eğer daire sağ kenara ulaşırsa, sola geri döner
            if (x + daireBoyutu > getWidth()) {
                x = 0;
            }

            // Ekranı tekrar çizer
            repaint();
        }

        // Grafik çizim metodu (daireyi çizmek için)

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.fillOval(x, y, daireBoyutu, daireBoyutu);
        }

        public static void main(String[] args) {
            JFrame pencere = new JFrame("Hareket Eden Cisim");
            HareketliCisim cisim = new HareketliCisim();

            pencere.add(cisim);
            pencere.setSize(800, 400);
            pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pencere.setVisible(true);

            // Sonsuz döngüyle hareketi sürekli sağlar
            while (true) {
                cisim.hareketEttir();
                try {
                    Thread.sleep(50); // Hareket hızı (50 ms bekler)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

