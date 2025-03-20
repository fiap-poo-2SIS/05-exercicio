import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Util {

    private BilheteUnico[] bilhete = new BilheteUnico[5];
    private int index = 0;

    public void menuPrincipal() {
        int opcao = 0;
        String menu = "1. Administrador\n2. Usuário\n3. Finalizar";

        do {
            opcao = parseInt(showInputDialog(menu));
            if(opcao < 1 || opcao > 3) {
                showMessageDialog(null, "Opção inválida");
            }
            else {
                switch(opcao) {
                    case 1:
                        menuAdministrador();
                        break;
                }
            }
        } while(opcao != 3);
    }

    private void menuAdministrador() {
        int opcao;
        String menuAdmin = "1. Emitir bilhete\n";
        menuAdmin += "2. Listar bilhetes\n";
        menuAdmin += "3. Remover bilhetes\n";
        menuAdmin += "4. Sair\n";

        do {
            opcao = parseInt(showInputDialog(menuAdmin));
            if(opcao < 1 || opcao > 4) {
                showMessageDialog(null, "Opção inválido");
            }
            else {
                switch(opcao) {
                    case 1:
                        emitirBilhete();
                        break;
                }
            }
        } while(opcao != 4);
    }

    private void emitirBilhete() {
        String nome;
        long cpf;
        String perfil;

        if(index < bilhete.length) {
            nome = showInputDialog("Nome:");
            cpf = parseLong(showInputDialog("CPF"));
            perfil = showInputDialog("Estudante ou Professor ou Comum");
            bilhete[index] = new BilheteUnico(new Usuario(nome, cpf, perfil));
            index++;
        }
    }
}
