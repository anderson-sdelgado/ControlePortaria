/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Color;

/**
 *
 * @author anderson
 */
public class CameraCTR {

    private Webcam webcam = null;
    private WebcamPanel panel = null;

    public CameraCTR() {
    }

    public void abrirCamera() {

        webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        panel = new WebcamPanel(webcam, false);
        panel.setPreferredSize(webcam.getViewSize());
        panel.setOpaque(true);
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, 0, 320, 240);

    }

    public WebcamPanel getPanel() {
        return panel;
    }

    public void startCamera() {
        panel.start();
    }

    public void stopCamera() {
        webcam.close();
        webcam.removeWebcamListener(panel); // ADD THIS LINE
        panel.stop();
    }

    public Webcam getWebcam() {
        return webcam;
    }
    
}
