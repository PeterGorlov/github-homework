package edu.javacourse.frame;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class HelloFrame extends JFrame {
    public HelloFrame() {
        JButton btn = new JButton("Say 'Hello'");

        // Вот наш пример анонимного класса
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello, world");
            }
        });

        // Кладем кнопку на СЕВЕР
        add(btn, BorderLayout.NORTH);
        // Задаем размеры формы
        setBounds(100, 100, 200, 100);
        // Устанавливаем свойство для закрытия приложения
        // при закрытии формы
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Делаем форму выидимой
        setVisible(true);
    }

    public static void main(String[] args) {
        HelloFrame hf = new HelloFrame();
    }
}
