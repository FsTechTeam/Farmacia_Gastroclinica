/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gastroclinica;

import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Pablo López
 */
public class GastroClinica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.EmeraldDuskSkin");
        SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBottleGreenTheme");
        SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBubblesWatermark");
        SubstanceLookAndFeel.setCurrentWatermark("new SubstanceImageWatermark(“src//gastroclinica//Pencil-icon.png”)");
        Login obj = new Login();
        obj.show();
        
        
    }
    
}
