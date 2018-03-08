package F;

import java.io.File;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Jfilechoiser {

    public static String SaveFile(String FileType, String ExstensionFile) {
        String FileLocation = null;
        JFrame parentFrame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                FileType, ExstensionFile);
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Specify a file to save");
        int userSelection = fileChooser.showSaveDialog(parentFrame);
        if (userSelection == APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            FileLocation = fileToSave.getAbsolutePath() + ExstensionFile;
        } else {
            showMessageDialog(null, "Batal Memilih File ");
        }
        return FileLocation;
    }

    public static String ReadFile(String FileType, String ExstensionFile) {
        String FileLocation = null;
        JFrame parentFrame = new JFrame();
        final JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(FileType,
                ExstensionFile);
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(parentFrame);
        if (returnVal == APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            FileLocation = file.getAbsolutePath();
        } else {
            showMessageDialog(null, "Batal Memilih File ");
        }
        return FileLocation;
    }

    private Jfilechoiser() {
    }
}
