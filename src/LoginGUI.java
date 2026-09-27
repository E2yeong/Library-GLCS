import javax.swing.*;
import java.awt.*;
import LJY.BookList;

public class LoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private final BookList bookList;

    // 예시용 하드코딩 계정 정보
    private final String validUsername = "glcs";
    private final String validPassword = "glcs1234";

    public LoginGUI(BookList bookList) {
        // 메인 화면과 같은 BookList를 써야 관리자 변경 사항이 메인 창 종료 시 덮어써지지 않음
        this.bookList = bookList;

        setTitle("로그인");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("아이디:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("비밀번호:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginButton = new JButton("로그인");
        add(loginButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (username.equals(validUsername) && password.equals(validPassword)) {
                // 관리자 로그인 성공 시 BorrowHistoryGUI 호출
                new BorrowHistoryGUI(this.bookList, username);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 올바르지 않습니다.");
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
