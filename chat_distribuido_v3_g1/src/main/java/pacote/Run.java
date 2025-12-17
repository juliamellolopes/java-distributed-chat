package pacote;

import java.awt.Toolkit;

/**
 * @author julia
 */
public class Run {

    public static void main(String[] args) {
        FRMLogin frmlogin = new FRMLogin();
        frmlogin.setVisible(true);

        // para faze a caixa ficar no meio da tela
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        frmlogin.setBounds((toolkit.getScreenSize().width / 2) - (frmlogin.getWidth() / 2),
                (toolkit.getScreenSize().height / 2) - (frmlogin.getHeight() / 2), frmlogin.getWidth(), frmlogin.getHeight());

    }
}
