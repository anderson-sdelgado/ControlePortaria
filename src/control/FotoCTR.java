/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.github.sarxos.webcam.Webcam;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author anderson
 */
public class FotoCTR {

    private ImageIcon imageIcon;

    public FotoCTR() {
    }

    public boolean abrirFotoJPG(int id) throws IOException {
        File file = new File("C:\\Users\\anderson\\Documents\\Fotos\\" + id + ".jpg");
        if (file.exists()) {
            Image image = ImageIO.read(file);
            imageIcon = new ImageIcon(image);
            imageIcon.setImage(imageIcon.getImage().getScaledInstance(320, 240, 1));
            return true;
        } else {
            return false;
        }
    }

    public boolean abrirFotoBMP(int id) throws IOException {
        File file = new File("Q:\\Portaria\\Fotos\\" + id + ".bmp");
        if (file.exists()) {
            Image image = ImageIO.read(file);
            Icon icon = new ImageIcon(image);
            return true;
        } else {
            return false;
        }
    }

    public void salvarFotoJPG(Webcam webcam, int id) throws IOException {
        BufferedImage image = webcam.getImage();
        ImageIO.write(image, "JPG", new File("C:\\Users\\anderson\\Documents\\Fotos\\" + id + ".jpg"));
    }

    public void excluirFotoJPG(int id) {
        File file = new File("C:\\Users\\anderson\\Documents\\Fotos\\" + id + ".jpg");
        if (file.exists()) {
            file.delete();
        }
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

}
