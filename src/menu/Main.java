package menu;

import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) {
        MarcoM miMarco = new MarcoM();
        JPanel miLamina = new LaminaMenu();

        miMarco.add(miLamina);
        miMarco.setVisible(true);
    }
    
}